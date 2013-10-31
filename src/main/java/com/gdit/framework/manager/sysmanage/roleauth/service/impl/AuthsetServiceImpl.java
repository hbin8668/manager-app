package com.gdit.framework.manager.sysmanage.roleauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.common.util.StringUtil;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.AuthsetMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.AuthSetService;
import com.gdit.framework.manager.sysmanage.vo.AuthList;
import com.gdit.framework.manager.sysmanage.vo.AuthVO;

@Service
public class AuthsetServiceImpl implements AuthSetService {

	@Autowired
	private AuthsetMapper authdetMapper;

	// 为菜单添加角色
	@Transactional
	public void menuRoleAdd(String menuCode, AuthList authVOList,
			String optUserName) throws ServiceException {

		List<AuthVO> list = authVOList.getAuthList();
		for (AuthVO vo : list) {
			if (StringUtil.isEmpty(vo.getRoleId()) || vo.getAuthValue() == 0) {
				continue;
			}
			vo.setMenuCode(menuCode);
			authdetMapper.addRoleAuth(vo);
			authdetMapper.menuRoleAdd(menuCode, vo.getRoleId(), 1);
		}
	}

	// 将菜单从选定的角色中删除
	@Transactional
	public void menuRoleDel(String menuCode, String[] roleIds,
			String optUserName) throws ServiceException {
		authdetMapper.delRoleAuthByRoleIds(menuCode, roleIds);
		for (int index = 0; index < roleIds.length; index++) {
			authdetMapper.menuRoleAdd(menuCode, roleIds[index], 2);
		}
	}

	// 把菜单添加给指定的用户
	@Transactional
	public void menuUserAdd(String menuCode, AuthList authVOList,
			String optUserName) throws ServiceException {
		List<AuthVO> list = authVOList.getAuthList();
		for (AuthVO vo : list) {
			if (StringUtil.isEmpty(vo.getUserId()) || vo.getAuthValue() == 0) {
				continue;
			}
			vo.setMenuCode(menuCode);
			authdetMapper.addUserAuth(vo);
			authdetMapper.userMenuAdd(vo.getUserId(), menuCode, 1);
		}

	}

	// 从指定菜单上删除用户
	@Transactional
	public void menuUserDel(String menuCode, String[] userIds,
			String optUserName) throws ServiceException {
		authdetMapper.delUserAuthByUserIds(menuCode, userIds);
		for (int index = 0; index < userIds.length; index++) {
			authdetMapper.userMenuAdd(userIds[index], menuCode, 2);
		}

	}

	// 给角色新增菜单
	@Transactional
	public void roleMenuAdd(String roleId, AuthList authVOList,
			String optUserName) throws ServiceException {
		List<AuthVO> list = authVOList.getAuthList();
		for (AuthVO vo : list) {
			if (StringUtil.isEmpty(vo.getMenuCode()) || vo.getAuthValue() == 0) {
				continue;
			}
			vo.setRoleId(roleId);
			authdetMapper.addRoleAuth(vo);
			authdetMapper.menuRoleAdd(vo.getMenuCode(), roleId, 1);
		}
	}

	// 从角色中删除菜单
	@Transactional
	public void roleMenuDel(String roleId, String[] menuCodes,
			String optUserName) throws ServiceException {
		authdetMapper.delRoleAuthByMenuCodes(roleId, menuCodes);
		for (int index = 0; index < menuCodes.length; index++) {
			authdetMapper.menuRoleAdd(menuCodes[index], roleId, 2);
		}
	}

	@Transactional
	public void roleUserAdd(String roleId, String[] userIds, String optUserName)
			throws ServiceException {
		AuthVO auth = new AuthVO();
		auth.setRoleId(roleId);
		for (int index = 0; index < userIds.length; index++) {
			auth.setUserId(userIds[index]);
			auth.setFcu(optUserName);
			auth.setLcu(optUserName);
			authdetMapper.addUserRole(auth);
			authdetMapper.userRoleAdd(userIds[index], roleId, 1);
		}
	}

	@Transactional
	public void roleUserDel(String roleId, String[] userIds, String optUserName)
			throws ServiceException {
		authdetMapper.delUserRoleByUserIds(userIds, roleId);
		for (int index = 0; index < userIds.length; index++) {
			authdetMapper.userRoleAdd(userIds[index], roleId, 2);
		}
	}

	@Transactional
	public void userMenuAdd(String userId, AuthList authVOList,
			String optUserName) throws ServiceException {
		List<AuthVO> list = authVOList.getAuthList();
		for (AuthVO vo : list) {
			if (StringUtil.isEmpty(vo.getMenuCode()) || vo.getAuthValue() == 0) {
				continue;
			}
			vo.setUserId(userId);
			vo.setFcu(optUserName);
			vo.setLcu(optUserName);
			authdetMapper.addUserAuth(vo);
			authdetMapper.userMenuAdd(userId, vo.getMenuCode(), 1);
		}

	}

	@Transactional
	public void userMenuDel(String userId, String[] menuCodes,
			String optUserName) throws ServiceException {
		authdetMapper.delUserAuthByMenuCodes(userId, menuCodes);
		for (int index = 0; index < menuCodes.length; index++) {
			authdetMapper.userMenuAdd(userId, menuCodes[index], 2);
		}
	}

	@Transactional
	public void userRoleAdd(String userId, String[] roleIds, String optUserName)
			throws ServiceException {
		AuthVO vo = new AuthVO();
		for (int index = 0; index < roleIds.length; index++) {
			vo.setRoleId(roleIds[index]);
			vo.setUserId(userId);
			vo.setFcu(optUserName);
			vo.setLcu(optUserName);
			authdetMapper.addUserRole(vo);
			authdetMapper.userRoleAdd(userId, roleIds[index], 1);
		}
	}

	@Transactional
	public void userRoleDel(String userId, String[] roleIds, String optUserName)
			throws ServiceException {
		authdetMapper.delUserRoleByRoleIds(userId, roleIds);
		for (int index = 0; index < roleIds.length; index++) {
			authdetMapper.userRoleAdd(userId, roleIds[index], 2);
		}
	}

}
