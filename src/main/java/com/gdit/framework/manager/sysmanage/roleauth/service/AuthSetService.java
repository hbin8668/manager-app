package com.gdit.framework.manager.sysmanage.roleauth.service;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.manager.sysmanage.vo.AuthList;

public interface AuthSetService {

	// 为菜单添加/删除角色
	public void menuRoleAdd( String menuCode , AuthList authVOList , String optUserName ) throws ServiceException;

	public void menuRoleDel( String menuCode , String[] roleIds , String optUserName ) throws ServiceException;

	
	// 为菜单添加、删除用户
	public void menuUserDel( String menuCode , String[] userIds , String optUserName ) throws ServiceException;

	public void menuUserAdd( String menuCode , AuthList authVOList , String optUserName ) throws ServiceException;

	// 为角色添加删除菜单
	public void roleMenuAdd( String roleId , AuthList authVOList , String optUserName ) throws ServiceException;

	public void roleMenuDel( String roleId , String[] menuCodes , String optUserName ) throws ServiceException;

	// 为角色添加删除用户
	public void roleUserAdd( String roleId , String[] userIds , String optUserName ) throws ServiceException;

	public void roleUserDel( String roleId , String[] userIds , String optUserName ) throws ServiceException;

	// 用户添加删除菜单
	public void userMenuAdd( String userId ,  AuthList authVOList , String optUserName )
			throws ServiceException;

	public void userMenuDel( String userId , String menuCode[] , String optUserName ) throws ServiceException;

	public void userRoleAdd( String userId , String[] roleIds , String optUserName ) throws ServiceException;

	public void userRoleDel( String userId , String[] roleIds , String optUserName ) throws ServiceException;

}
