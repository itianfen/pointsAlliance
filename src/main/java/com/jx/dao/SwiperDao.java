package com.jx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.entity.Swiper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author yangyantong
 */
public interface SwiperDao extends BaseMapper<Swiper> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Swiper queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param swiper         条件类
     * @param offset         查询起始位置
     * @param limit          查询条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 对象列表
     */
    List<Swiper> queryAllByLimit(@Param("swiper") Swiper swiper, @Param("offset") Long offset, @Param("limit") Integer limit, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param swiper 实例对象
     * @return 对象列表
     */
    List<Swiper> queryAll(Swiper swiper);

    /**
     * 修改数据
     *
     * @param swiper 实例对象
     * @return 影响行数
     */
    int update(Swiper swiper);

    /**
     * 修改全部数据
     *
     * @param swiper 实例对象
     * @return 影响行数
     */
    int updateAllColumn(Swiper swiper);

    /**
     * 通过主键删除数据 逻辑删除
     *
     * @param ids      主键
     * @param dateTime 修改时间
     * @param updater  修改人
     * @param updateId 修改人ID
     * @return 影响行数
     */
    int deleteByIdNotTrue(@Param("ids") List<String> ids, @Param("dateTime") Date dateTime, @Param("updater") String updater, @Param("updateId") String updateId);

    /**
     * 通过主键删除数据 物理删除
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") List<String> ids);

    /**
     * 通过条件 查询总条数
     *
     * @param swiper         条件
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 总条数
     */
    long countByParam(@Param("swiper") Swiper swiper, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 通过盟主ID获取所有轮播图
     *
     * @param companyId 盟主id
     * @return 所有轮播图
     */
    List<Swiper> queryAllByCompanyId(String companyId);
}