package com.lsq.common.tag;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.lsq.common.util.PaginationSortOrderData;



/**
 * 分页初始化标�?
 * 
 * @author JamesJiang
 * @version 1.00 2010-3-23 上午11:06:33
 * @since JDK1.5
 */
public class PageDefaultTag extends TagSupport {

	private static final long serialVersionUID = 4457016876347872825L;
	private String urlPath = "";//分页提交URL路径

	@Override
	public int doEndTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		PaginationSortOrderData page = (PaginationSortOrderData)request.getAttribute("page");

		
		StringBuffer html = new StringBuffer();
		html.append("<script type=\"text/javascript\">\n");
		html.append("function gotoPage(page){\n");
		html.append("var strP=/^\\+?[1-9][0-9]*$/;\n");
		html.append("var curPage=1;\n");
		html.append("if(!strP.test(page)){\n");
		html.append("curPage=1;\n");
		html.append("} else {\n");
		html.append("curPage=page;\n");
		html.append("}\n");
		html.append("document.pageForm.elements[\"page.curPage\"].value = curPage;\n");
		html.append("document.pageForm.action = \"" + urlPath + "\";\n");
		html.append("document.pageForm.submit();\n");
		html.append("}\n");

		html.append("function sortTable(sortValue,hasAscing){\n");
		html.append("document.pageForm.elements[\"page.curPage\"].value = 1;\n");
		html.append("document.pageForm.elements[\"page.sortValue\"].value = sortValue;\n");
		html.append("if('"+page.getSortValue()+"' == sortValue){\n");
		html.append("document.pageForm.elements[\"page.hasAscing\"].value = !hasAscing;\n");
		html.append("} else {\n");
		html.append("document.pageForm.elements[\"page.hasAscing\"].value = hasAscing;\n");
		html.append("}\n");
		html.append("document.pageForm.action = \"" + urlPath + "\";\n");
		html.append("document.pageForm.submit();\n");
		html.append("}\n");

		html.append("</script>\n");
		try {
			pageContext.getOut().write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

}
