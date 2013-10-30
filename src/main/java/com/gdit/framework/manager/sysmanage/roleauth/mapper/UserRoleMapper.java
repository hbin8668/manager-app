package com.gdit.framework.manager.sysmanage.roleauth.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserRole;
/**
 * @功能	：查看用户角色列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

public interface UserRoleMapper extends SupperMapper{
	
	/**
	 * 新增用户角色
	 * @param userRole 用户角色对象
	 * @throws DAOException
	 */
	public int addUserRole(UserRole userRole) ;
	
	
	/**
	 * 根据主键删除用户角色
	 * @param userRoleId UserRole主键
	 * @throws DAOException
	 */
	public int deleteUserRoleByUserRoleId(String userRoleId) ;
	
	/**
	 * 根据主键列表批量删除用户角色
	 * @param userRoleId UserRole主键数组
	 * @throws DAOException
	 */
	public int deleteUserRoleByUserRoleIds(String[] userRoleIds) ;
	
	/**
	 * 编辑用户角色
	 * @param userRole 用户角色对象
	 * @throws DAOException
	 */
	public int editUserRole(UserRole userRole) ;
	
	/**
	 * 查询用户角色数量
	 * @param paramMap 封装的查询参数
	 */
	public int queryUserRoleCount(Map paramMap) ;
	/**
	 * 查询用户角色列表
	 * @param  paramMap 封装的查询参数
	 */
	public List<UserRole> queryUserRoleList(Map paramMap) ;
	
	/**
	 * 查询用户角色详情
	 * @param userRoleId UserRole主键
	 */
	public UserRole queryUserRoleByUserRoleId(String userRoleId) ;
	
}
