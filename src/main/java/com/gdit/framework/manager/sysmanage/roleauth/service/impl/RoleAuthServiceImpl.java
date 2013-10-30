package com.gdit.framework.manager.sysmanage.roleauth.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.RoleAuthMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.RoleAuthService;
import com.gdit.framework.manager.sysmanage.roleauth.vo.RoleAuth;
/**
 * @功能	：查看角色权限列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

@Service
public class RoleAuthServiceImpl implements RoleAuthService {
	
	private static final Log LOG = LogFactory.getLog(RoleAuthServiceImpl.class);
	
	@Autowired
	private RoleAuthMapper roleauthMapper;
	
	public ResultVO addRoleAuth(RoleAuth roleAuth){
		try {
			roleauthMapper.addRoleAuth(roleAuth);
			return ResultVO.success("角色权限添加成功");
		} catch (Exception e) {
			LOG.error("添加角色权限异常：", e);
			return ResultVO.failure("角色权限添加失败");
		}
	}
	
	public ResultVO deleteRoleAuthByRoleAuthId(String roleAuthId){
		try {
			roleauthMapper.deleteRoleAuthByRoleAuthId(roleAuthId);
			return ResultVO.success("角色权限删除成功");
		} catch (Exception e) {
			LOG.error("删除角色权限异常：", e);
			return ResultVO.failure("角色权限删除失败");
		}
	}
	
	
	public ResultVO deleteRoleAuthByRoleAuthIds(String[] roleAuthIds) {
		try {
			roleauthMapper.deleteRoleAuthByRoleAuthIds(roleAuthIds);
			return ResultVO.success("角色权限删除成功");
		} catch (Exception e) {
			LOG.error("删除角色权限异常：", e);
			return ResultVO.failure("角色权限删除失败");
		}
	}
	
	
	public ResultVO editRoleAuth(RoleAuth roleAuth){
		try {
			roleauthMapper.editRoleAuth(roleAuth);
			return ResultVO.success("角色权限修改成功");
		} catch (Exception e) {
			LOG.error("修改角色权限异常：", e);
			return ResultVO.failure("角色权限修改失败");
		}
	}
	
	
	public int queryRoleAuthCount(Map paramMap){
		try {
			return roleauthMapper.queryRoleAuthCount(paramMap);
		} catch (Exception e) {
			LOG.error("查询角色权限总数异常：", e);
			return 0;
		}
	}
	
	public List<RoleAuth> queryRoleAuthList(Map paramMap){
		try {
			return roleauthMapper.queryRoleAuthList(paramMap);
		} catch (Exception e) {
			LOG.error("查询角色权限列表异常：", e);
			return null;
		}
	}
	
	
	public RoleAuth queryRoleAuthByRoleAuthId(String roleAuthId) {
		try {
			return roleauthMapper.queryRoleAuthByRoleAuthId(roleAuthId);
		} catch (Exception e) {
			LOG.error("查询角色权限对象异常：", e);
			return null;
		}
	}
	
}
