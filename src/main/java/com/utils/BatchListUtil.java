package com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/20 15:23
 */
public class BatchListUtil<E> {
    /**
     * 把list分成多个批次
     *
     * @param list      集合
     * @param batchSize 批次大小
     * @return Map<Integer, List < E>>
     */
    public Map<Integer, List<E>> batchToMap(List<E> list, int batchSize) {
        Map<Integer, List<E>> itemMap = new HashMap<>(16);
        itemMap.put(1, new ArrayList<E>());
        for (E e : list) {
            List<E> batchList = itemMap.get(itemMap.size());
            //当list满足批次数量，新建一个list存放后面的数据
            if (batchList.size() == batchSize) {
                batchList = new ArrayList<E>();
                itemMap.put(itemMap.size() + 1, batchList);
            }
            batchList.add(e);
        }
        return itemMap;
    }

    /**
     * 把list分成多个批次
     *
     * @param list      集合
     * @param batchSize 批次大小
     * @return List<List < E>>
     */
    public List<List<E>> batchToList(List<E> list, int batchSize) {
        List<List<E>> result = new ArrayList<>();
        List<E> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (tempList.size() == batchSize) {
                result.add(tempList);
                tempList = new ArrayList<>();
            }
            tempList.add(list.get(i));
            if (i == list.size() - 1) {
                result.add(tempList);
            }
        }
        return result;
    }
}
