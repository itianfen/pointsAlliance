package com.jx.service;

import com.jx.entity.Rule;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 规则表(Rule)表服务接口
 *
 * @author makejava
 * @since 2020-08-08 10:34:51
 */
@Service
public interface RuleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(String id);

    /**
     * 通过TYPE查询CONTENT
     * @param type 类型
     * @return content
     */
    Map<String, Object> getContentByType(Integer type);


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
    Map<String, Object> queryAllByLimit(Rule rule, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token token
     * @param rule  实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Rule rule);

    /**
     * 修改数据
     *
     * @param token token
     * @param rule  实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Rule rule);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param rule  实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Rule rule);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

}