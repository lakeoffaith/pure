package com.ijoy.common.page;

public abstract class Page {
	protected VariablePage variablePage;

	public Page(VariablePage variablePage) {
		this.variablePage = variablePage;
		
		calculateTotalPage();
	}

	public int getStartIndex() {
		return (getValidpageNum() - 1) * variablePage.pageSize;
	}

	public String getBackpageNum() {
		if (variablePage.pageNo <= 1) {
			return buildSpan("上一页", variablePage);
		} else {
			return buildA("上一页", variablePage.pageNo - 1);
		}
	}

	public String getNextpageNum() {
		if (variablePage.pageNo >= variablePage.totalPage) {
			return buildSpan("下一页", variablePage);
		} else {
			return buildA("下一页", variablePage.pageNo + 1);
		}
	}

	/**
	 * 计算总页数
	 */
	private void calculateTotalPage() {
		if (variablePage.totalSum % variablePage.pageSize == 0) {
			variablePage.totalPage = variablePage.totalSum
					/ variablePage.pageSize;
		} else {
			variablePage.totalPage = variablePage.totalSum
					/ variablePage.pageSize + 1;
		}
		if (variablePage.totalPage < variablePage.pageNo) {
			variablePage.pageNo = variablePage.totalPage;
		} else if (variablePage.pageNo < 1) {
			variablePage.pageNo = 1;
		}
	}

	protected String displayAll() {
		StringBuilder sBuilder = new StringBuilder(10);
		sBuilder.append(variablePage.split);
		for (int i = 1; i <= variablePage.totalPage; i++) {
			if (i == variablePage.pageNo) {
				sBuilder.append(buildCurrent(variablePage, i)  + variablePage.split);
			} else {
				sBuilder.append(buildA(variablePage, i) + variablePage.split);
			}
		}
		return sBuilder.toString();
	}
	
	

	/**
	 * 抽象出分页方法
	 * 
	 * @return
	 */
	public abstract String pagination();

	/**
	 * 实现从第一页开始打印
	 * 
	 * @return
	 */
	protected final String fromFirstPagePrint() {
		StringBuffer buffer = new StringBuffer(100);
		for (int i = 1; i <= variablePage.showPageNum; i++) {
			if (i == variablePage.pageNo) {// 如果是当前页:不添加连接URL
				buffer.append(buildCurrent(variablePage, i));
			} else {
				buffer.append(buildA(variablePage, i) + variablePage.split);
			}
		}
		return buffer.toString();
	}

	public abstract String buildCurrent(VariablePage variablePage, int i);

	/**
	 * 实现从最后一页开始打印
	 * 
	 * @return
	 */
	protected final String fromLastPagePrint() {
		StringBuffer buffer = new StringBuffer(100);
		int startPage = variablePage.totalPage - (variablePage.showPageNum - 1);
		for (int i = startPage; i <= variablePage.totalPage; i++) {
			if (i == variablePage.pageNo) {// 如果是当前页:不添加连接URL
				buffer.append(buildCurrent(variablePage, i));
			} else {
				buffer.append(buildA(variablePage, i) + variablePage.split);
			}
		}
		return buffer.toString();
	}

	public String getFirstNo() {
		if (isExistsPagination()) {
			return buildA("首页",  1);
		} else {
			return buildSpan("首页", variablePage);
		}
	}

	/**
	 * 判断是否存在分页
	 * 
	 * @return
	 */
	private boolean isExistsPagination() {
		if (variablePage.totalSum > 1 && variablePage.totalPage > 1) {
			return true;
		}
		return false;
	}

	public String getLastNo() {
		if (isExistsPagination()) {
			return buildA("尾页", variablePage.totalPage);
		} else {
			return buildSpan("尾页", variablePage);
		}
	}

	protected int getValidpageNum() {
		if (variablePage.totalPage < variablePage.pageNo) {
			return variablePage.pageNo = variablePage.totalPage;
		} else if (variablePage.pageNo < 1) {
			return variablePage.pageNo = 1;
		} else {
			return variablePage.pageNo;
		}
	}

	public VariablePage getPageContant() {
		return this.variablePage;
	}

	public abstract String buildSpan(String text, VariablePage variablePage);

	public abstract String buildA(String text,int num);

	public abstract String buildA(VariablePage variablePage, int num);

	public String printModifyPageSize(int pageSize) {
		StringBuilder builder = new StringBuilder(100);
		/*<s:select list="{10,20,50}"  onchange="goPage(0,this.value)"/>*/
		int[] arrays={5,10,20};
		
	     
		
		
		
		builder.append("每页<select id='pageSelect' class=\"form-control\">");
		for (int i = 0; i < arrays.length; i++) {
			builder.append("<option>");
			builder.append(arrays[i]+"</option>");
		}
		/*if (pageSize > 0) {
			builder.append(" value='" + pageSize + "' ");
		}*/
		builder.append("</select>条");
		return builder.toString();
	}

	public String getFirst() {
		StringBuilder builder = new StringBuilder(100);
		builder.append("<div align=\"right\"><ul class=\"pagination\" >");
		return builder.toString();
	}

	public String getLast() {
		StringBuilder builder = new StringBuilder(100);
		builder.append("</ul></div>");
		return builder.toString();
	}
}
