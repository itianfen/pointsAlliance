package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Card;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.BankService;
import com.jx.service.CardService;
import com.jx.service.SysUserService;
import com.utils.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 银行卡(Card)表控制层
 *
 * @author makejava
 * @since 2020-07-27 16:31:26
 */
@RestController
@RequestMapping("card")
public class CardController {
    /**
     * 服务对象
     */
    @Resource
    private CardService cardService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private BankService bankService;

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
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById(@RequestBody JSONObject param) {
        return this.cardService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param card           实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Card card, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.cardService.queryAllByLimit(request.getHeader("Authorization"), card, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param card 实体类
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Card card) {
        return this.cardService.insert(request.getHeader("Authorization"), card);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param card 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Card card) {
        return this.cardService.update(request.getHeader("Authorization"), card);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param card 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Card card) {
        return this.cardService.updateAllColumn(request.getHeader("Authorization"), card);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.cardService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 根据token查询card分页
     *
     * @param param {currentPage,pageSize}
     * @return list
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/getListPage", method = RequestMethod.POST)
    public Map<String, Object> getListPage(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(cardService.getListPage(currentPage, pageSize, token));
    }

    /**
     * 根据银行ID获取卡片
     *
     * @param params {"bankId"}
     * @return list
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/getCardByBankId", method = RequestMethod.POST)
    public Map<String, Object> getCardByBankId(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        String companyId = "999";
        SysUser sysUser;
        if (tokenObj != null) {
            if (ConstantPool.COMPANY_ROLE_ID.equals(tokenObj.getRoleId())) {
                companyId = tokenObj.getUserId();
            } else {
                companyId = StringUtils.isNotEmpty(tokenObj.getCompanyId()) ? tokenObj.getCompanyId() : "999";
            }
        }
        sysUser = new SysUser();
        sysUser.setRoleId("2");
        sysUser.setMemberLevel(1);
        String bankId = params.getString("bankId");
        List<Card> list = cardService.list(new QueryWrapper<Card>().eq(Card.COL_BANK_ID, bankId).eq(Card.COL_COMPANY_ID, companyId).eq(Card.COL_DELETED, 0));

        Map<String, Object> result = Response.success(PackageUtil.cardListPackage(list, sysUser));
        result.put("bankMsg", bankService.getById(bankId));
        return result;
    }
}