package com.cnhqd.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:21
 * @Version 1.0
 * @description: 文档目录(DocumentMenu)返回vo
 */
@Data
@ApiModel("文档目录请求返回vo")
public class DocumentMenuVo implements Serializable {
    private static final long serialVersionUID = 554576908328685305L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 上级ID
     */
    @ApiModelProperty(value = "上级ID")
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