package com.gdit.framework.manager.sysmanage.roleauth.vo ;

import com.gdit.framework.common.vo.CommonVO ;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-30 16:47:01
 */

public class UserRole extends CommonVO{

	private String userRoleId ;// 用户角色编号
	private String userId ;// 用户ID
	private String roleId ;// 角色ID
	
	public String getUserRoleId(){
		return this.userRoleId ;
	}

	public void setUserRoleId(String userRoleId){
		this.userRoleId=userRoleId ;
	}
	
	public String getUserId(){
		return this.userId ;
	}

	public void setUserId(String userId){
		this.userId=userId ;
	}
	
	public String getRoleId(){
		return this.roleId ;
	}

	public void setRoleId(String roleId){
		this.roleId=roleId ;
	}
	
}