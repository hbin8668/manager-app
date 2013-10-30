package com.gdit.framework.manager.sysmanage.roleauth.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserRole;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.UserRoleMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.UserRoleService;
import com.gdit.framework.common.vo.ResultVO;
import java.util.List;
import java.util.Map;
/**
 * @功能	：查看用户角色列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	private static final Log LOG = LogFactory.getLog(UserRoleServiceImpl.class);
	
	@Autowired
	private UserRoleMapper userroleMapper;
	
	public ResultVO addUserRole(UserRole userRole){
		try {
			userroleMapper.addUserRole(userRole);
			return ResultVO.success("用户角色添加成功");
		} catch (Exception e) {
			LOG.error("添加用户角色异常：", e);
			return ResultVO.failure("用户角色添加失败");
		}
	}
	
	public ResultVO deleteUserRoleByUserRoleId(String userRoleId){
		try {
			userroleMapper.deleteUserRoleByUserRoleId(userRoleId);
			return ResultVO.success("用户角色删除成功");
		} catch (Exception e) {
			LOG.error("删除用户角色异常：", e);
			return ResultVO.failure("用户角色删除失败");
		}
	}
	
	
	public ResultVO deleteUserRoleByUserRoleIds(String[] userRoleIds) {
		try {
			userroleMapper.deleteUserRoleByUserRoleIds(userRoleIds);
			return ResultVO.success("用户角色删除成功");
		} catch (Exception e) {
			LOG.error("删除用户角色异常：", e);
			return ResultVO.failure("用户角色删除失败");
		}
	}
	
	
	public ResultVO editUserRole(UserRole userRole){
		try {
			userroleMapper.editUserRole(userRole);
			return ResultVO.success("用户角色修改成功");
		} catch (Exception e) {
			LOG.error("修改用户角色异常：", e);
			return ResultVO.failure("用户角色修改失败");
		}
	}
	
	
	public int queryUserRoleCount(Map paramMap){
		try {
			return userroleMapper.queryUserRoleCount(paramMap);
		} catch (Exception e) {
			LOG.error("查询用户角色总数异常：", e);
			return 0;
		}
	}
	
	public List<UserRole> queryUserRoleList(Map paramMap){
		try {
			return userroleMapper.queryUserRoleList(paramMap);
		} catch (Exception e) {
			LOG.error("查询用户角色列表异常：", e);
			return null;
		}
	}
	
	
	public UserRole queryUserRoleByUserRoleId(String userRoleId) {
		try {
			return userroleMapper.queryUserRoleByUserRoleId(userRoleId);
		} catch (Exception e) {
			LOG.error("查询用户角色对象异常：", e);
			return null;
		}
	}
	
}
