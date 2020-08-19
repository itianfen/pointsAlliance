package com.jx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangyantong
 * @date 2020/7/28 16:39
 * @version 1.0
 */

/**
 * 目录表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category")
public class Category extends Model<Category> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private String id;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME")
    private Date createdTime;

    /**
     * 创建人
     */
    @TableField(value = "CREATOR")
    private String creator;

    /**
     * 创建人ID
     */
    @TableField(value = "CREATOR_ID")
    private String creatorId;

    /**
     * 修改人ID
     */
    @TableField(value = "LAST_UPDATE_ID")
    private String lastUpdateId;

    /**
     * 最后修改时间
     */
    @TableField(value = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    @TableField(value = "LAST_UPDATER")
    private String lastUpdater;

    /**
     * 分类名字
     */
    @TableField(value = "NAME")
    private String name;

    /**
     * 盟主ID
     */
    @TableField(value = "COMPANY_ID")
    private String companyId;

    /**
     * 逻辑删除 0未删除 1 已删除
     */
    @TableField(value = "DELETED")
    private Integer deleted;

    /**
     * 备用字段1
     */
    @TableField(value = "SPARE1")
    private String spare1;

    /**
     * 备用字段1
     */
    @TableField(value = "SPARE2")
    private String spare2;

    /**
     * 备用字段1
     */
    @TableField(value = "SPARE3")
    private String spare3;

    /**
     * 备用字段1
     */
    @TableField(value = "SPARE4")
    private String spare4;

    /**
     * 备用字段1
     */
    @TableField(value = "SPARE5")
    private String spare5;

    public static final String COL_ID = "ID";

    public static final String COL_CREATED_TIME = "CREATED_TIME";

    public static final String COL_CREATOR = "CREATOR";

    public static final String COL_CREATOR_ID = "CREATOR_ID";

    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";

    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";

    public static final String COL_LAST_UPDATER = "LAST_UPDATER";

    public static final String COL_NAME = "NAME";

    public static final String COL_COMPANY_ID = "COMPANY_ID";

    public static final String COL_DELETED = "DELETED";

    public static final String COL_SPARE1 = "SPARE1";

    public static final String COL_SPARE2 = "SPARE2";

    public static final String COL_SPARE3 = "SPARE3";

    public static final String COL_SPARE4 = "SPARE4";

    public static final String COL_SPARE5 = "SPARE5";
}