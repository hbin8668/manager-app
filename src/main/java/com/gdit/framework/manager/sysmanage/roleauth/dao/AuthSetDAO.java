package com.gdit.framework.manager.sysmanage.roleauth.dao;

public interface AuthSetDAO {

	void userMenuAdd(String userId,String menuCode,Integer optType);
	
	void userRoleAdd(String userId,String roleId,Integer optType);
	
	void menuRoleAdd(String menuCode,String roleId,Integer optType);

}
