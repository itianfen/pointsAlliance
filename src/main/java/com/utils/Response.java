package com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 向前端返回结果集
 *
 * @author zhaos
 */
public class Response {
    /**
     * 返回成功 并携带 返回对象结果集
     *
     * @param object 结果集
     */
    public static Map<String, Object> success(Object object) {
        Map<String, Object> result = new HashMap<>(3);
        result.put("state", true);
        result.put("msg", "成功");
        result.put("data", object);
        return result;
    }

    /**
     * 返回成功不含参数
     */
    public static Map<String, Object> success() {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", true);
        result.put("msg", "成功");
        return result;
    }

    /**
     * 返回成功不含参数
     */
    public static Map<String, Object> success(String msg) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", true);
        result.put("msg", msg);
        return result;
    }
    /**
     * 返回成功含参数
     */
    public static Map<String, Object> success(String msg, Map<String,Object> mapData) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", true);
        result.put("msg", msg);
        result.put("data", mapData);
        return result;
    }

    /**
     * 返回成功 并携带 返回对象结果集
     *
     * @param list 结果集
     * @param count 总数用于分页
     */
    public static Map<String, Object> success(List list, long count) {
        Map<String, Object> result = new HashMap<>(5);
        result.put("state", true);
        result.put("msg", "");
        result.put("data", list);
        result.put("count", count);
        return result;
    }

    /**
     * 返回成功 并携带 返回对象结果集
     * @param list 结果集
     * @param count 总数用于分页
     * @param totalRowData 合计列的数据
     * @return layUi使用的结果集
     */
    public static Map<String, Object> success(List list, long count,Map<String,Object> totalRowData) {
        Map<String, Object> result = new HashMap<>(6);
        result.put("state", true);
        result.put("msg", "");
        result.put("data", list);
        result.put("count", count);
        result.put("totalRow", totalRowData);
        return result;
    }
    /**
     * 返回失败 并返回错误原因
     *
     * @param s//(为保证一致性可在接口ErrorItem中定义)
     */
    public static Map<String, Object> fail(String s) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", false);
        result.put("msg", s);
        return result;
    }

    /**
     * 返回失败 并返回错误原因
     *
     * @param object 实体
     */
    public static Map<String, Object> fail(Object object) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", false);
        result.put("data", object);
        return result;
    }

    /**
     * 返回失败 并返回错误原因
     */
    public static Map<String, Object> defaultFail() {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", false);
        result.put("msg", "操作失败");
        return result;
    }

    /**
     * 返回失败 并返回错误原因
     */
    public static Map<String, Object> defaultFail(String msg) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", false);
        result.put("msg", msg);
        return result;
    }

    public static Map<String, Object> clientSuccess(){
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", "true");
        result.put("msg", "操作成功");
        return result;
    }

    public static Map<String, Object> clientSuccess(Object obj){
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", "true");
        result.put("msg", "操作成功");
        result.put("data", obj);
        return result;
    }

    public static Map<String, Object> clientSuccess(String msg){
        Map<String, Object> result = new HashMap<>(2);
        result.put("state", "true");
        result.put("msg", msg);
        return result;
    }
}
