package com.utils;

import com.jx.entity.Token;

import java.util.*;

/**
 * TOKEN类
 *
 * @author zhaos 2020/6/23
 */
public class TokenUtils {

    /**
     * Token 集合
     */
    private static final Map<String, Token> TOKEN_MAP = new HashMap<>();

    /**
     * 后台用户登录状态集合 key 用户ID value token
     */
    private static final Map<String, String> ADMIN_TOKEN = new HashMap<>();

    /**
     * 获取TOKEN 信息
     *
     * @param token token
     */
    public static Token addToken(String key, Token token) {
        //如果该用户已经有登陆 则清除掉原来的登陆TOKEN
        if (ADMIN_TOKEN.containsKey(token.getUserId())) {
            clearTokenById(ADMIN_TOKEN.get(token.getUserId()));
        }
        //更新token
        ADMIN_TOKEN.put(token.getUserId(), key);
        return TOKEN_MAP.put(key, token);
    }

    /**
     * 获取TOKEN 信息
     *
     * @param token token
     */
    public static Token getTokenObj(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        } else if (TOKEN_MAP.get(token) == null) {
            return null;
        } else {
            //如果已经过期了 清除掉
            if (TOKEN_MAP.get(token).getInvalidateTime().compareTo(DateFormatUtils.getCurrentDate()) <= 0) {

                //清除用户登录信息
                ADMIN_TOKEN.remove(TOKEN_MAP.get(token).getUserId());

                clearTokenById(token);

                return null;
            }
            //重置失效时间
            TOKEN_MAP.get(token).setInvalidateTime(DateFormatUtils.parseDateString(DateFormatUtils.addDays(DateFormatUtils.getCurrentDateString(), 15), DateFormatUtils.defaultFormat));
            return TOKEN_MAP.get(token);
        }
    }

    /**
     * 根据用户ID 加盐(当前时间戳） MD5 加密 后得到 token字符串
     *
     * @param id 用户ID
     * @return 加密后的token
     */
    public static String getTokenKey(String id) {
        long salt = DateFormatUtils.getCurrentDate().getTime();
        try {
            return CipherUtils.hexMd5Digest(id + salt);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 清除TOKEN
     *
     * @param token token
     */
    public static void clearTokenById(String token) {
        if (StringUtils.isNotEmpty(token) && TOKEN_MAP.get(token) != null) {
            TOKEN_MAP.remove(token);
        }
    }

    /**
     * 清除过期的token
     */
    public static void clearTokenInvalidate() {
        Set<String> keySet = TOKEN_MAP.keySet();
        Iterator<String> iterator = keySet.iterator();
        Date now = DateFormatUtils.getCurrentDate();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Token token = TOKEN_MAP.get(key);
            if (token.getInvalidateTime().compareTo(now) <= 0) {
                TOKEN_MAP.remove(key);
            }
        }
    }

    /**
     * 通过userId获取在线用户tokenObject
     *
     * @param userId userId
     * @return tokenObject
     */
    public static Token getOnlineToken(String userId) {
        if (ADMIN_TOKEN.containsKey(userId)) {
            String token = ADMIN_TOKEN.get(userId);
            return TokenUtils.getTokenObj(token);
        } else {
            return null;
        }
    }

    /**
     * 通过token直接更新在线token
     *
     * @param token token
     * @return 更新结果
     */
    public static Map<String, Object> updateOnlineToken(Token token) {
        if (ADMIN_TOKEN.containsValue(token)) {
            String tokenKey = ADMIN_TOKEN.get(token.getUserId());
            addToken(tokenKey, token);
            return Response.success();
        } else {
            return Response.fail(ErrorItem.SYSTEM_ERROR_MSG);
        }
    }
}
