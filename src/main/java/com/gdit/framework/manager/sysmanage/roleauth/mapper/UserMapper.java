package com.gdit.framework.manager.sysmanage.roleauth.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.dev.vo.Menu;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;
/**
 * @功能	：查看系统用户列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:16:24
 */

public interface UserMapper extends SupperMapper{
	
	/**
	 * 新增系统用户
	 * @param user 系统用户对象
	 * @throws DAOException
	 */
	public int addSysUser(SysUser user) ;
	
	
	/**
	 * 根据主键删除系统用户
	 * @param userId SysUser主键
	 * @throws DAOException
	 */
	public int deleteSysUserByUserId(String userId) ;
	
	/**
	 * 根据主键列表批量删除系统用户
	 * @param userId SysUser主键数组
	 * @throws DAOException
	 */
	public int deleteSysUserByUserIds(String[] userIds) ;
	
	/**
	 * 编辑系统用户
	 * @param user 系统用户对象
	 * @throws DAOException
	 */
	public int editSysUser(SysUser user) ;
	
	/**
	 * 查询系统用户数量
	 * @param paramMap 封装的查询参数
	 */
	public int querySysUserCount(Map paramMap) ;
	/**
	 * 查询系统用户列表
	 * @param  paramMap 封装的查询参数
	 */
	public List<SysUser> querySysUserList(Map paramMap) ;
	
	/**
	 * 查询系统用户详情
	 * @param userId 用户编号
	 */
	public SysUser querySysUserByUserId(String userId) ;
	/**
	 * 查询用户拥有的角色上的菜单权限
	 * @param userId 用户编号
	 */
	public List<Map<String,Integer>> queryRoleMenuAuthByUser(String userId) ;
	/**
	 * 查询用户菜单权限
	 * @param userId 用户编号
	 */
	public Map<String,Integer> queryUserMenuAuthByUser(String userId) ;
	/**
	 * 查询用户快捷菜单
	 * @param userId 用户编号
	 */
	public List<Menu> queryShortcutMenuByUser(String userId) ;
	
}
