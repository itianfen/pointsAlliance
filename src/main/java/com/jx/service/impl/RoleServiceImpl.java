package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.RoleDao;
import com.jx.entity.Role;
import com.jx.entity.Token;
import com.jx.service.RoleMenuService;
import com.jx.service.RoleService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 角色表(Role)表服务实现类
 *
 * @author makejava
 * @since 2020-06-29 16:16:38
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    /**
     * 超级管理员ID
     */
    private static final String ADMIN = "1";
    @Resource
    private RoleDao roleDao;
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
        Role role = this.roleDao.queryById(id);
        if (role == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(role);
    }

    /**
     * 查询多条数据
     *
     * @param role           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Role role, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (role == null) {
            role = new Role();
        }
        role.setDeleted(0);
        //列表
        List<Role> list = this.roleDao.queryAllByLimit(role, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.roleDao.countByParam(role, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Role role) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Role validateRole = new Role();
        validateRole.setName(role.getName());
        validateRole.setDeleted(0);
        if (this.roleDao.countByParam(validateRole, 1, null, null) > 0) {
            return Response.fail(ErrorItem.REPEATED_RECORD);
        }
        Date now = DateFormatUtils.getCurrentDate();
        role.setId(UUIDUtils.generate());
        role.setCreatedTime(now);
        role.setLastUpdateTime(now);
        role.setCreator(tokenObj.getUserName());
        role.setCreatorId(tokenObj.getUserId());
        role.setLastUpdater(tokenObj.getUserName());
        role.setLastUpdateId(tokenObj.getUserId());
        role.setDeleted(0);
        if (this.roleDao.insert(role) > 0) {
            return Response.success(role);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Role role) {
        if (StringUtils.isEmpty(token, role.getId(), role.getName())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        role.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        role.setLastUpdater(tokenObj.getUserName());
        role.setLastUpdateId(tokenObj.getUserId());
        if (this.roleDao.update(role) > 0) {
            return this.queryById(role.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Role role) {
        if (StringUtils.isEmpty(token, role.getId(), role.getName())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        role.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        role.setLastUpdater(tokenObj.getUserName());
        role.setLastUpdateId(tokenObj.getUserId());
        if (this.roleDao.updateAllColumn(role) > 0) {
            return this.queryById(role.getId());
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
        //转为换维数组格式
        String[] idArr = id.split(",");
        List<String> idList = new ArrayList<>();
        Collections.addAll(idList, idArr);
        //超级管理员无法被删除
        if (idList.contains(ADMIN)) {
            return Response.fail(ErrorItem.CANT_NOT_BE_DELETED);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //逻辑删除
        if (this.roleDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            //删除角色菜单配置
            roleMenuService.deleteByRole(idList);
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 查询全部角色
     *
     * @return 全部角色
     */
    @Override
    public Map<String, Object> allRole() {
        return Response.success(list(new QueryWrapper<Role>().eq(Role.COL_DELETED, 0)));
    }
}
