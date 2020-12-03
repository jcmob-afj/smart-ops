package com.cnhqd.supper;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author afj
 * @Date 2020/8/7 16:11
 * @Version 1.0
 * @description: Bean属性
 */
@Getter
@AllArgsConstructor
public class BeanProperty {
	private final String name;
	private final Class<?> type;
}
