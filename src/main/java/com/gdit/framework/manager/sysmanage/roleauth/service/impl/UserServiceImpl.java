package com.gdit.framework.manager.sysmanage.roleauth.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.UserMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.UserService;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;
/**
 * @功能	：查看系统用户列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:16:24
 */

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public SysUser login(String userName,String password) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("loginName", userName);
		param.put("password", password);
		List<SysUser> userList = userMapper.querySysUserList(param);
		if(userList!=null && userList.size()==1){
			return userList.get(0);
		}
		return null;
	}
	
	
	public ResultVO addUser(SysUser user){
		try {
			userMapper.addSysUser(user);
			return ResultVO.success("系统用户添加成功");
		} catch (Exception e) {
			log.error("添加系统用户异常：", e);
			return ResultVO.failure("系统用户添加失败");
		}
	}
	
	public ResultVO deleteUserByUserId(String userId){
		try {
			userMapper.deleteSysUserByUserId(userId);
			return ResultVO.success("系统用户删除成功");
		} catch (Exception e) {
			log.error("删除系统用户异常：", e);
			return ResultVO.failure("系统用户删除失败");
		}
	}
	
	
	public ResultVO deleteUserByUserIds(String[] userIds) {
		try {
			userMapper.deleteSysUserByUserIds(userIds);
			return ResultVO.success("系统用户删除成功");
		} catch (Exception e) {
			log.error("删除系统用户异常：", e);
			return ResultVO.failure("系统用户删除失败");
		}
	}
	
	
	public ResultVO editUser(SysUser user){
		try {
			userMapper.editSysUser(user);
			return ResultVO.success("系统用户修改成功");
		} catch (Exception e) {
			log.error("修改系统用户异常：", e);
			return ResultVO.failure("系统用户修改失败");
		}
	}
	
	
	public int queryUserCount(Map paramMap){
		try {
			return userMapper.querySysUserCount(paramMap);
		} catch (Exception e) {
			log.error("查询系统用户总数异常：", e);
			return 0;
		}
	}
	
	public List<SysUser> queryUserList(Map paramMap){
		try {
			return userMapper.querySysUserList(paramMap);
		} catch (Exception e) {
			log.error("查询系统用户列表异常：", e);
			return null;
		}
	}
	
	
	public SysUser queryUserByUserId(String userId) {
		try {
			return userMapper.querySysUserByUserId(userId);
		} catch (Exception e) {
			log.error("查询系统用户对象异常：", e);
			return null;
		}
	}
	
	/***
	 * 获取用户权限
	 * @param sysUser
	 * @return Map<String, String>  其中key为菜单编码，value为该菜单编码对应的权限值
	 */
	public Map<String, Integer> queryMenuAuthByUser(String userId) {
		
		/**
		 * 以下两行代码不能交换，因为对于一个菜单，如果给用户分配了，同时也给用户所在的角色上分配了，那么是需要以用户上的权限为准的。
		 */
		
		List<Map<String,Integer>> list = userMapper.queryRoleMenuAuthByUser(userId);
		
		Map<String,Integer> list2 = userMapper.queryUserMenuAuthByUser(userId);
		
		if(list==null){
			return list2;
		}
//		list.putAll(list2);

		return list2;
	}
	



}
