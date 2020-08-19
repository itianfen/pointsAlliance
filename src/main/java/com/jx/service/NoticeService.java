package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.Notice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公告表(Notice)表服务接口
 *
 * @author makejava
 * @since 2020-07-20 11:33:40
 */
@Service
public interface NoticeService extends IService<Notice> {

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
     * @param notice         实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(Notice notice, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token  token
     * @param notice 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, Notice notice);

    /**
     * 修改数据
     *
     * @param token  token
     * @param notice 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, Notice notice);

    /**
     * 修改数据（全部字段）
     *
     * @param token  token
     * @param notice 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 通过盟主ID查询所有公告
     *
     * @param companyId 盟主ID
     * @return 所有公告
     */
    List<Notice> queryAllByCompanyId(String companyId);

}
