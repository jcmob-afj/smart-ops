package com.cnhqd.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-03 13:54:31
 * @Version 1.0
 * @description: 文档记录(Document)返回vo
 */
@Data
@ApiModel("文档记录请求返回vo")
public class DocumentVo implements Serializable {
    private static final long serialVersionUID = -54474222299493214L;
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
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}