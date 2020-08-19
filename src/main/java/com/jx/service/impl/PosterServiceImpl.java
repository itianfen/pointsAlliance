package com.jx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.PosterDao;
import com.jx.entity.Poster;
import com.jx.entity.Token;
import com.jx.service.PosterService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 海报管理表(Poster)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 18:10:21
 */
@Service
public class PosterServiceImpl extends ServiceImpl<PosterDao, Poster> implements PosterService {
    @Resource
    private PosterDao posterDao;

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
        Poster poster = this.posterDao.queryById(id);
        if (poster == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(poster);
    }

    /**
     * 查询多条数据
     *
     * @param poster         实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Poster poster, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (poster == null) {
            poster = new Poster();
        }
        poster.setDeleted(0);
        //列表
        List<Poster> list = this.posterDao.queryAllByLimit(poster, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.posterDao.countByParam(poster, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param poster 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Poster poster) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        poster.setId(UUIDUtils.generate());
        poster.setCreatedTime(now);
        poster.setLastUpdateTime(now);
        poster.setCreator(tokenObj.getUserName());
        poster.setCreatorId(tokenObj.getUserId());
        poster.setLastUpdater(tokenObj.getUserName());
        poster.setLastUpdateId(tokenObj.getUserId());
        poster.setDeleted(0);
        if (this.posterDao.insert(poster) > 0) {
            return Response.success(poster);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param poster 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Poster poster) {
        if (StringUtils.isEmpty(token, poster.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        poster.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        poster.setLastUpdater(tokenObj.getUserName());
        poster.setLastUpdateId(tokenObj.getUserId());
        poster.setDeleted(0);
        if (this.posterDao.update(poster) > 0) {
            return Response.success(this.queryById(poster.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param poster 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Poster poster) {
        if (StringUtils.isEmpty(token, poster.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        poster.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        poster.setLastUpdater(tokenObj.getUserName());
        poster.setLastUpdateId(tokenObj.getUserId());
        poster.setDeleted(0);
        if (this.posterDao.updateAllColumn(poster) > 0) {
            return Response.success(this.queryById(poster.getId()));
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
        if (this.posterDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * @return
     */
    @Override
    public Map<String, Object> queryAll() {
        Poster poster = new Poster();
        poster.setDeleted(0);
        List<Poster> posters = posterDao.queryAll(poster);
        if (posters == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(posters);
    }
}
