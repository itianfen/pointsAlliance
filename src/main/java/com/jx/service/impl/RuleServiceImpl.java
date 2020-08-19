package com.jx.service.impl;

import com.jx.dao.RuleDao;
import com.jx.entity.Rule;
import com.jx.entity.Token;
import com.jx.service.RuleService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 规则表(Rule)表服务实现类
 *
 * @author makejava
 * @since 2020-08-08 10:34:53
 */
@Service
public class RuleServiceImpl implements RuleService {
    @Resource
    private RuleDao ruleDao;

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
        Rule rule = this.ruleDao.queryById(id);
        if (rule == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(rule);
    }

    /**
     * 通过TYPE查询CONTENT
     * @param type 类型
     * @return content
     */
    @Override
    public Map<String, Object> getContentByType(Integer type) {
        if (null == type)  {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Rule rule = this.ruleDao.getContentByType(type);
        if (rule == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(rule);
    }

    /**
     * 查询多条数据
     *
     * @param rule           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Rule rule, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (rule == null) {
            rule = new Rule();
        }
        rule.setDeleted(0);
        //列表
        List<Rule> list = this.ruleDao.queryAllByLimit(rule, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.ruleDao.countByParam(rule, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Rule rule) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        rule.setId(UUIDUtils.generate());
        rule.setCreatedTime(now);
        rule.setLastUpdateTime(now);
        rule.setCreator(tokenObj.getUserName());
        rule.setCreatorId(tokenObj.getUserId());
        rule.setLastUpdater(tokenObj.getUserName());
        rule.setLastUpdateId(tokenObj.getUserId());
        rule.setDeleted(0);
        if (this.ruleDao.insert(rule) > 0) {
            return Response.success(rule);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Rule rule) {
        if (StringUtils.isEmpty(token, rule.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        rule.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        rule.setLastUpdater(tokenObj.getUserName());
        rule.setLastUpdateId(tokenObj.getUserId());
        rule.setDeleted(0);
        if (this.ruleDao.update(rule) > 0) {
            return Response.success(this.queryById(rule.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param rule 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Rule rule) {
        if (StringUtils.isEmpty(token, rule.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        rule.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        rule.setLastUpdater(tokenObj.getUserName());
        rule.setLastUpdateId(tokenObj.getUserId());
        rule.setDeleted(0);
        if (this.ruleDao.updateAllColumn(rule) > 0) {
            return Response.success(this.queryById(rule.getId()));
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
        if (this.ruleDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }
}