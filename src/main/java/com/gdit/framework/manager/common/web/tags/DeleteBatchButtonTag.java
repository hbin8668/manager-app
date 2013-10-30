package com.gdit.framework.manager.common.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.gdit.framework.common.util.StringUtil;

/***
 * 自定义新增按钮标签。可以根据用户是否有相应的权限是否显示
 * 
 * @author EX-HUANGBIN001
 * @2011-12-20
 */
public class DeleteBatchButtonTag extends TagSupport {

	private String menuCode = "common";

	private String params = "";

	private String onClick="";
	
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			Object obj = request.getSession().getAttribute("currentUser");

			if (!"common".equalsIgnoreCase(menuCode) && obj == null) {
				return SKIP_BODY;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("<button");
			if(!StringUtil.isEmpty(onClick)){
				sb.append(" onClick=\"").append(onClick).append("\" ");
			}
			if (params != null && params.length() > 0) {
				String paramsArr[] = params.split("$$");
				for (int index = 0; index < paramsArr.length; index++) {
					String[] arr = paramsArr[index].split("=");
					sb.append(arr[0]).append("=\"").append(arr[1]).append("\" ");
				}
			}
			sb.append("><span class=\"icon_delete\">批量删除</span></span>");
			sb.append("");
			if ("common".equalsIgnoreCase(menuCode)) {
				out.print(sb.toString());
				return EVAL_BODY_INCLUDE;
			}
			/***
			 * 解析参数
			 */

			if (obj != null) {
				out.print(sb.toString());
				return EVAL_BODY_INCLUDE;
			}
			else {
				return EVAL_PAGE;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode( String menuCode ) {
		this.menuCode = menuCode;
	}

	public String getParams() {
		return params;
	}

	public void setParams( String params ) {
		this.params = params;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
	
	

}
