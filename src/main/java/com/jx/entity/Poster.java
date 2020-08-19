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
 * 海报管理表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/5 10:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "poster")
public class Poster extends Model<Poster> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_POSTER_NAME = "POSTER_NAME";
    public static final String COL_POSTER_IMG = "POSTER_IMG";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -39938217466009172L;
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
     * 海报名称
     */
    @TableField(value = "POSTER_NAME")
    private String posterName;
    /**
     * 图片
     */
    @TableField(value = "POSTER_IMG")
    private String posterImg;
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