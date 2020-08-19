package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.OrderForm;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.SysUserService;
import com.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 系统用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-07-17 11:50:42
 */
@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 请求对象
     */
    @Resource
    private HttpServletRequest request;

    /**
     * 通过主键查询单条数据
     *
     * @param param {id:主键}
     * @return 单条数据
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById(@RequestBody JSONObject param) {
        return this.sysUserService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param sysUser        实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(SysUser sysUser, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.sysUserService.queryAllByLimit(sysUser, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param sysUser        实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/listNot", method = RequestMethod.GET)
    public Map<String, Object> listNot(SysUser sysUser, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.sysUserService.queryAllByLimitNot(sysUser, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody SysUser sysUser) {
        return this.sysUserService.insert(request.getHeader("Authorization"), sysUser);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param sysUser 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody SysUser sysUser) {
        return this.sysUserService.update(request.getHeader("Authorization"), sysUser);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param sysUser 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody SysUser sysUser) {
        return this.sysUserService.updateAllColumn(request.getHeader("Authorization"), sysUser);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.sysUserService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 用户积分升级
     *
     * @return 升级结果
     */
    @Auth(user = "member")
    @RequestMapping(value = "/pointUpgrade", method = RequestMethod.POST)
    public Map<String, Object> pointUpgrade() {
        return this.sysUserService.pointUpgrade(request.getHeader("Authorization"));
    }

    public TreeMap<String, String> getH5Pay(HttpServletRequest req, String orderId, String money, String openId, String desc, String attach) {
        TreeMap<String, String> h5PayArgs = null;
        try {
            String ip = RequestUtils.getIpAddr(req);
            if (StringUtils.isEmpty(ip)) {
                ip = "127.0.0.1";
            }
            String rsXml = WxUtils.JsApiPayUnifiedOrder(orderId, money, ip, openId, desc, attach);
            Map<String, String> rs = WxUtils.parserJsApiPayUnifiedOrderResult(rsXml);
            String prepay_id = rs.get("prepay_id");
            if (prepay_id != null) {
                h5PayArgs = new TreeMap<String, String>();
                h5PayArgs.put("appId", WxUtils.AppID);
                h5PayArgs.put("timeStamp", String.valueOf(System.currentTimeMillis()));
                h5PayArgs.put("nonceStr", UUIDUtils.generate());
                h5PayArgs.put("package", "prepay_id=" + prepay_id);
                h5PayArgs.put("signType", "MD5");
                h5PayArgs = WxUtils.argSign(h5PayArgs);
                h5PayArgs.put("paySign", h5PayArgs.get("sign"));
                h5PayArgs.remove("sign");
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf("WeiXinPayment") > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return h5PayArgs;
    }

    /**
     * 会员充值升级 假定已经支付成功
     *
     * @param param {"wxPaymentId","wxPaymentAmount","targetLevel"}
     * @return 升级结果
     */
    @Auth(user = "member")
    @RequestMapping(value = "/moneyUpgrade", method = RequestMethod.POST)
    public Map<String, Object> moneyUpgrade(@RequestBody JSONObject param) {
        String targetLevel = param.getString("targetLevel");
        OrderForm order = OrderUtils.createMemberUpgradeOrder(request.getHeader("Authorization"), "moneyUpgrade", ConstantPool.ORDER_MEMBER_UPGRADE_TYPE);
        Token token = TokenUtils.getTokenObj(request.getHeader("Authorization"));
        if (token.getOpenId() == null || StringUtils.isEmpty(token.getOpenId())) {
            return Response.fail(ErrorItem.USER_NOT_BIND_WX);
        }
        order = sysUserService.createdUpGrade(order, targetLevel, 1);
        if (Integer.valueOf(ConstantPool.ORDER_FORM_REVIEW_FAIL).equals(order.getAuditState())) {
            return Response.fail(order.getAuditContent());
        }
        order.insert();
        return Response.success(getH5Pay(request, order.getId(), String.valueOf(order.getWxPaymentAmount()), token.getOpenId(), "会员-升级", "member_upgrade" + targetLevel));
    }

    /**
     * 盟主充值升级 假定已经支付成功
     *
     * @param param {"wxPaymentId","wxPaymentAmount","targetLevel"}
     * @return 升级结果
     */
    @Auth(user = "member,company")
    @RequestMapping(value = "/moneyUpgradeCompany", method = RequestMethod.POST)
    public Map<String, Object> moneyUpgradeCompany(@RequestBody JSONObject param) {
        String targetLevel = param.getString("targetLevel");
        OrderForm order = OrderUtils.createMemberUpgradeOrder(request.getHeader("Authorization"), "moneyUpgrade", ConstantPool.ORDER_COMPANY_UPGRADE_TYPE);
        Token token = TokenUtils.getTokenObj(request.getHeader("Authorization"));
        if (token.getOpenId() == null || StringUtils.isEmpty(token.getOpenId())) {
            return Response.fail(ErrorItem.USER_NOT_BIND_WX);
        }
        order = sysUserService.createdUpGrade(order, targetLevel, 2);
        if (Integer.valueOf(ConstantPool.ORDER_FORM_REVIEW_FAIL).equals(order.getAuditState())) {
            return Response.fail(order.getAuditContent());
        }
        order.insert();
        return Response.success(getH5Pay(request, order.getId(), String.valueOf(order.getWxPaymentAmount()), token.getOpenId(), "盟主-升级", "company_upgrade" + targetLevel));
    }

    /**
     * 根据token获取下级
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @Auth(user = "member,company")
    @RequestMapping(value = "/getLowLevelByPage", method = RequestMethod.POST)
    public Map<String, Object> getLowLevelByPage(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(sysUserService.getLowLevelByPage(token, currentPage, pageSize));
    }

    /**
     * 根据token获取间接下级
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @Auth(user = "member,company")
    @RequestMapping(value = "/getSubLowLevelByPage", method = RequestMethod.POST)
    public Map<String, Object> getSubLowLevelByPage(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(sysUserService.getSubLowLevelByPage(token, currentPage, pageSize));
    }

    /**
     * 获取朋友页
     *
     * @return 结果
     */
    @RequestMapping(value = "/getFriends", method = RequestMethod.POST)
    public Map<String, Object> getFriends() {
        String token = request.getHeader("Authorization");
        List<SysUser> lowLevelByPage = sysUserService.getLowLevelByPage(token, null, null);
        List<SysUser> subLowLevelByPage = sysUserService.getSubLowLevelByPage(token, null, null);
        Map<String, Object> result = new HashMap<>(16);
        result.put("lowLevel", PackageUtil.userPackage(lowLevelByPage));
        result.put("subLowLevel", PackageUtil.userPackage(subLowLevelByPage));
        result.put("lowCount", lowLevelByPage.size());
        result.put("subCount", subLowLevelByPage.size());
        return Response.success(result);
    }

    /**
     * 修改密码
     *
     * @param params {“id”,"password"}
     * @return 结果
     */
    @RequestMapping(value = "/resetPass", method = RequestMethod.POST)
    public Map<String, Object> resetPass(@RequestBody JSONObject params) {
        return this.sysUserService.resetPass(params.getString("userId"), params.getString("password"));
    }

    /**
     * 获取我的推荐码
     *
     * @return 二维码地址以及 推荐码
     */
    @Auth(user = "member,company")
    @RequestMapping(value = "/getMyQrCode", method = RequestMethod.POST)
    public Map<String, Object> getMyQrCode() {
        return this.sysUserService.getMyQrCode(request.getHeader("Authorization"));
    }

    /**
     * 获取我的推荐码
     *
     * @return 二维码地址以及 推荐码
     */
    @Auth(user = "member,company")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Map<String, Object> getUserInfo() {
        Map<String, Object> result = Response.success();
        Token tokenObj = TokenUtils.getTokenObj(request.getHeader("Authorization"));
        SysUser sysUser = sysUserService.getById(tokenObj.getUserId());

        String unEnPhone = sysUser.getPhone();
        if (!StringUtils.isEmpty(unEnPhone) && unEnPhone.length() == 11) {
            result.put("phoneNumber", unEnPhone.substring(0, 3) + "****" + unEnPhone.substring(7));
        }
        result.put("roleName", sysUser.getRoleName() == null ? "" : sysUser.getRoleName());
        result.put("memberLevel", sysUser.getMemberLevel() == null ? "" : sysUser.getMemberLevel());
        result.put("companyLevel", sysUser.getCompanyLevel() == null ? "" : sysUser.getCompanyLevel());
        result.put("headUrl", sysUser.getHeadUrl() == null ? "" : sysUser.getHeadUrl());
        result.put("name", sysUser.getName() == null ? "" : sysUser.getName());
        result.put("roleId", sysUser.getRoleId() == null ? "" : sysUser.getRoleId());

        return result;
    }

    @RequestMapping(value = "/getInfoByToken", method = RequestMethod.POST)
    public Map<String, Object> getInfoByToken() {
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.TOKEN_INVALID);
        }
        String userId = tokenObj.getUserId();
        SysUser user = sysUserService.getById(userId);
        return PackageUtil.userPackage(user);
    }

    /**
     * 邀请好友
     *
     * @param params {"phoneNumber","password","parentId","phoneCode"}
     * @return res
     */
    @PostMapping("/invite")
    public Map<String, Object> invite(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        Objects.requireNonNull(tokenObj);
        String userId = tokenObj.getUserId();
        SysUser user = sysUserService.getById(userId);
        String inviteCode = user.getInviteCode();
        Map<String, Object> map = new HashMap<>(4);
        map.put("phoneNumber", params.getString("phoneNumber"));
        map.put("password", params.getString("password"));
        map.put("parentId", inviteCode);
        map.put("phoneCode", params.getString("phoneCode"));
        return sysUserService.register(new JSONObject(map));
    }

}