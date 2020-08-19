package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜单表(Menu)表服务接口
 *
 * @author makejava
 * @since 2020-06-24 12:29:05
 */
@Service
public interface MenuService extends IService<Menu> {

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
     * @param menu 实体对象条件类
     * @param page 页数
     * @param limit 每页条数
     * @return 对象列表
     */
    Map<String,Object> queryAllByLimit(Menu menu,int page, int limit);

    /**
     * 查询多条数据
     *
     * @param menu 实体对象条件类
     * @return 对象列表
     */
    List<Menu> queryAll(Menu menu);

    /**
     * 新增数据
     *
     * @param token token
     * @param menu 实例对象
     * @return 实例对象
     */
    Map<String,Object> insert(String token,Menu menu);

    /**
     * 修改数据
     *
     * @param token token
     * @param menu 实例对象
     * @return 实例对象
     */
    Map<String,Object> update(String token,Menu menu);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param menu 实例对象
     * @return 实例对象
     */
    Map<String,Object> updateAllColumn(String token,Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id 主键
     * @return 是否成功
     */
    Map<String,Object> deleteById(String token,String id);

    /**
     * 根据token获取菜单
     *
     * @param token 实体类
     * @return 结果集
     */
    Map<String, Object> getMenuByToken(String token);

    /**
     * 树形菜单
     *
     * @return 结果集
     */
    Map<String, Object> treeList();
}