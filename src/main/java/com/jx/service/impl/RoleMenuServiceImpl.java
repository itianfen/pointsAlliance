package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.RoleMenuDao;
import com.jx.entity.Menu;
import com.jx.entity.RoleMenu;
import com.jx.entity.Token;
import com.jx.service.MenuService;
import com.jx.service.RoleMenuService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 角色菜单对应表(RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-06-30 10:29:37
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenu> implements RoleMenuService {
    @Resource
    private RoleMenuDao roleMenuDao;

    @Resource
    private MenuService menuService;

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
        RoleMenu roleMenu = this.roleMenuDao.queryById(id);
        if (roleMenu == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(roleMenu);
    }

    /**
     * 查询多条数据
     *
     * @param roleMenu       实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(RoleMenu roleMenu, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (roleMenu == null) {
            roleMenu = new RoleMenu();
        }
        roleMenu.setDeleted(0);
        //列表
        List<RoleMenu> list = this.roleMenuDao.queryAllByLimit(roleMenu, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.roleMenuDao.countByParam(roleMenu, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, RoleMenu roleMenu) {
        if (StringUtils.isEmpty(token, roleMenu.getMenuId(), roleMenu.getRoleId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        roleMenu.setId(UUIDUtils.generate());
        roleMenu.setCreatedTime(now);
        roleMenu.setLastUpdateTime(now);
        roleMenu.setCreator(tokenObj.getUserName());
        roleMenu.setCreatorId(tokenObj.getUserId());
        roleMenu.setLastUpdater(tokenObj.getUserName());
        roleMenu.setLastUpdateId(tokenObj.getUserId());
        roleMenu.setDeleted(0);
        if (this.roleMenuDao.insert(roleMenu) > 0) {
            return Response.success(roleMenu);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, RoleMenu roleMenu) {
        if (StringUtils.isEmpty(token, roleMenu.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        roleMenu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        roleMenu.setLastUpdater(tokenObj.getUserName());
        roleMenu.setLastUpdateId(tokenObj.getUserId());
        roleMenu.setDeleted(0);
        if (this.roleMenuDao.update(roleMenu) > 0) {
            return this.queryById(roleMenu.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, RoleMenu roleMenu) {
        if (StringUtils.isEmpty(token, roleMenu.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        roleMenu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        roleMenu.setLastUpdater(tokenObj.getUserName());
        roleMenu.setLastUpdateId(tokenObj.getUserId());
        roleMenu.setDeleted(0);
        if (this.roleMenuDao.updateAllColumn(roleMenu) > 0) {
            return this.queryById(roleMenu.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
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
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(id);
        roleMenu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        roleMenu.setLastUpdater(tokenObj.getUserName());
        roleMenu.setLastUpdateId(tokenObj.getUserId());
        roleMenu.setDeleted(1);

        if (this.roleMenuDao.update(roleMenu) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 删除角色删除记录
     *
     * @param roleId 角色ID
     */
    @Override
    public void deleteByRole(List<String> roleId) {
        this.roleMenuDao.deleteByRole(roleId);
    }

    /**
     * 删除菜单删除记录
     *
     * @param menuId 菜单ID
     */
    @Override
    public void deleteByMenu(String menuId) {
        this.roleMenuDao.deleteByMenu(menuId);
    }

    /**
     * 根据角色ID 查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单ID列表
     */
    @Override
    public List<String> getMenuByRoleId(String roleId) {
        return this.roleMenuDao.queryByRoleId(roleId);
    }

    /**
     * 查询所有菜单并标注哪些被选中
     *
     * @param roleId 角色ID
     * @return 所有菜单
     */
    @Override
    public Map<String, Object> treeList(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Menu menu = new Menu();
        menu.setDeleted(0);
        //查出全部菜单
        List<Menu> menuList = menuService.queryAll(menu);
        //查出该角色全部的菜单ID
        List<String> roleMenuList = this.roleMenuDao.queryByRoleId(roleId);

        //便利所有菜单 格式化参数
        List<Map<String, Object>> targetData = new ArrayList<>();
        Map<String, Object> tempMap;
        for (Menu menu1 : menuList) {
            tempMap = new HashMap<>(5);
            tempMap.put("id", menu1.getId());
            tempMap.put("parentId", menu1.getParentId());
            tempMap.put("title", menu1.getName());
            tempMap.put("expand", true);
            //如果已经配置过该菜单就选中
            if (roleMenuList.contains(menu1.getId())) {
                tempMap.put("checked", true);
            }
            targetData.add(tempMap);
        }

        return Response.success(parseTreeData("-1", targetData));
    }

    /**
     * 删除数据
     *
     * @param menuId 菜单ID
     * @param roleId 角色ID
     * @return 结果集
     */
    @Override
    public Map<String, Object> deleteRoleMenu(String menuId, String roleId) {
        return Response.success(this.roleMenuDao.deleteRoleMenu(menuId, roleId));
    }

    /**
     * 变为树形组件需要的格式
     *
     * @param parentId 父ID
     * @param list     数据源
     * @return 属性菜单格式
     */
    private List<Map<String, Object>> parseTreeData(String parentId, List<Map<String, Object>> list) {
        List<Map<String, Object>> result = new ArrayList<>(7);
        for (Map<String, Object> map : list) {
            if (StringUtils.parseString(map.get("parentId")).equals(parentId)) {
                map.put("children", parseTreeData(StringUtils.parseString(map.get("id")), list));
                result.add(map);
            }
        }
        return result;
    }

}