package com.cnhqd.page;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: CommonPager
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonPager<T> implements Serializable {

    private static final long serialVersionUID = -1220101004792874251L;

    /**
     * page.
     */
    private PageParameter page;

    /**
     * data.
     */
    private List<T> dataList;
}
