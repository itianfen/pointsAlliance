package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.OrderFormDao;
import com.jx.entity.OrderForm;
import com.jx.entity.Token;
import com.jx.service.OrderFormService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 订单表(OrderForm)表服务实现类
 *
 * @author makejava
 * @since 2020-07-24 14:50:58
 */
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormDao, OrderForm> implements OrderFormService {
    @Resource
    private OrderFormDao orderFormDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> queryById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        OrderForm orderForm = this.orderFormDao.queryById(id);
        if (orderForm == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(orderForm);
    }

    /**
     * 查询多条数据
     *
     * @param orderForm      实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(OrderForm orderForm, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
        if (page == null || limit == null) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (preciseOrFuzzy == null) {
            preciseOrFuzzy = 1;
        }
        if (page < 1) {
            page = 1;
        }
        long offset = (page - 1) * limit;
        //时间范围
        Date begin = null, end = null;
        if (StringUtils.isNotEmpty(timeArea)) {
            String[] times = timeArea.split("~");
            begin = DateFormatUtils.parseDateString(times[0], DateFormatUtils.defaultFormat);
            end = DateFormatUtils.parseDateString(times[1], DateFormatUtils.defaultFormat);
        }
        if (orderForm == null) {
            orderForm = new OrderForm();
        }
        orderForm.setDeleted(0);
        //列表
        List<OrderForm> list = this.orderFormDao.queryAllByLimit(orderForm, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.orderFormDao.countByParam(orderForm, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param orderForm 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, OrderForm orderForm) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        orderForm.setId(UUIDUtils.generate());
        orderForm.setCreatedTime(now);
        orderForm.setLastUpdateTime(now);
        orderForm.setCreator(tokenObj.getUserName());
        orderForm.setCreatorId(tokenObj.getUserId());
        orderForm.setLastUpdater(tokenObj.getUserName());
        orderForm.setLastUpdateId(tokenObj.getUserId());
        orderForm.setDeleted(0);
        if (this.orderFormDao.insert(orderForm) > 0) {
            return Response.success(orderForm);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param orderForm 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, OrderForm orderForm) {
        if (StringUtils.isEmpty(token, orderForm.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        orderForm.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        orderForm.setLastUpdater(tokenObj.getUserName());
        orderForm.setLastUpdateId(tokenObj.getUserId());
        orderForm.setDeleted(0);
        if (this.orderFormDao.update(orderForm) > 0) {
            return this.queryById(orderForm.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param orderForm 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, OrderForm orderForm) {
        if (StringUtils.isEmpty(token, orderForm.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        orderForm.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        orderForm.setLastUpdater(tokenObj.getUserName());
        orderForm.setLastUpdateId(tokenObj.getUserId());
        orderForm.setDeleted(0);
        if (this.orderFormDao.updateAllColumn(orderForm) > 0) {
            return Response.success(this.queryById(orderForm.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键列表 字符串根据,分隔
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deleteById(String token, String id) {
        if (StringUtils.isEmpty(token, id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //转为换维数组格式
        String[] idArr = id.split(",");
        List<String> idList = new ArrayList<>();
        Collections.addAll(idList, idArr);
        //逻辑删除
        if (this.orderFormDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 根据token和type查询订单
     *
     * @param token       token
     * @param type        type
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    @Override
    public List<OrderForm> queryByTypeAndToken(String token, Integer type, Integer currentPage, Integer pageSize) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        Objects.requireNonNull(tokenObj);
        QueryWrapper<OrderForm> orderFormQueryWrapper = new QueryWrapper<>();
        orderFormQueryWrapper.eq(OrderForm.COL_USER_ID, tokenObj.getUserId());
        orderFormQueryWrapper.eq(OrderForm.COL_ORDER_TYPE, type);
        List<OrderForm> list = list(orderFormQueryWrapper);
        ListPageUtil<OrderForm> listPageUtil = new ListPageUtil<>();
        return listPageUtil.startPage(list, currentPage, pageSize);
    }

    /**
     * 根据type获取订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param types       类型
     * @return list
     */
    @Override
    public List<OrderForm> getOderByType(String token, Integer currentPage, Integer pageSize, Integer[] types) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        List<Integer> capitalTypes = Arrays.asList(types);
        QueryWrapper<OrderForm> orderFormDetailQueryWrapper = new QueryWrapper<>();
        orderFormDetailQueryWrapper.eq(OrderForm.COL_USER_ID, Objects.requireNonNull(tokenObj).getUserId());
        orderFormDetailQueryWrapper.eq(OrderForm.COL_ORDER_TYPE, ConstantPool.ORDER_EXCHANGE_TYPE);
        orderFormDetailQueryWrapper.in(OrderForm.COL_AUDIT_STATE, capitalTypes);
        orderFormDetailQueryWrapper.orderByDesc(OrderForm.COL_CREATED_TIME);
        List<OrderForm> result = list(orderFormDetailQueryWrapper);
        ListPageUtil<OrderForm> listPageUtil = new ListPageUtil<>();
        return listPageUtil.startPage(result, currentPage, pageSize);
    }

    /**
     * 获取全部订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return result
     */
    @Override
    public List<OrderForm> getAllOrder(String token, Integer currentPage, Integer pageSize) {
        //审核状态 0未支付 1待审核 2审核中 3审核成功 4审核失败
        Integer[] oderTypes = {1, 2, 3, 4};
        return getOderByType(token, currentPage, pageSize, oderTypes);
    }

    /**
     * 获取待审核订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return result
     */
    @Override
    public List<OrderForm> getWaitReviewOrder(String token, Integer currentPage, Integer pageSize) {
        //审核状态 0未支付 1待审核 2审核中 3审核成功 4审核失败
        Integer[] oderTypes = {1, 2};
        return getOderByType(token, currentPage, pageSize, oderTypes);
    }

    /**
     * 获取审核成功订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return result
     */
    @Override
    public List<OrderForm> getReviewSuccessOrder(String token, Integer currentPage, Integer pageSize) {
        //审核状态 0未支付 1待审核 2审核中 3审核成功 4审核失败
        Integer[] oderTypes = {3};
        return getOderByType(token, currentPage, pageSize, oderTypes);
    }

    /**
     * 获取审核失败订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return result
     */
    @Override
    public List<OrderForm> getReviewFailOrder(String token, Integer currentPage, Integer pageSize) {
        //审核状态 0未支付 1待审核 2审核中 3审核成功 4审核失败
        Integer[] oderTypes = {4};
        return getOderByType(token, currentPage, pageSize, oderTypes);
    }

    /**
     * 获取提现订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    @Override
    public List<OrderForm> getWithdrawOrder(String token, Integer currentPage, Integer pageSize) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        QueryWrapper<OrderForm> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(OrderForm.COL_USER_ID, Objects.requireNonNull(tokenObj).getUserId());
        queryWrapper.eq(OrderForm.COL_ORDER_TYPE, ConstantPool.ORDER_WITHDRAW_TYPE);
        queryWrapper.orderByDesc(OrderForm.COL_CREATED_TIME);
        List<OrderForm> list = list(queryWrapper);
        return list;
    }
}
