package com.jx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图
 *
 * @author yangyantong
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "swiper")
public class Swiper extends Model<Swiper> implements Serializable {
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
     * 图片
     */
    @TableField(value = "IMAGE_PATH")
    private String imagePath;

    /**
     * UTL连接 (备用字段先不显示)
     */
    @TableField(value = "LINK_URL")
    private String linkUrl;

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

    private static final long serialVersionUID = 1L;
}