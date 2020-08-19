package com.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取当前主机IP地址 IPV4
 * @author zhaos
 */
public class IPAddressUtil {

    public static String getINetAddress(){
        try {
            InetAddress ip4 = Inet4Address.getLocalHost();
            return ip4.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getIP(HttpServletRequest request){
        return request.getRemoteAddr();
    }

    public static void main(String[] args){
        System.out.println(getINetAddress());
    }
}
