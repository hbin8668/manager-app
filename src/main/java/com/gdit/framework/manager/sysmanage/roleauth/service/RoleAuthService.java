package com.gdit.framework.manager.sysmanage.roleauth.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.RoleAuth;
/**
 * @功能	：查看角色权限列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

public interface RoleAuthService{
	
	/**
	 * 新增角色权限
	 * @param roleAuth 角色权限对象
	 */
	public ResultVO addRoleAuth(RoleAuth roleAuth) ;
	
	
	/**
	 * 根据主键删除角色权限
	 * @param roleAuthId RoleAuth主键
	 */
	public ResultVO deleteRoleAuthByRoleAuthId(String roleAuthId) ;
	
	/**
	 * 根据主键列表批量删除角色权限
	 * @param roleAuthId RoleAuth主键数组
	 */
	public ResultVO deleteRoleAuthByRoleAuthIds(String[] roleAuthIds) ;
	
	/**
	 * 编辑角色权限
	 * @param roleAuth 角色权限对象
	 */
	public ResultVO editRoleAuth(RoleAuth roleAuth) ;
	
	/**
	 * 查询角色权限数量
	 * @param paramMap 查询参数
	 */
	public int queryRoleAuthCount(Map paramMap) ;
	/**
	 * 查询角色权限列表
	 * @param paramMap 查询参数
	 */
	public List<RoleAuth> queryRoleAuthList(Map paramMap) ;
	
	/**
	 * 查询角色权限详情
	 * @param roleAuthId RoleAuth主键
	 */
	public RoleAuth queryRoleAuthByRoleAuthId(String roleAuthId) ;
	
}
