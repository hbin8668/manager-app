package com.gdit.framework.manager.sysmanage.roleauth.vo;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-28 11:15:30
 */

public class Role extends CommonVO {

	private String roleId;// 角色编号
	private String roleName;// 角色名称
	private String roleType;// 角色类型(SYS)
	private String dateState;// 数据状态
	private String description;// 描述

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDateState() {
		return this.dateState;
	}

	public void setDateState(String dateState) {
		this.dateState = dateState;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}