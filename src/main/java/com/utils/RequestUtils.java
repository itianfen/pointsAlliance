package com.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/31 17:38
 */
public class RequestUtils {
    /*
     * request.getParameterMap()返回的是Map<String,String[]>，将其转换为的Map<String,String>
     * ，原来的String[]如果长度大于1，则转换后的值为以;（英文分号）分隔的字符串
     *
     * @param <Map>对象
     */
    public static Map<String, Object> convertReqParaMap(Map<String, Object> fields) {
        Map<String, Object> cr = new HashMap<String, Object>(fields.size());
        Iterator<Map.Entry<String, Object>> ei = fields.entrySet().iterator();
        while (ei.hasNext()) {
            Map.Entry<String, Object> e = ei.next();
            Object v = e.getValue();
            if (v != null)
                if (v instanceof String[]) {
                    String[] temp = (String[]) v;
                    for (int i = 1; i < temp.length; i++) {
                        temp[0] += ";" + temp[i];
                    }
                    cr.put(e.getKey(), temp[0]);
                    continue;
                }
            cr.put(e.getKey(), v);
        }
        return cr;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            if (ip.indexOf(",") > 0) {
                return ip.substring(0, ip.indexOf(","));
            } else {
                return ip;
            }
        }
        return ip;
    }

}

