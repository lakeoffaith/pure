package com.ijoy.common.query;


public abstract class BaseQuery {
	public static final Long MAXPAGESIZE_1000 = 1000L;
	public static final Long MAXPAGESIZE_10000 = 10000L;
	private Long pageSize = 10L;
	private Long currentPage = 1L;
	private Long endNum;
	private Long startNum;
	
	
	public Long getEndNum() {
		if(endNum==null){
			return currentPage*pageSize;
		}
		return endNum;
	}
	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	public Long getStartNum() {
		if(startNum==null){
			return (currentPage-1)*pageSize;
		}
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		if(pageSize!=null){
			this.pageSize = pageSize;
		}
		
	}
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		if(currentPage!=null){
			this.currentPage = currentPage;
		}
	}
	@Override
	public String toString() {
		return "BaseQuery [pageSize=" + pageSize + ", currentPage="
				+ currentPage + "]";
	}
   
	
}
