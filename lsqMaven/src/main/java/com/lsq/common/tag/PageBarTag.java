package com.lsq.common.tag;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.lsq.common.util.PaginationSortOrderData;




/**
 * 分页下拉框标�?
 * 
 * @author JamesJiang
 * @version 1.00 2010-3-23 下午06:38:59
 * @since JDK1.5
 */
public class PageBarTag extends TagSupport{

	private static final long serialVersionUID = 4707064945294847682L;

	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest reuqest = (HttpServletRequest)pageContext.getRequest();
		PaginationSortOrderData page = (PaginationSortOrderData)reuqest.getAttribute("page");
		
		StringBuffer html = new StringBuffer();
		html.append("<input type=\"hidden\" name=\"page.curPage\" value=\""+page.getCurPage()+"\"/>\n");
		html.append("<input type=\"hidden\" name=\"page.sortValue\" value=\""+page.getSortValue()+"\"/>\n");
		html.append("<input type=\"hidden\" name=\"page.hasAscing\" value=\""+page.isHasAscing()+"\"/>\n");
		html.append(page.getHtmlString());
		try {
			pageContext.getOut().write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
