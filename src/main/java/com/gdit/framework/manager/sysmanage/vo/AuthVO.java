package com.gdit.framework.manager.sysmanage.vo;

import com.gdit.framework.common.vo.CommonVO;




public class AuthVO  extends CommonVO{
	
	private String userId;
	private String roleId;
	private String menuCode;
	
	private int authValue;
	
	private String[] authCodes;
	
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(15));
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAuthValue() {
		int authValues = 0 ;
		if(authCodes!=null && authCodes.length>0)
		{
			for(int index=0;index<authCodes.length;index++)
			{
				authValues+=Integer.parseInt(authCodes[index]);
			}
		}
		return authValues;
	}
	public void setAuthValue(int authValue) {
		this.authValue = authValue;
	}
	
	public String[] getAuthCodes() {
		return authCodes;
	}
	public void setAuthCodes(String[] authCodes) {
		this.authCodes = authCodes;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
}
