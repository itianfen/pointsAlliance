package com.jx.entity;

import java.util.Date;

/**
 * TOKEN实体
 * @author zhaos 2020/6/23
 */
public class Token {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 用户权限
     */
    private String auth;
    /**
     * 失效时间
     */
    private Date invalidateTime;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * openId
     */
    private String openId;

    /**
     * 盟主ID
     */
    private String companyId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public Date getInvalidateTime() {
        return invalidateTime;
    }

    public void setInvalidateTime(Date invalidateTime) {
        this.invalidateTime = invalidateTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
