package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品表(Goods)表服务接口
 *
 * @author makejava
 * @since 2020-07-29 18:44:42
 */
@Service
public interface GoodsService extends IService<Goods> {

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
     * @param goods          实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(Goods goods, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    Map<String, Object> queryAll(Goods goods);

    /**
     * 新增数据
     *
     * @param token token
     * @param goods 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Goods goods);

    /**
     * 修改数据
     *
     * @param token token
     * @param goods 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Goods goods);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param goods 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 通过ID查询单条数据和购买个数
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> selectData(String id);
}

