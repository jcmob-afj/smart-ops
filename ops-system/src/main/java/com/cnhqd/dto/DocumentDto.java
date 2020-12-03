package com.cnhqd.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-03 13:54:30
 * @Version 1.0
 * @description: 文档记录(Document)请求dto
 */
@Data
@ApiModel("文档记录请求dto")
public class DocumentDto implements Serializable {
    private static final long serialVersionUID = -52463686093375398L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 文档名称
     */
    @ApiModelProperty(value = "文档名称")
    private String name;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String project;
    /**
     * 文档地址
     */
    @ApiModelProperty(value = "文档地址")
    private String url;
    /**
     * 文档描述
     */
    @ApiModelProperty(value = "文档描述")
    private String description;
    /**
     * 保密等级
     */
    @ApiModelProperty(value = "保密等级")
    private String secret;
    /**
     * 一级目录id
     */
    @ApiModelProperty(value = "一级目录id")
    private Long parentMenuId;
    /**
     * 二级目录id
     */
    @ApiModelProperty(value = "二级目录id")
    private Long childMenuId;
    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String author;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;



}