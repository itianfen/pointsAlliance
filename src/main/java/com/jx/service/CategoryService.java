package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Category;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2020-07-16 15:39:51
 */
@Service
public interface CategoryService extends IService<Category> {

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
     * @param category       实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(Category category, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);


    /**
     * 修改数据
     *
     * @param token    token
     * @param category 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Category category);

    /**
     * 修改数据（全部字段）
     *
     * @param token    token
     * @param category 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Category category);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 增加分类
     *
     * @param token token
     * @param name  名字
     * @return 结果
     */
    Map<String, Object> addCategory(String token, String name);
}

