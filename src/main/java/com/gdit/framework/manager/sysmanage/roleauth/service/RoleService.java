package com.gdit.framework.manager.sysmanage.roleauth.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.Role;
/**
 * @功能	：查看角色列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-28 11:15:30
 */

public interface RoleService{
	
	/**
	 * 新增角色
	 * @param role 角色对象
	 */
	public ResultVO addRole(Role role) ;
	
	
	/**
	 * 根据主键删除角色
	 * @param roleId Role主键
	 */
	public ResultVO deleteRoleByRoleId(String roleId) ;
	
	/**
	 * 根据主键列表批量删除角色
	 * @param roleId Role主键数组
	 */
	public ResultVO deleteRoleByRoleIds(String[] roleIds) ;
	
	/**
	 * 编辑角色
	 * @param role 角色对象
	 */
	public ResultVO editRole(Role role) ;
	
	/**
	 * 查询角色数量
	 * @param paramMap 查询参数
	 */
	public int queryRoleCount(Map paramMap) ;
	/**
	 * 查询角色列表
	 * @param paramMap 查询参数
	 */
	public List<Role> queryRoleList(Map paramMap) ;
	
	/**
	 * 查询角色详情
	 * @param roleId Role主键
	 */
	public Role queryRoleByRoleId(String roleId) ;
	
}
