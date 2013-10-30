package com.gdit.framework.manager.sysmanage.roleauth.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserRole;
/**
 * @功能	：查看用户角色列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

public interface UserRoleService{
	
	/**
	 * 新增用户角色
	 * @param userRole 用户角色对象
	 */
	public ResultVO addUserRole(UserRole userRole) ;
	
	
	/**
	 * 根据主键删除用户角色
	 * @param userRoleId UserRole主键
	 */
	public ResultVO deleteUserRoleByUserRoleId(String userRoleId) ;
	
	/**
	 * 根据主键列表批量删除用户角色
	 * @param userRoleId UserRole主键数组
	 */
	public ResultVO deleteUserRoleByUserRoleIds(String[] userRoleIds) ;
	
	/**
	 * 编辑用户角色
	 * @param userRole 用户角色对象
	 */
	public ResultVO editUserRole(UserRole userRole) ;
	
	/**
	 * 查询用户角色数量
	 * @param paramMap 查询参数
	 */
	public int queryUserRoleCount(Map paramMap) ;
	/**
	 * 查询用户角色列表
	 * @param paramMap 查询参数
	 */
	public List<UserRole> queryUserRoleList(Map paramMap) ;
	
	/**
	 * 查询用户角色详情
	 * @param userRoleId UserRole主键
	 */
	public UserRole queryUserRoleByUserRoleId(String userRoleId) ;
	
}
