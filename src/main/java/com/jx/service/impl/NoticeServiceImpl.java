package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.NoticeDao;
import com.jx.entity.Article;
import com.jx.entity.Notice;
import com.jx.entity.Token;
import com.jx.service.NoticeService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 公告表(Notice)表服务实现类
 *
 * @author makejava
 * @since 2020-07-20 11:33:41
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

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
        Notice notice = this.noticeDao.queryById(id);
        if (notice == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(notice);
    }

    /**
     * 查询多条数据
     *
     * @param notice         实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Notice notice, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (notice == null) {
            notice = new Notice();
        }
        notice.setDeleted(0);
        //列表
        List<Notice> list = this.noticeDao.queryAllByLimit(notice, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.noticeDao.countByParam(notice, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Notice notice) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        notice.setId(UUIDUtils.generate());
        notice.setCreatedTime(now);
        notice.setLastUpdateTime(now);
        notice.setCreator(tokenObj.getUserName());
        notice.setCreatorId(tokenObj.getUserId());
        notice.setLastUpdater(tokenObj.getUserName());
        notice.setLastUpdateId(tokenObj.getUserId());
        notice.setCompanyId(tokenObj.getUserId());
        notice.setDeleted(0);
        if (notice.getSpare1().equals("1")) {
            List<Notice> list = list(new QueryWrapper<Notice>().eq(Article.COL_SPARE1, "1"));
            if (!list.isEmpty()) {
                return Response.fail(ErrorItem.DELETE_NOTICE_TAN_FIRST);
            }
        }
        if (this.noticeDao.insert(notice) > 0) {
            return Response.success(notice);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Notice notice) {
        if (StringUtils.isEmpty(token, notice.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        notice.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        notice.setLastUpdater(tokenObj.getUserName());
        notice.setLastUpdateId(tokenObj.getUserId());
        notice.setDeleted(0);
        if (notice.getSpare1().equals("1")) {
            List<Notice> list = list(new QueryWrapper<Notice>().eq(Article.COL_SPARE1, "1").eq(Article.COL_DELETED, 0));
            if (!list.isEmpty()) {
                return Response.fail(ErrorItem.DELETE_NOTICE_TAN_FIRST);
            }
        }
        notice.updateById();
        return this.queryById(notice.getId());
    }

    /**
     * 修改数据（全部字段）
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Notice notice) {
        if (StringUtils.isEmpty(token, notice.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        notice.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        notice.setLastUpdater(tokenObj.getUserName());
        notice.setLastUpdateId(tokenObj.getUserId());
        notice.setDeleted(0);
        if (this.noticeDao.updateAllColumn(notice) > 0) {
            return Response.success(this.queryById(notice.getId()));
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
        if (this.noticeDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 通过盟主ID查询所有公告
     *
     * @param companyId 盟主ID
     * @return 所有公告
     */
    @Override
    public List<Notice> queryAllByCompanyId(String companyId) {
        Date now = DateFormatUtils.getCurrentDate();
        return noticeDao.queryAllByCompanyId(companyId);
    }
}
