package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.RoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色菜单对应表(RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2020-06-30 10:19:12
 */
@Service
public interface RoleMenuService extends IService<RoleMenu> {

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
     * @param roleMenu 实体对象条件类
     * @param page 页数
     * @param limit 每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea 时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String,Object> queryAllByLimit(RoleMenu roleMenu,Integer page, Integer limit,Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token token
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    Map<String,Object> insert(String token,RoleMenu roleMenu);

    /**
     * 修改数据
     *
     * @param token token
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    Map<String,Object> update(String token,RoleMenu roleMenu);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    Map<String,Object> updateAllColumn(String token,RoleMenu roleMenu);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id 主键
     * @return 是否成功
     */
    Map<String,Object> deleteById(String token,String id);


    /**
     * 删除角色删除记录
     * @param roleId 角色ID
     */
    void deleteByRole(List<String> roleId);

    /**
     * 删除菜单删除记录
     * @param menuId 菜单ID
     */
    void deleteByMenu(String menuId);

    /**
     * 根据角色ID 查询菜单
     * @param roleId 角色ID
     * @return 菜单ID列表
     */
    List<String> getMenuByRoleId(String roleId);

    /**
     * 查询所有菜单并标注哪些被选中
     *
     * @param roleId 角色ID
     * @return 所有菜单
     */
    Map<String, Object> treeList(String roleId);

    /**
     * 删除数据
     *
     * @param menuId 菜单ID
     * @param roleId 角色ID
     * @return 结果集
     */
    Map<String, Object> deleteRoleMenu(String menuId, String roleId);
}