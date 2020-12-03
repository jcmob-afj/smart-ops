package com.cnhqd.page;

import java.io.Serializable;

import lombok.Data;

/**
 * @Author afj
 * @Date 2020-12-01 14:05:20
 * @Version 1.0
 * @description: PageParameter
 */
@Data
public class PageParameter implements Serializable {

    private static final long serialVersionUID = -8324693985921606090L;

    private static final int DEFAULT_PAGE_SIZE = 10;

    private int currentPage;

    private int prePage;

    private int nextPage;

    private int pageSize;

    private int offset;

    private int totalPage;

    private int totalCount;

    public PageParameter() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * PageParameter.
     *
     * @param currentPage current page.
     * @param pageSize    page size.
     */
    public PageParameter(final Integer currentPage, final Integer pageSize) {
        this.currentPage = currentPage == null || currentPage <= 0 ? 1 : currentPage;
        this.pageSize = pageSize == null || pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        this.offset = (this.currentPage - 1) * this.pageSize;
    }

    /**
     * PageParameter.
     *
     * @param currentPage current page.
     * @param pageSize    page size.
     * @param totalCount  total count.
     */
    public PageParameter(final int currentPage, final int pageSize, final int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int) Math.ceil((double) totalCount / (double) pageSize);
        this.prePage = currentPage <= 1 ? 1 : currentPage - 1;
        this.nextPage = currentPage >= this.totalPage ? this.totalPage : currentPage + 1;
    }
}
