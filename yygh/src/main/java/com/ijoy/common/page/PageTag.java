package com.ijoy.common.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {
	private int pageNo;
	private int pageSize = 10;
	private int totalSum;
	private int showPage = 5;
	private String url;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int doEndTag() throws JspException {
		if (pageSize == 0) {
			return TagSupport.SKIP_PAGE;// 不显示分页
		}
		if(totalSum==0){
			return TagSupport.SKIP_PAGE;// 不显示分页
		}
		/*else if (pageSize > totalSum) {
			return TagSupport.SKIP_BODY;// 不显示分页
		}*/
		JspWriter out = pageContext.getOut();
			VariablePage variablePage = new VariablePage(pageNo, totalSum,
					pageSize, url);
			variablePage.setShowPageNum(showPage);
			Page page = new HtmlPage(variablePage);
			try {
				out.print(page.getFirst()+page.getFirstNo() + " " + page.getBackpageNum() + " "
						+ page.pagination() + " " + page.getNextpageNum() + " "
						+ page.getLastNo()+page.printModifyPageSize(pageSize)+page.getLast());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return super.doEndTag();
	}

	@Override
	public void release() {
		url = null;
		pageNo = 0;
		totalSum = 0;
		pageSize = 10;
		super.release();
	}

	private static final long serialVersionUID = -2642907859641024483L;
}
