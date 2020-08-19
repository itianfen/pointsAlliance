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
 * 公告表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/20 11:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "notice")
public class Notice extends Model<Notice> implements Serializable {
    private static final long serialVersionUID = 773473343736381201L;
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
     * 盟主ID
     */
    @TableField(value = "COMPANY_ID")
    private String companyId;

    /**
     * 公告内容
     */
    @TableField(value = "CONTENT")
    private String content;

    /**
     * 开始时间
     */
    @TableField(value = "START_TIME")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "END_TIME")
    private Date endTime;

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