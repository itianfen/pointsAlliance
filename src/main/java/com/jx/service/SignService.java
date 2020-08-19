package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Sign;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * (Sign)表服务接口
 *
 * @author makejava
 * @since 2020-07-20 15:01:39
 */
@Service
public interface SignService extends IService<Sign> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(String id);

    /**
     * 查询多条数据
     *
     * @param sign           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(Sign sign, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token token
     * @param sign  实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Sign sign);

    /**
     * 修改数据
     *
     * @param token token
     * @param sign  实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Sign sign);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param sign  实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Sign sign);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 检查今日是否签到
     *
     * @param token token
     * @return 结果
     */
    boolean checkSign(String token);

    /**
     * 今日签到
     *
     * @param token token
     * @return 结果
     */
    Map<String, Object> sign(String token);
}