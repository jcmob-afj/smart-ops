package com.cnhqd.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:21
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)请求dto
 */
@Data
@ApiModel("文档目录请求dto")
public class DocumentMenuDto implements Serializable {
    private static final long serialVersionUID = 320371764016409968L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 上级ID
     */
    @ApiModelProperty(value = "上级ID,若没有上级,不填或者填0")
    private Long parentId;
    /**
     * 目录名称
     */
    @ApiModelProperty(value = "目录名称")
    private String menuName;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Long sort;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;


}