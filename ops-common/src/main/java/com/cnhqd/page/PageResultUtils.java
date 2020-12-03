package com.cnhqd.page;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: PageResultUtils
 */
public class PageResultUtils {
    
    /**
     * Result common pager.
     *
     * @param <T>           the type parameter
     * @param pageParameter the page parameter
     * @param count         the count
     * @param supplier      the supplier
     * @return the common pager
     */
    public static <T> CommonPager<T> result(final PageParameter pageParameter, final Integer count, final Supplier<List<T>> supplier) {
        if (count != null && count > 0) {
            return new CommonPager<>(new PageParameter(pageParameter.getCurrentPage(), pageParameter.getPageSize(), count), supplier.get());
        }
        return new CommonPager<>(new PageParameter(pageParameter.getCurrentPage(), pageParameter.getPageSize(), 0), Collections.emptyList());
        
    }
}
