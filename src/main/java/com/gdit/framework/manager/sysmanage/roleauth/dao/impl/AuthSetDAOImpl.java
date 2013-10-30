package com.gdit.framework.manager.sysmanage.roleauth.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.gdit.framework.manager.sysmanage.roleauth.dao.AuthSetDAO;

@Repository
public class AuthSetDAOImpl extends SqlSessionDaoSupport implements AuthSetDAO {

	public void menuRoleAdd(String menuCode, String roleId, Integer optType) {
		Map map = new HashMap();
		map.put("menuCode", menuCode);
		map.put("roleId", roleId);
		map.put("optType", optType);
		this.getSqlSession().selectOne("sm.authrole.addMenuRole", map);
	}

	public void userMenuAdd(String userId, String menuCode, Integer optType) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("menuCode", menuCode);
		map.put("optType", optType);
		this.getSqlSession().selectOne("sm.authrole.addUserMenu", map);
	}

	public void userRoleAdd(String userId, String roleId, Integer optType) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("roleId", roleId);
		map.put("optType", optType);
		this.getSqlSession().selectOne("sm.authrole.addUserRole", map);
	}

}
