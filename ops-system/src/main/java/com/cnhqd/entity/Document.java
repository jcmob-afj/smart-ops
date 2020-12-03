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
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)实体类
 */
@Data
@TableName("document")
public class Document implements Serializable {
    private static final long serialVersionUID = 178408275915147717L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 文档名称
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String name;
    /**
     * 项目名称
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String project;
    /**
     * 文档地址
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String url;
    /**
     * 文档描述
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String description;
    /**
     * 保密等级
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String secret;
    /**
     * 一级目录id
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private Long parentMenuId;
    /**
     * 二级目录id
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private Long childMenuId;
    /**
     * 作者
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String author;
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