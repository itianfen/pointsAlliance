package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.NoticeTanDao;
import com.jx.entity.NoticeTan;
import com.jx.entity.Token;
import com.jx.service.NoticeTanService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (NoticeTan)表服务实现类
 *
 * @author makejava
 * @since 2020-08-18 18:24:37
 */
@Service
public class NoticeTanServiceImpl extends ServiceImpl<NoticeTanDao, NoticeTan> implements NoticeTanService {
    @Resource
    private NoticeTanDao noticeTanDao;

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
        NoticeTan noticeTan = this.noticeTanDao.queryById(id);
        if (noticeTan == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(noticeTan);
    }

    /**
     * 查询多条数据
     *
     * @param noticeTan      实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(NoticeTan noticeTan, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (noticeTan == null) {
            noticeTan = new NoticeTan();
        }
        noticeTan.setDeleted(0);
        //列表
        List<NoticeTan> list = this.noticeTanDao.queryAllByLimit(noticeTan, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.noticeTanDao.countByParam(noticeTan, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param noticeTan 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, NoticeTan noticeTan) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        noticeTan.setId(UUIDUtils.generate());
        noticeTan.setCreatedTime(now);
        noticeTan.setLastUpdateTime(now);
        noticeTan.setCreator(tokenObj.getUserName());
        noticeTan.setCreatorId(tokenObj.getUserId());
        noticeTan.setLastUpdater(tokenObj.getUserName());
        noticeTan.setLastUpdateId(tokenObj.getUserId());
        noticeTan.setDeleted(0);
        if (this.noticeTanDao.insert(noticeTan) > 0) {
            return Response.success(noticeTan);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param noticeTan 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, NoticeTan noticeTan) {
        if (StringUtils.isEmpty(token, noticeTan.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        noticeTan.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        noticeTan.setLastUpdater(tokenObj.getUserName());
        noticeTan.setLastUpdateId(tokenObj.getUserId());
        noticeTan.setDeleted(0);
        if (this.noticeTanDao.update(noticeTan) > 0) {
            return this.queryById(noticeTan.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param noticeTan 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, NoticeTan noticeTan) {
        if (StringUtils.isEmpty(token, noticeTan.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        noticeTan.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        noticeTan.setLastUpdater(tokenObj.getUserName());
        noticeTan.setLastUpdateId(tokenObj.getUserId());
        noticeTan.setDeleted(0);
        if (this.noticeTanDao.updateAllColumn(noticeTan) > 0) {
            return Response.success(this.queryById(noticeTan.getId()));
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
        if (this.noticeTanDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }
}
