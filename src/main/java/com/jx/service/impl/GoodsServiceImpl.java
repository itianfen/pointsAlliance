package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.GoodsDao;
import com.jx.entity.Goods;
import com.jx.entity.Token;
import com.jx.service.GoodsOrderService;
import com.jx.service.GoodsService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品表(Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-07-29 18:44:44
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Resource
    private GoodsOrderService goodsOrderService;

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
        Goods goods = this.goodsDao.queryById(id);
        if (goods == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(goods);
    }

    /**
     * 查询多条数据
     *
     * @param goods          实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Goods goods, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (goods == null) {
            goods = new Goods();
        }
        goods.setDeleted(0);
        //列表
        List<Goods> list = this.goodsDao.queryAllByLimit(goods, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.goodsDao.countByParam(goods, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAll(Goods goods) {
        List<Goods> list = this.goodsDao.queryAll(goods);
        return Response.success(list);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Goods goods) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        goods.setId(UUIDUtils.generate());
        goods.setCreatedTime(now);
        goods.setLastUpdateTime(now);
        goods.setCreator(tokenObj.getUserName());
        goods.setCreatorId(tokenObj.getUserId());
        goods.setLastUpdater(tokenObj.getUserName());
        goods.setLastUpdateId(tokenObj.getUserId());
        goods.setDeleted(0);
        if (this.goodsDao.insert(goods) > 0) {
            return Response.success(goods);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Goods goods) {
        if (StringUtils.isEmpty(token, goods.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        goods.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        goods.setLastUpdater(tokenObj.getUserName());
        goods.setLastUpdateId(tokenObj.getUserId());
        goods.setDeleted(0);
        if (this.goodsDao.update(goods) > 0) {
            return Response.success(this.queryById(goods.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Goods goods) {
        if (StringUtils.isEmpty(token, goods.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        goods.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        goods.setLastUpdater(tokenObj.getUserName());
        goods.setLastUpdateId(tokenObj.getUserId());
        goods.setDeleted(0);
        if (this.goodsDao.updateAllColumn(goods) > 0) {
            return Response.success(this.queryById(goods.getId()));
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
        if (this.goodsDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 通过ID查询单条数据和购买个数
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> selectData(String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Goods goods = this.goodsDao.queryById(id);
        if (goods == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        Map<String, Object> result = Response.success(goods);
        result.put("buyCount",goodsOrderService.countByGoodsId(id));
        return result;
    }
}

