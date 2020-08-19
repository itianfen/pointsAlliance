package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.*;
import com.jx.service.BankService;
import com.jx.service.CardService;
import com.jx.service.OrderFormService;
import com.jx.service.SysUserService;
import com.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 订单表(OrderForm)表控制层
 *
 * @author makejava
 * @since 2020-07-24 14:50:58
 */
@Slf4j
@RestController
@Auth(user = "admin,member,company")
@RequestMapping("orderForm")
public class OrderFormController {
    private final CapitalUtils capitalUtils = new CapitalUtils();
    /**
     * 服务对象
     */
    @Resource
    private OrderFormService orderFormService;
    @Resource
    private BankService bankService;
    @Resource
    private CardService cardService;
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
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById(@RequestBody JSONObject param) {
        return this.orderFormService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param orderForm      实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(OrderForm orderForm, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.orderFormService.queryAllByLimit(orderForm, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param orderForm 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody OrderForm orderForm) {
        return this.orderFormService.insert(request.getHeader("Authorization"), orderForm);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param orderForm 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody OrderForm orderForm) {
        return this.orderFormService.update(request.getHeader("Authorization"), orderForm);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param orderForm 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody OrderForm orderForm) {
        return this.orderFormService.updateAllColumn(request.getHeader("Authorization"), orderForm);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.orderFormService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 根据token和type查询订单带分页
     *
     * @param param {type,currentPage,pageSize}
     */
    @RequestMapping(value = "/queryByTypeAndToken", method = RequestMethod.POST)
    public Map<String, Object> queryByTypeAndToken(@RequestBody JSONObject param) {
        return Response.success(orderFormService.queryByTypeAndToken(request.getHeader("Authorization"), param.getInteger("type"), param.getInteger("currentPage"), param.getInteger("pageSize")));
    }

    /**
     * 创建积分兑换订单
     *
     * @param params {"cardId"}
     * @return result
     */
    @RequestMapping(value = "/createPointExchangeOrder", method = RequestMethod.POST)
    public Map<String, Object> createPointExchangeOrder(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        Token tokenObj = TokenUtils.getTokenObj(token);
        Objects.requireNonNull(tokenObj);
        SysUser correctUser = sysUserService.getById(tokenObj.getUserId());
        OrderForm order = OrderUtils.baseOrder(token);
        String cardId = params.getString("cardId");
        Card card = cardService.getOne(new QueryWrapper<Card>().eq(Card.COL_ID, cardId));

        //查兑换类型
        Integer exchangeType = card.getExchangeType();
        QueryWrapper<OrderForm> queryWrapper = new QueryWrapper<>();
        queryWrapper = OrderQuery.convert(queryWrapper, exchangeType);
        queryWrapper.in(OrderForm.COL_AUDIT_STATE, 2, 3);
        queryWrapper.eq(OrderForm.COL_USER_ID, correctUser.getId());
        queryWrapper.eq(OrderForm.COL_CARD_ID, cardId);
        List<OrderForm> list = orderFormService.list(queryWrapper);
        Integer exchangeCount = card.getExchangeCount();
        if (exchangeType.compareTo(0) != 0) {
            if (list.size() >= exchangeCount) {
                return Response.fail(ErrorItem.CARD_EXCHANGE_COUNT_MAX);
            }
        }

        Bank bank = bankService.getById(card.getBankId());
        order.setBankId(bank.getId());
        order.setBankName(bank.getName());
        order.setBankImg(bank.getIconPath());
        order.setCardId(cardId);
        order.setCardName(card.getName());
        order.setItemType(card.getService());
        order.setItemContent(card.getName());
        order.setSpendPoint(card.getLimitLine());
        order.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_IN_REVIEW));
        order.setOrderType(Integer.parseInt(ConstantPool.ORDER_EXCHANGE_TYPE));
        order.insertOrUpdate();
        return Response.success();
    }

    /**
     * 根据类型查询订单
     *
     * @param params {currentPage,pageSize,type}
     * @return result
     */
    @RequestMapping(value = "/getOrderByType", method = RequestMethod.POST)
    public Map<String, Object> getOrderByType(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        Integer currentPage = params.getInteger("currentPage");
        Integer pageSize = params.getInteger("pageSize");
        Integer type = params.getInteger("type");
        Integer[] types = {type};
        return Response.success(orderFormService.getOderByType(token, currentPage, pageSize, types));
    }

    /**
     * 获得全部订单
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.POST)
    public Map<String, Object> getAllOrder(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(orderFormService.getAllOrder(token, currentPage, pageSize));
    }

    /**
     * 获得待审核订单
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getWaitReviewOrder", method = RequestMethod.POST)
    public Map<String, Object> getWaitReviewOrder(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(orderFormService.getWaitReviewOrder(token, currentPage, pageSize));
    }

    /**
     * 获得审核成功订单
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getReviewSuccessOrder", method = RequestMethod.POST)
    public Map<String, Object> getReviewSuccessOrder(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(orderFormService.getReviewSuccessOrder(token, currentPage, pageSize));
    }

    /**
     * 获得审核失败订单
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getReviewFailOrder", method = RequestMethod.POST)
    public Map<String, Object> getReviewFailOrder(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(orderFormService.getReviewFailOrder(token, currentPage, pageSize));
    }

    /**
     * 创建提现订单
     *
     * @param params {"money"}
     * @return result
     */
    @RequestMapping(value = "createWithdraw", method = RequestMethod.POST)
    public Map<String, Object> createWithdraw(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        SysUser user = sysUserService.getById(TokenUtils.getTokenObj(token).getUserId());
        BigDecimal money = new BigDecimal(params.getString("money"));
        if (user.getBalance().compareTo(money) >= 0) {
            OrderForm withdrawOrder = OrderUtils.createWithdrawOrder(token, "", ConstantPool.ORDER_WITHDRAW_TYPE, String.valueOf(money));
            withdrawOrder.insert();
            user.setBalance(user.getBalance().subtract(money));
            user.updateById();
            return Response.success(ErrorItem.WITHDRAW_APPLY_SUCCESS);
        } else {
            return Response.fail(ErrorItem.WITHDRAW_BALANCE_NOT_ENOUGH);
        }
    }

    /**
     * 提现审核失败
     *
     * @param params {"orderId","content"}
     * @return result
     */
    @RequestMapping(value = "withdrawFail", method = RequestMethod.POST)
    public Map<String, Object> withdrawFail(@RequestBody JSONObject params) {
        String orderId = params.getString("orderId");
        String content = params.getString("content");
        OrderForm orderForm = orderFormService.getById(orderId);
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_REVIEW_FAIL));
        orderForm.setAuditContent(content);
        BigDecimal money = orderForm.getGetMoney();
        SysUser user = sysUserService.getById(orderForm.getUserId());
        user.setBalance(user.getBalance().add(money));
        user.updateById();
        orderForm.updateById();
        return Response.success();
    }

    /**
     * 提现审核成功
     *
     * @param params {"orderId"}
     * @return result
     */
    @RequestMapping(value = "withdrawSuccess", method = RequestMethod.POST)
    public Map<String, Object> withdrawSuccess(@RequestBody JSONObject params) {
        String orderId = params.getString("orderId");
        OrderForm orderForm = orderFormService.getById(orderId);
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_REVIEW_SUCCESS));
        SysUser user = sysUserService.getById(orderForm.getUserId());
        capitalUtils.addCapital(user, user.getId(), ConstantPool.WITHDRAW, BigDecimal.ZERO, orderForm.getGetMoney(), orderForm.getId(), "withdraw");
        orderForm.updateById();
        return Response.success();
    }

    /**
     * 获取提现订单列表
     *
     * @param params {"currentPage","pageSize"}
     * @return list
     */
    @RequestMapping(value = "getWithdrawOrder", method = RequestMethod.POST)
    public Map<String, Object> getWithdrawOrder(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        Integer currentPage = params.getInteger("currentPage");
        Integer pageSize = params.getInteger("pageSize");
        return Response.success(orderFormService.getWithdrawOrder(token, currentPage, pageSize));
    }
}