package com.jx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-24 19:17:06
 */
@Mapper
@Repository
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param menu   条件类
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Menu> queryAllByLimit(@Param("menu") Menu menu, @Param("offset") long offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    List<Menu> queryAll(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int update(Menu menu);

    /**
     * 修改全部数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int updateAllColumn(Menu menu);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过条件 查询总条数
     *
     * @param menu 条件
     * @return 总条数
     */
    long countByParam(Menu menu);

    /**
     * 根据ID列表 获取列表
     *
     * @param menuIds 菜单ID列表
     * @return 菜单列表
     */
    List<Menu> queryByIds(@Param("menuIds") List<String> menuIds);
}