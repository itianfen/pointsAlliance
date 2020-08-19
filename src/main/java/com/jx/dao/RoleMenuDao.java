package com.jx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 角色菜单对应表(RoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-30 10:25:11
 */
@Mapper
@Repository
public interface RoleMenuDao extends BaseMapper<RoleMenu> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleMenu queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param roleMenu       条件类
     * @param offset         查询起始位置
     * @param limit          查询条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 对象列表
     */
    List<RoleMenu> queryAllByLimit(@Param("roleMenu") RoleMenu roleMenu, @Param("offset") Long offset, @Param("limit") Integer limit, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleMenu 实例对象
     * @return 对象列表
     */
    List<RoleMenu> queryAll(RoleMenu roleMenu);


    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 影响行数
     */
    int update(RoleMenu roleMenu);

    /**
     * 修改全部数据
     *
     * @param roleMenu 实例对象
     * @return 影响行数
     */
    int updateAllColumn(RoleMenu roleMenu);


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
     * @param roleMenu       条件
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 总条数
     */
    long countByParam(@Param("roleMenu") RoleMenu roleMenu, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 通过角色ID 查询菜单列表
     *
     * @param roleId 角色ID
     * @return 菜单ID列表
     */
    List<String> queryByRoleId(String roleId);

    /**
     * 删除角色删除记录
     *
     * @param roleId 角色ID
     * @return 删除条数
     */
    int deleteByRole(@Param("roleId") List<String> roleId);

    /**
     * 删除菜单删除记录
     *
     * @param menuId 菜单ID
     * @return 删除条数
     */
    int deleteByMenu(@Param("menuId") String menuId);

    /**
     * 删除数据
     *
     * @param menuId 菜单ID
     * @param roleId 角色ID
     * @return 结果集
     */
    int deleteRoleMenu(@Param("menuId") String menuId, @Param("roleId") String roleId);
}