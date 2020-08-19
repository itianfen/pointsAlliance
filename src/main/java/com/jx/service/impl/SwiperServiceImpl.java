package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.SwiperDao;
import com.jx.entity.Swiper;
import com.jx.entity.Token;
import com.jx.service.SwiperService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 轮播图(Swiper)表服务实现类
 *
 * @author makejava
 * @since 2020-07-15 10:23:37
 */
@Service
public class SwiperServiceImpl extends ServiceImpl<SwiperDao, Swiper> implements SwiperService {
    @Resource
    private SwiperDao swiperDao;

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
        Swiper swiper = this.swiperDao.queryById(id);
        if (swiper == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(swiper);
    }

    /**
     * 查询多条数据
     *
     * @param swiper         实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Swiper swiper, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (swiper == null) {
            swiper = new Swiper();
        }
        swiper.setDeleted(0);
        //列表
        List<Swiper> list = this.swiperDao.queryAllByLimit(swiper, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.swiperDao.countByParam(swiper, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param swiper 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Swiper swiper) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        swiper.setId(UUIDUtils.generate());
        swiper.setCreatedTime(now);
        swiper.setLastUpdateTime(now);
        swiper.setCreator(tokenObj.getUserName());
        swiper.setCreatorId(tokenObj.getUserId());
        swiper.setLastUpdater(tokenObj.getUserName());
        swiper.setLastUpdateId(tokenObj.getUserId());
        swiper.setDeleted(0);
        swiper.setCompanyId(tokenObj.getUserId());
        if (StringUtils.isEmpty(swiper.getImagePath())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (this.swiperDao.insert(swiper) > 0) {
            return Response.success(swiper);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param swiper 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Swiper swiper) {
        if (StringUtils.isEmpty(token, swiper.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        swiper.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        swiper.setLastUpdater(tokenObj.getUserName());
        swiper.setLastUpdateId(tokenObj.getUserId());
        swiper.setDeleted(0);
        if (StringUtils.isEmpty(swiper.getImagePath())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (this.swiperDao.update(swiper) > 0) {
            return this.queryById(swiper.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param swiper 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Swiper swiper) {
        if (StringUtils.isEmpty(token, swiper.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        swiper.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        swiper.setLastUpdater(tokenObj.getUserName());
        swiper.setLastUpdateId(tokenObj.getUserId());
        swiper.setDeleted(0);
        if (StringUtils.isEmpty(swiper.getImagePath())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (this.swiperDao.updateAllColumn(swiper) > 0) {
            return this.queryById(swiper.getId());
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
        if (this.swiperDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 通过盟主ID获取所有轮播图
     *
     * @param companyId 盟主id
     * @return 所有轮播图
     */
    @Override
    public List<Swiper> queryAllByCompanyId(String companyId) {
        return swiperDao.queryAllByCompanyId(companyId);
    }
}
