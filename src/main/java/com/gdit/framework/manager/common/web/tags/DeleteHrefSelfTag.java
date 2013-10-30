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
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;

/***
 * 自定义新增按钮标签。可以根据用户是否有相应的权限是否显示
 * @author EX-HUANGBIN001
 * @2011-12-20
 */
public class DeleteHrefSelfTag extends TagSupport {

	private String menuCode="common";
	
	private String params = "";
	
	private String onClick = "";
	
	private String fcu;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			SysUser obj = (SysUser)request.getSession().getAttribute(Constants.USER_INFO);
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
			
			//如果创建人不等于登录用户的username，则不允许出现编辑按钮
			if(!obj.getUserId().equals(fcu)){
				return SKIP_BODY;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("<span class=\"img_delete hand\" title=\"删除\" ");
			if(!StringUtil.isEmpty(onClick)){
				sb.append(" onClick=\"").append(onClick).append("\" ");
			}
			int len = 0;
			String str = "";//存储参数键值对
			if (params != null && params.length() > 0) {
				String paramsArr[] = params.split("$$");
				for (int index = 0; index < paramsArr.length; index++) {
					str = paramsArr[index];
					len = str.indexOf("=");
					sb.append(str.substring(0, len)).append("=\"").append(str.substring(len+1, str.length())).append("\" ");
				}
			}
			sb.append("></span>");
			/***
			 * 解析参数
			 */
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
	
	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getFcu() {
		return fcu;
	}

	public void setFcu(String fcu) {
		this.fcu = fcu;
	}
	
	

}
