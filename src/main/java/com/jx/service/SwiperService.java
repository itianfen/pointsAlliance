package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Swiper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 轮播图(Swiper)表服务接口
 *
 * @author makejava
 * @since 2020-07-15 10:23:36
 */
@Service
public interface SwiperService extends IService<Swiper> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(String id);

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
    Map<String, Object> queryAllByLimit(Swiper swiper, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token  token
     * @param swiper 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Swiper swiper);

    /**
     * 修改数据
     *
     * @param token  token
     * @param swiper 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Swiper swiper);

    /**
     * 修改数据（全部字段）
     *
     * @param token  token
     * @param swiper 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Swiper swiper);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 通过盟主ID获取所有轮播图
     *
     * @param companyId 盟主id
     * @return 所有轮播图
     */
    List<Swiper> queryAllByCompanyId(String companyId);
}
