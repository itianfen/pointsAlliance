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
 * 文章表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/31 17:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "article")
public class Article extends Model<Article> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_INTRODUCTION = "INTRODUCTION";
    public static final String COL_CONTENT = "CONTENT";
    public static final String COL_IMG_URL = "IMG_URL";
    public static final String COL_COMPANY_ID = "COMPANY_ID";
    public static final String COL_CATEGORY_TYPE = "CATEGORY_TYPE";
    public static final String COL_CATEGORY_NAME = "CATEGORY_NAME";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -44997595546546714L;
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
     * 文章标题
     */
    @TableField(value = "TITLE")
    private String title;
    /**
     * 文章介绍
     */
    @TableField(value = "INTRODUCTION")
    private String introduction;
    /**
     * 文章内容
     */
    @TableField(value = "CONTENT")
    private String content;
    /**
     * 文章介绍附图
     */
    @TableField(value = "IMG_URL")
    private String imgUrl;
    /**
     * 盟主ID
     */
    @TableField(value = "COMPANY_ID")
    private String companyId;
    /**
     * 文章类别 1文案 2软文 3晒单 4资讯
     */
    @TableField(value = "CATEGORY_TYPE")
    private String categoryType;
    /**
     * 类别名称
     */
    @TableField(value = "CATEGORY_NAME")
    private String categoryName;
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
}