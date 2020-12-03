package com.cnhqd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cnhqd.entity.DocumentMenu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author afj
 */
@Data
public class DocumentMenuTree<T> implements Serializable {

    private static final long serialVersionUID = 7681873362531265829L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "目录名称")
    private String menuName;
    @ApiModelProperty(value = "子节点")
    private List<DocumentMenuTree<T>> children;
    @ApiModelProperty(value = "父id")
    private Long parentId;
    @ApiModelProperty(value = "是否有父")
    private boolean hasParent = false;
    @ApiModelProperty(value = "是否有子")
    private boolean hasChild = false;
    @ApiModelProperty(value = "数据详情")
    private DocumentMenu data;

    public void initChildren(){
        this.children = new ArrayList<>();
    }

}
