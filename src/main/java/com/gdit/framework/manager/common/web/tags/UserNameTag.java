package com.gdit.framework.manager.common.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.gdit.framework.common.util.StringUtil;

/***
 * 自定义显示用户名标签 将userId:userName分隔后显示
 * 
 * @author EX-HUANGBIN001
 * @2011-12-20
 */
public class UserNameTag extends TagSupport {

	private String userId;
	
	private String userInfo;
	
	private String id;
	
	private String name;
	
	private String parse;//是否需要对userId解析后显示
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			StringBuilder sb = new StringBuilder();
			/***
			 * 解析参数
			 */
			
			sb.append("<input type='text' ");
			sb.append("id='").append(id).append("' ");
			sb.append("name='").append(name).append("' ");
			String value = "";
			if(StringUtil.isNotEmpty(userId)){
//				value = userMap.get(userId);
			}else{
				value = userInfo.split(":")[1];
			}
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	
}
