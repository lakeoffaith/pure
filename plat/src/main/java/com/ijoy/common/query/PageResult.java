package com.ijoy.common.query;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
	private Long totalCount;
	private Long pageSize=10L;
	private Long currentPage=1L;
	private Long totalPage;
	private List rows = new ArrayList(); 

	public PageResult() {

	}


	public PageResult(Long totalCount, List rows,
			Long pageSize, Long currentPage) {
		this.rows=rows;
		this.totalCount = totalCount;
		this.pageSize = pageSize < 1 ? 10 : pageSize;
		this.currentPage = currentPage < 1 ? 1 : currentPage;

		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		this.currentPage = this.currentPage > this.totalPage ? this.totalPage
				: this.currentPage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long total) {
		this.totalCount = total;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", currentPage=" + currentPage + ", totalPage="
				+ totalPage + ", rows=" + rows + "]";
	}
    
    
}
