package com.gdit.framework.manager.sysmanage.roleauth.mapper;

import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.vo.AuthVO;

/**
 * @功能 ：权限管理
 * @公司 ：
 * @作者 ：hbin
 * @日期 ：2013-10-30 16:47:01
 */

public interface AuthsetMapper extends SupperMapper {

	/**
	 * 给用户分配角色
	 */
	public void addUserRole(AuthVO authVO);

	public void userRoleAdd(String userId, String roleId, int optFlag);

	public void delUserRoleByUserIds(String[] userIds, String roleId);

	public void delUserRoleByRoleIds(String userId, String[] roleIds);

	/**
	 * 菜单分本给用户
	 */
	public void addUserAuth(AuthVO authVO);

	public void userMenuAdd(String userId, String menuCode, int optFlag);

	public void delUserAuthByUserIds(String menuCode, String[] userIds);

	public void delUserAuthByMenuCodes(String userId, String[] menuCodes);

	/**
	 * 将菜单分配给角色
	 */
	public void addRoleAuth(AuthVO authVO);

	public void menuRoleAdd(String menuCode, String roleId, int optFlag);

	public void delRoleAuthByRoleIds(String menuCode, String[] roleIds);

	public void delRoleAuthByMenuCodes(String roleId, String[] menuCodes);
}
