package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.OrderForm;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/1 10:01
 */
@Slf4j
@RestController
public class UserUpgradeWx {
    /**
     * 用户升级调起微信支付
     *
     * @param money       money
     * @param targetLevel 目标等级
     * @param request     re
     * @return json
     */
    @RequestMapping(value = "/testUserUpgradeWx", method = RequestMethod.GET)
    public String testUserUpgradeWx(String money, String targetLevel, HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>(16);
        //用户ID
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        Objects.requireNonNull(tokenObj);
        String userId = tokenObj.getUserId();
        TreeMap<String, String> h5PayArgs;
        SysUser sysUser = new SysUser();
        sysUser = sysUser.selectOne(new QueryWrapper<SysUser>().eq(SysUser.COL_ID, userId));
        if (sysUser == null) {
            log.error("全局流水[{}]用户ID错误", userId);
            return JSONObject.toJSONString(Response.fail(ErrorItem.USER_NOT_EXISTENCE));
        }
        String openId = sysUser.getOpenId();
        OrderForm order = OrderUtils.createMemberUpgradeOrder(token, "会员-升级", ConstantPool.ORDER_MEMBER_UPGRADE_TYPE);
        order.insertOrUpdate();
        h5PayArgs = getH5Pay(request, order.getId(), String.valueOf(money), openId, "会员-升级", "member_upgrade" + token + targetLevel);
        return JSONObject.toJSONString(h5PayArgs);
    }

    /**
     * 用户升级调起微信支付
     *
     * @param param{"money","targetLevel"}
     * @param request                      re
     * @return json
     */
    @RequestMapping(value = "/userUpgradeWx", method = RequestMethod.POST)
    public String userUpgradeWx(@RequestBody JSONObject param, HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>(16);
        //用户ID
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        Objects.requireNonNull(tokenObj);
        String userId = tokenObj.getUserId();
        BigDecimal money = param.getBigDecimal("money");
        String targetLevel = param.getString("targetLevel");
        TreeMap<String, String> h5PayArgs;
        SysUser sysUser = new SysUser();
        sysUser = sysUser.selectOne(new QueryWrapper<SysUser>().eq(SysUser.COL_ID, userId));
        if (sysUser == null) {
            log.error("全局流水[{}]用户ID错误", userId);
            return JSONObject.toJSONString(Response.fail(ErrorItem.USER_NOT_EXISTENCE));
        }
        String openId = sysUser.getOpenId();
        OrderForm order = OrderUtils.createMemberUpgradeOrder(request.getHeader("Authorization"), "会员升级", ConstantPool.ORDER_MEMBER_UPGRADE_TYPE);
        order.insertOrUpdate();
        h5PayArgs = getH5Pay(request, order.getId(), String.valueOf(money), openId, "会员升级", "member_upgrade" + token + targetLevel);
        return JSONObject.toJSONString(h5PayArgs);
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

}
