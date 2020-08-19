package com.jx.dao;

import com.jx.entity.Rule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 规则表(Rule)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-08 10:34:50
 */
@Mapper
@Repository
public interface RuleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rule queryById(String id);

    /**
     * 通过type查询Content
     * @param type
     * @return 规则 Content
     */
    Rule getContentByType(Integer type);

    /**
     * 查询指定行数据
     *
     * @param rule           条件类
     * @param offset         查询起始位置
     * @param limit          查询条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 对象列表
     */
    List<Rule> queryAllByLimit(@Param("rule") Rule rule, @Param("offset") Long offset, @Param("limit") Integer limit, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rule 实例对象
     * @return 对象列表
     */
    List<Rule> queryAll(Rule rule);

    /**
     * 新增数据
     *
     * @param rule 实例对象
     * @return 影响行数
     */
    int insert(Rule rule);

    /**
     * 修改数据
     *
     * @param rule 实例对象
     * @return 影响行数
     */
    int update(Rule rule);

    /**
     * 修改全部数据
     *
     * @param rule 实例对象
     * @return 影响行数
     */
    int updateAllColumn(Rule rule);

    /**
     * 通过主键删除数据 逻辑删除
     *
     * @param ids      主键
     * @param dateTime 修改时间
     * @param updater  修改人
     * @param updateId 修改人ID
     * @return 影响行数
     */
    int deleteByIdNotTrue(@Param("ids") List<String> ids, @Param("dateTime") Date dateTime, @Param("updater") String updater, @Param("updateId") String updateId);

    /**
     * 通过主键删除数据 物理删除
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") List<String> ids);

    /**
     * 通过条件 查询总条数
     *
     * @param rule           条件
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param beginTime      开始时间
     * @param endTime        结束时间
     * @return 总条数
     */
    long countByParam(@Param("rule") Rule rule, @Param("preciseOrFuzzy") Integer preciseOrFuzzy, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}