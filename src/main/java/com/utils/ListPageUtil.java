package com.utils;

import java.util.List;

/**
 * 自定义List分页工具
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/29 14:45
 */
public class ListPageUtil<T> {
    /**
     * 开始分页
     *
     * @param list     list
     * @param pageNum  页码
     * @param pageSize 每页多少条数据
     * @return list
     */
    public List<T> startPage(List<T> list, Integer pageNum, Integer pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }
        // 记录总数
        Integer count = list.size();
        // 页数
        int pageCount;
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        // 开始索引
        int fromIndex;
        // 结束索引
        int toIndex;

        if (pageNum.equals(pageCount)) {
            if (count <= pageSize) {
                fromIndex = (pageNum - 1) * pageSize;
                toIndex = count;
            } else {
                fromIndex = (pageNum - 1) * pageSize;
                toIndex = fromIndex + pageSize;
            }
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }

        return list.subList(fromIndex, toIndex);
    }
}
