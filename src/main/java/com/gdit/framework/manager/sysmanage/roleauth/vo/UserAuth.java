package com.gdit.framework.manager.sysmanage.roleauth.vo ;

import com.gdit.framework.common.vo.CommonVO ;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-30 16:47:01
 */

public class UserAuth extends CommonVO{

	private String userAuthId ;// 用户权限编号
	private String userId ;// 用户编号
	private String menuCode ;// 菜单编码
	private Integer authCode ;// 权限码
	
	public String getUserAuthId(){
		return this.userAuthId ;
	}

	public void setUserAuthId(String userAuthId){
		this.userAuthId=userAuthId ;
	}
	
	public String getUserId(){
		return this.userId ;
	}

	public void setUserId(String userId){
		this.userId=userId ;
	}
	
	public String getMenuCode(){
		return this.menuCode ;
	}

	public void setMenuCode(String menuCode){
		this.menuCode=menuCode ;
	}
	
	public Integer getAuthCode(){
		return this.authCode ;
	}

	public void setAuthCode(Integer authCode){
		this.authCode=authCode ;
	}
	
}