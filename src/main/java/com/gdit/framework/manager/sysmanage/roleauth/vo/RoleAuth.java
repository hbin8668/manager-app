package com.gdit.framework.manager.sysmanage.roleauth.vo ;

import com.gdit.framework.common.vo.CommonVO ;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-30 16:47:01
 */

public class RoleAuth extends CommonVO{

	private String roleAuthId ;// 角色权限编号
	private String roleId ;// 角色编号
	private String menuCode ;// 菜单编码
	private Integer authCode ;// 权限码
	
	public String getRoleAuthId(){
		return this.roleAuthId ;
	}

	public void setRoleAuthId(String roleAuthId){
		this.roleAuthId=roleAuthId ;
	}
	
	public String getRoleId(){
		return this.roleId ;
	}

	public void setRoleId(String roleId){
		this.roleId=roleId ;
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