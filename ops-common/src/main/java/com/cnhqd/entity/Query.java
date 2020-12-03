package com.cnhqd.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author afj
 * @Date 2020/8/28 10:04
 * @Version 1.0
 * @description: 分页查询
 */
@Data
public class Query {

	/**
	 * 分页参数 当前页
	 */
    @ApiModelProperty(value = "分页参数 当前页")
	private int pageIndex;

	/**
	 * 分页参数 每页显示的数量
	 */
    @ApiModelProperty(value = "分页参数 每页显示的数量")
	private int pageSize;


	public <T> IPage<T> toIPage() {
		IPage<T> ipage = new Page<T>(pageIndex, pageSize);
		return ipage;
	}


	
	
}
