package com.ijoy.common.query;



public abstract class BaseQuery {
	public static final Long MAXPAGESIZE_1000 = 1000L;
	public static final Long MAXPAGESIZE_10000 = 10000L;
	private Long pageSize = 10L;
	private Long currentPage = 1L;
	private Long startNum=0L;
	
	
	
	
	
	public Long getStartNum() {
		
		return (currentPage-1)*pageSize;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
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
	@Override
	public String toString() {
		return "BaseQuery [pageSize=" + pageSize + ", currentPage="
				+ currentPage + "]";
	}
   
	
}
