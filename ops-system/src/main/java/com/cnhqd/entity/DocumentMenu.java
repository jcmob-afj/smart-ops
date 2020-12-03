package com.cnhqd.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)实体类
 */
@Data
@TableName("document_menu")
public class DocumentMenu implements Serializable {
    private static final long serialVersionUID = 107760283830191193L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 上级ID
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private Long parentId;
    /**
     * 目录名称
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String menuName;
    /**
     * 排序
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private Long sort;
    /**
     * 备注
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String remark;
    /**
     * 创建人
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;



}