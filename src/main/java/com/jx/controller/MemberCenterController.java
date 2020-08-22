package com.jx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Card;
import com.jx.entity.SysUser;
import com.jx.entity.SystemSet;
import com.jx.entity.Token;
import com.jx.service.CardService;
import com.jx.service.SysUserService;
import com.jx.service.SystemSetService;
import com.utils.Response;
import com.utils.StringUtils;
import com.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/3 19:13
 */
@Slf4j

@RestController
public class MemberCenterController {

    @Resource
    private HttpServletRequest request;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private CardService cardService;
    @Resource
    private SystemSetService systemSetService;

    @Auth(user = "member,company")
    @RequestMapping(value = "/getMemberCenter", method = RequestMethod.POST)
    public Map<String, Object> getMemberCenter() {
        Map<String, Object> result = new HashMap<>(16);
        String token = request.getHeader("Authorization");
        String companyId;
        if (token == null) {
            companyId = "999";
            result.put("user", null);
        } else {
            Token tokenObj = TokenUtils.getTokenObj(token);
            Objects.requireNonNull(tokenObj);
            companyId = StringUtils.isEmpty(tokenObj.getCompanyId()) ? "999" : tokenObj.getCompanyId();
            SysUser sysUser = sysUserService.getById(tokenObj.getUserId());
            HashMap<String, Object> user = new HashMap<>(16);
            user.put("userName", sysUser.getName());
            user.put("roleId", sysUser.getRoleId());
            user.put("memberLevel", sysUser.getMemberLevel());
            user.put("companyLevel", sysUser.getCompanyLevel());
            result.put("user", user);
        }
        List<Card> list = cardService.list(new QueryWrapper<Card>().eq(Card.COL_COMPANY_ID, companyId).eq(Card.COL_DELETED, 0));
        List<Map<String, Object>> cards = new ArrayList<>();
        for (Card card : list) {
            HashMap<String, Object> temp = new HashMap<>(16);
            temp.put("cardName", card.getBankName() + "-" + card.getName());
            temp.put("normalMemberPrice", card.getMemberNormal().multiply(new BigDecimal("10000")).divide(card.getLimitLine(), 2, BigDecimal.ROUND_DOWN));
            temp.put("goldMemberPrice", card.getMemberGold().multiply(new BigDecimal("10000")).divide(card.getLimitLine(), 2, BigDecimal.ROUND_DOWN));
            temp.put("diamondMemberPrice", card.getMemberDiamond().multiply(new BigDecimal("10000")).divide(card.getLimitLine(), 2, BigDecimal.ROUND_DOWN));
            cards.add(temp);
        }
        result.put("cards", cards);
        SystemSet systemSet = systemSetService.getOne(new QueryWrapper<SystemSet>().eq(SystemSet.COL_ID, 1));
        Map<String, Object> price = new HashMap<>(6);
        price.put("goldPrice", systemSet.getMemberUpgradeGoldPrice());
        price.put("diamondPrice", systemSet.getMemberUpgradeDiamondPrice());
        price.put("normalCompanyPrice", systemSet.getCompanyNormalUpgradePrice());
        price.put("advancedCompanyPrice", systemSet.getCompanyAdvancedUpgradePrice());
        price.put("superCompanyPrice", systemSet.getCompanySuperUpgradePrice());
        result.put("price", price);
        return Response.success(result);
    }

}
