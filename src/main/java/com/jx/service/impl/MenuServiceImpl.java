package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.MenuDao;
import com.jx.entity.Menu;
import com.jx.entity.Token;
import com.jx.service.MenuService;
import com.jx.service.RoleMenuService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 菜单表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2020-06-24 12:29:05
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Resource
    private RoleMenuService roleMenuService;

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
        Menu menu = this.menuDao.queryById(id);
        if (menu == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(menu);
    }

    /**
     * 查询多条数据
     *
     * @param page  页数
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Menu menu, int page, int limit) {
        if (page < 1) {
            page = 1;
        }
        long offset = (page - 1) * limit;
        //列表
        List<Menu> list = this.menuDao.queryAllByLimit(menu, offset, limit);
        //总条数
        long count = this.menuDao.countByParam(menu);
        return Response.success(list, count);
    }

    @Override
    public List<Menu> queryAll(Menu menu) {
        return this.menuDao.queryAll(menu);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Menu menu) {
        if (StringUtils.isEmpty(token, menu.getName())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        menu.setId(UUIDUtils.generate());
        menu.setCreatedTime(now);
        menu.setLastUpdateTime(now);
        menu.setCreator(tokenObj.getUserName());
        menu.setCreatorId(tokenObj.getUserId());
        menu.setLastUpdater(tokenObj.getUserName());
        menu.setLastUpdateId(tokenObj.getUserId());
        menu.setDeleted(0);
        if (this.menuDao.insert(menu) > 0) {
            return Response.success(menu);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Menu menu) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        menu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        menu.setLastUpdater(tokenObj.getUserName());
        menu.setLastUpdateId(tokenObj.getUserId());
        if (this.menuDao.update(menu) > 0) {
            return this.queryById(menu.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Menu menu) {
        if (StringUtils.isEmpty(token, menu.getName())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        menu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        menu.setLastUpdater(tokenObj.getUserName());
        menu.setLastUpdateId(tokenObj.getUserId());
        menu.setDeleted(0);
        if (this.menuDao.updateAllColumn(menu) > 0) {
            return this.queryById(menu.getId());
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
        Menu menu = new Menu();
        menu.setId(id);
        menu.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        menu.setLastUpdater(tokenObj.getUserName());
        menu.setLastUpdateId(tokenObj.getUserId());
        menu.setDeleted(1);

        if (this.menuDao.update(menu) > 0) {
            //删除角色菜单配置
            roleMenuService.deleteByMenu(id);
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 通过token获取菜单
     *
     * @param token 实体类
     * @return 菜单结果
     */
    @Override
    public Map<String, Object> getMenuByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        String roleId = tokenObj.getRoleId();
        List<String> menuIds = roleMenuService.getMenuByRoleId(roleId);
        if (menuIds.isEmpty()) {
            return Response.fail(ErrorItem.ROLE_MENU_NO_SET);
        }
        List<Menu> list = menuDao.queryByIds(menuIds);

        return Response.success(getMenuForJson("-1", list));
    }

    /**
     * 获取菜单
     *
     * @return 菜单
     */
    @Override
    public Map<String, Object> treeList() {
        Menu menu = new Menu();
        menu.setDeleted(0);
        List<Menu> list = menuDao.queryAll(menu);
        return Response.success(parseTree("-1", list));
    }

    /**
     * 树形菜单格式拼接
     *
     * @param parentId 上层ID
     * @param menus    菜单列表
     * @return 重装好的列表
     */
    private List<Map<String, Object>> parseTree(String parentId, List<Menu> menus) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Menu menu : menus) {
            if (parentId.equals(menu.getParentId())) {
                Map<String, Object> map = MyUtils.convertBeanToMap(menu);
                map.put("children", parseTree(menu.getId(), menus));
                map.put("_showChildren", true);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 迭代按照格式拼接数组
     *
     * @param parentId 上层ID
     * @param menus    菜单列表
     * @return 重装好的列表
     */
    private List<Map<String, Object>> getMenuForJson(String parentId, List<Menu> menus) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Menu menu : menus) {
            if (parentId.equals(menu.getParentId())) {
                Map<String, Object> map = new HashMap<>(4);
                map.put("id", menu.getId());
                map.put("name", menu.getName());
                map.put("path", menu.getAction());
                map.put("component", menu.getComponent());
                Map<String, Object> meta = new HashMap<>(4);
                meta.put("hideInMenu", false);
                meta.put("title", menu.getName());
                meta.put("notCache", true);
                meta.put("icon", menu.getIcon());
                List<Map<String, Object>> children = getMenuForJson(menu.getId(), menus);
                map.put("meta", meta);
                if(children.isEmpty() && "-1".equals(parentId)){

                    Map<String, Object> parentMap = new HashMap<>(4);
                    parentMap.put("name",menu.getName()+"_parent");
                    parentMap.put("path",menu.getAction()+"_parent");

                    Map<String, Object> parentMeta = new HashMap<>(2);
                    parentMeta.put("hideInMenu", false);
                    parentMeta.put("notCache", true);
                    parentMap.put("meta", parentMeta);

                    children.add(map);
                    parentMap.put("children", children);

                    list.add(parentMap);

                }else{
                    map.put("children", children);
                    list.add(map);
                }

            }
        }
        return list;
    }
}