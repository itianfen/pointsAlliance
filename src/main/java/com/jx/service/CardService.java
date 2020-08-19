package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 银行卡(Card)表服务接口
 *
 * @author makejava
 * @since 2020-07-27 16:31:25
 */
@Service
public interface CardService extends IService<Card> {

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
     * @param card           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @param token 根据用户登陆的信息查询
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(String token,Card card, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token token
     * @param card  实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Card card);

    /**
     * 修改数据
     *
     * @param token token
     * @param card  实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Card card);

    /**
     * 修改数据（全部字段）
     *
     * @param token token
     * @param card  实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Card card);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 根据token查询card分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param token       token
     * @return list
     */
    List<Card> getListPage(Integer currentPage, Integer pageSize, String token);
}


