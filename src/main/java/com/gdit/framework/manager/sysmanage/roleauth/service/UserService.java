package com.gdit.framework.manager.sysmanage.roleauth.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;
/**
 * @功能	：查看系统用户列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:16:24
 */

public interface UserService{
	
	/**
	 * 判断指定条件的用户是否存在
	 * @return
	 */
	public SysUser login(String userName,String password) ;
	
	
	/**
	 * 新增系统用户
	 * @param user 系统用户对象
	 */
	public ResultVO addUser(SysUser user) ;
	
	/**
	 * 根据主键删除系统用户
	 * @param userId SysUser主键
	 */
	public ResultVO deleteUserByUserId(String userId) ;
	
	/**
	 * 根据主键列表批量删除系统用户
	 * @param userId SysUser主键数组
	 */
	public ResultVO deleteUserByUserIds(String[] userIds) ;
	
	/**
	 * 编辑系统用户
	 * @param user 系统用户对象
	 */
	public ResultVO editUser(SysUser user) ;
	
	/**
	 * 查询系统用户数量
	 * @param paramMap 查询参数
	 */
	public int queryUserCount(Map paramMap) ;
	/**
	 * 查询系统用户列表
	 * @param paramMap 查询参数
	 */
	public List<SysUser> queryUserList(Map paramMap) ;
	
	/**
	 * 查询系统用户详情
	 * @param userId SysUser主键
	 */
	public SysUser queryUserByUserId(String userId) ;
	
	/***
	 * 获取用户权限
	 * @param sysUser
	 * @return Map<String, String>  其中key为菜单编码，value为该菜单编码对应的权限值
	 */
	public Map<String, Integer> queryMenuAuthByUser(String userId) ;
	
	
}
