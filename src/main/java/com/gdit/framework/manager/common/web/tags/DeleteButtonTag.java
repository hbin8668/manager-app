package com.gdit.framework.manager.common.web.tags;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.gdit.framework.common.util.AuthUtil;
import com.gdit.framework.common.util.Constants;
import com.gdit.framework.common.util.StringUtil;

/***
 * 自定义新增按钮标签。可以根据用户是否有相应的权限是否显示
 * @author EX-HUANGBIN001
 * @2011-12-20
 */
public class DeleteButtonTag extends TagSupport {

	private String menuCode="common";
	
	private String params = "";
	
	private String onClick="";


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			Object obj = request.getSession().getAttribute(Constants.USER_INFO);
			Map<String, String> authSets = (Map<String, String>) request.getSession().getAttribute(Constants.AUTH_SET);

			/****
			 * 如果菜单不是common并且用户未登录，则直接返回。不显示按钮
			 */
			if (!"common".equalsIgnoreCase(menuCode) && (obj == null|| authSets.get(menuCode)== null) ) {
				return SKIP_BODY;
			}

			if (!"common".equalsIgnoreCase(menuCode) ) {
				int authValue = Integer.parseInt(authSets.get(menuCode));
				if (!AuthUtil.hasDelAuth(authValue)) {
					return SKIP_BODY;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("<button ");
			if(!StringUtil.isEmpty(onClick)){
				sb.append(" onClick=\"").append(onClick).append("\" ");
			}
			/***
			 * 解析参数
			 */
			if (params != null && params.length() > 0) {
				String paramsArr[] = params.split("$$");
				for (int index = 0; index < paramsArr.length; index++) {
					String[] arr = paramsArr[index].split("=");
					sb.append(arr[0]).append("=\"").append(arr[1]).append("\" ");
				}
			}
			sb.append("><span class=\"icon_delete\">删除</span></button>");
		
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
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
	
	public static void main( String[] args ) {
		System.out.println("asdg adgasdg ");
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
	
	

}
