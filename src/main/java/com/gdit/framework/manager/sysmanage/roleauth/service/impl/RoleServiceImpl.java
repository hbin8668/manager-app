package com.gdit.framework.manager.sysmanage.roleauth.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.RoleMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.RoleService;
import com.gdit.framework.manager.sysmanage.roleauth.vo.Role;
/**
 * @功能	：查看角色列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-28 11:15:30
 */

@Service
public class RoleServiceImpl implements RoleService {
	
	private static final Log LOG = LogFactory.getLog(RoleServiceImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	public ResultVO addRole(Role role){
		try {
			roleMapper.addRole(role);
			return ResultVO.success("角色添加成功");
		} catch (Exception e) {
			LOG.error("添加角色异常：", e);
			return ResultVO.failure("角色添加失败");
		}
	}
	
	@Transactional
	public ResultVO deleteRoleByRoleId(String roleId){
		try {
			/***
			 * 如果有用户拥有该角色则一并删除
			 */
			roleMapper.deleteUserRoleRelationByRole(roleId);
			roleMapper.deleteRoleAuthRelationByRole(roleId);
			//调存储过程处理用户菜单信息表
			
			roleMapper.deleteRoleByRoleId(roleId);
			return ResultVO.success("角色删除成功");
		} catch (Exception e) {
			LOG.error("删除角色异常：", e);
			return ResultVO.failure("角色删除失败");
		}
	}
	
	
	public ResultVO deleteRoleByRoleIds(String[] roleIds) {
		try {
			roleMapper.deleteRoleByRoleIds(roleIds);
			return ResultVO.success("角色删除成功");
		} catch (Exception e) {
			LOG.error("删除角色异常：", e);
			return ResultVO.failure("角色删除失败");
		}
	}
	
	
	public ResultVO editRole(Role role){
		try {
			roleMapper.editRole(role);
			return ResultVO.success("角色修改成功");
		} catch (Exception e) {
			LOG.error("修改角色异常：", e);
			return ResultVO.failure("角色修改失败");
		}
	}
	
	
	public int queryRoleCount(Map paramMap){
		try {
			return roleMapper.queryRoleCount(paramMap);
		} catch (Exception e) {
			LOG.error("查询角色总数异常：", e);
			return 0;
		}
	}
	
	public List<Role> queryRoleList(Map paramMap){
		try {
			return roleMapper.queryRoleList(paramMap);
		} catch (Exception e) {
			LOG.error("查询角色列表异常：", e);
			return null;
		}
	}
	
	
	public Role queryRoleByRoleId(String roleId) {
		try {
			return roleMapper.queryRoleByRoleId(roleId);
		} catch (Exception e) {
			LOG.error("查询角色对象异常：", e);
			return null;
		}
	}

	@Override
	public ResultVO deleteUserRoleRelationByRole(String roleId) {
		try {
			roleMapper.deleteUserRoleRelationByRole(roleId);
			return ResultVO.success("删除用户角色关系成功");
		} catch (Exception e) {
			LOG.error("删除用户角色关系异常：", e);
			return ResultVO.failure("删除用户角色关系异常");
		}
	}
	
}
