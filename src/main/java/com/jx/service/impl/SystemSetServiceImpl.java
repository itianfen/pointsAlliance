package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.SystemSetDao;
import com.jx.entity.SystemSet;
import com.jx.entity.Token;
import com.jx.service.SystemSetService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统价格设置表(SystemSet)表服务实现类
 *
 * @author makejava
 * @since 2020-07-24 14:14:31
 */
@Service
public class SystemSetServiceImpl extends ServiceImpl<SystemSetDao, SystemSet> implements SystemSetService {
    @Resource
    private SystemSetDao systemSetDao;

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
        SystemSet systemSet = this.systemSetDao.queryById(id);
        if (systemSet == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(systemSet);
    }

    /**
     * 查询多条数据
     *
     * @param systemSet      实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(SystemSet systemSet, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (systemSet == null) {
            systemSet = new SystemSet();
        }
        systemSet.setDeleted(0);
        //列表
        List<SystemSet> list = this.systemSetDao.queryAllByLimit(systemSet, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.systemSetDao.countByParam(systemSet, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param systemSet 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, SystemSet systemSet) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        systemSet.setId(UUIDUtils.generate());
        systemSet.setCreatedTime(now);
        systemSet.setLastUpdateTime(now);
        systemSet.setCreator(tokenObj.getUserName());
        systemSet.setCreatorId(tokenObj.getUserId());
        systemSet.setLastUpdater(tokenObj.getUserName());
        systemSet.setLastUpdateId(tokenObj.getUserId());
        systemSet.setDeleted(0);
        if (this.systemSetDao.insert(systemSet) > 0) {
            return Response.success(systemSet);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param systemSet 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, SystemSet systemSet) {
        if (StringUtils.isEmpty(token, systemSet.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        systemSet.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        systemSet.setLastUpdater(tokenObj.getUserName());
        systemSet.setLastUpdateId(tokenObj.getUserId());
        systemSet.setDeleted(0);
        if (this.systemSetDao.update(systemSet) > 0) {
            return this.queryById(systemSet.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param systemSet 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, SystemSet systemSet) {
        if (StringUtils.isEmpty(token, systemSet.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        systemSet.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        systemSet.setLastUpdater(tokenObj.getUserName());
        systemSet.setLastUpdateId(tokenObj.getUserId());
        systemSet.setDeleted(0);
        if (this.systemSetDao.updateAllColumn(systemSet) > 0) {
            return Response.success(this.queryById(systemSet.getId()));
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
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //转为换维数组格式
        String[] idArr = id.split(",");
        List<String> idList = new ArrayList<>();
        Collections.addAll(idList, idArr);
        //逻辑删除
        if (this.systemSetDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }
}
