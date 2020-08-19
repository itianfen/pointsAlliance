package com.jx.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色菜单对应表(RoleMenu)实体类
 *
 * @author makejava
 * @since 2020-06-24 12:29:43
 */
public class RoleMenu extends Model<RoleMenu> implements Serializable {
    private static final long serialVersionUID = -35139512930832601L;
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
    * 创建人
    */
    private String creator;
    /**
    * 创建人ID
    */
    private String creatorId;
    
    private String lastUpdateId;
    
    private Date lastUpdateTime;
    
    private String lastUpdater;
    
    private String menuId;
    
    private String roleId;
    /**
    * 逻辑删除 0未删除 1 已删除
    */
    private Integer deleted;
    /**
    * 备用字段1
    */
    private String spare1;
    /**
    * 备用字段1
    */
    private String spare2;
    /**
    * 备用字段1
    */
    private String spare3;
    /**
    * 备用字段1
    */
    private String spare4;
    /**
    * 备用字段1
    */
    private String spare5;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }

}