package com.utils;

import java.util.UUID;

/**
 * @author zhaos
 */
public class UUIDUtils {
    /**
     * 获取36位十六进制UUID
     *
     * @author zhaos
     */
    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(generate());
    }
}
