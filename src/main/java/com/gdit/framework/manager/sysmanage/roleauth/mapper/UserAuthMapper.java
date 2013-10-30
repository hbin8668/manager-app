package com.gdit.framework.manager.sysmanage.roleauth.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserAuth;
/**
 * @功能	：查看用户权限列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

public interface UserAuthMapper extends SupperMapper{
	
	/**
	 * 新增用户权限
	 * @param userAuth 用户权限对象
	 * @throws DAOException
	 */
	public int addUserAuth(UserAuth userAuth) ;
	
	
	/**
	 * 根据主键删除用户权限
	 * @param userAuthId UserAuth主键
	 * @throws DAOException
	 */
	public int deleteUserAuthByUserAuthId(String userAuthId) ;
	
	/**
	 * 根据主键列表批量删除用户权限
	 * @param userAuthId UserAuth主键数组
	 * @throws DAOException
	 */
	public int deleteUserAuthByUserAuthIds(String[] userAuthIds) ;
	
	/**
	 * 编辑用户权限
	 * @param userAuth 用户权限对象
	 * @throws DAOException
	 */
	public int editUserAuth(UserAuth userAuth) ;
	
	/**
	 * 查询用户权限数量
	 * @param paramMap 封装的查询参数
	 */
	public int queryUserAuthCount(Map paramMap) ;
	/**
	 * 查询用户权限列表
	 * @param  paramMap 封装的查询参数
	 */
	public List<UserAuth> queryUserAuthList(Map paramMap) ;
	
	/**
	 * 查询用户权限详情
	 * @param userAuthId UserAuth主键
	 */
	public UserAuth queryUserAuthByUserAuthId(String userAuthId) ;
	
}
