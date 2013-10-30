package com.gdit.framework.manager.sysmanager.roleauth;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gdit.framework.manager.common.AbstractTestCase;
import com.gdit.framework.manager.sysmanage.roleauth.service.UserRoleService;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserRole;

public class UserRoleServiceTest extends AbstractTestCase {
	
	UserRoleService userRoleService = null;
	
	UserRole userRole;
	
	@Before
	public void init(){
		userRoleService = context.getBean("userRoleServiceImpl",UserRoleService.class);
		
		userRole = context.getBean("userRole",UserRole.class);
		
	}
	
	/**测试新增用户角色*/
	@Test
	public void testAddUserRole(){
		userRole = context.getBean("userRole",UserRole.class);
		userRoleService.addUserRole(userRole);
	}
	
	/**测试根据主键删除用户角色*/
	@Test
	public void testDeleteUserRoleByUserRoleId(){
		userRoleService.deleteUserRoleByUserRoleId(userRole.getUserRoleId());
	}
	
	/***
	 * 批量删除测试
	 *
	 */
	@Test
	public void testDeleteUserRoleByUserRoleIds(){
		String[] arr = new String[]{"data"};
		userRoleService.deleteUserRoleByUserRoleIds(arr);
	}
	
	/***
	 * 编辑
	 *
	 */
	@Test
	public void testEditUserRole(){
		userRole = context.getBean("userRole",UserRole.class);
		userRoleService.editUserRole(userRole);
	}
	
	/***
	 * 查询总数测试
	 *
	 */
	@Test
	public void testQueryUserRoleCount(){
		int cnt = userRoleService.queryUserRoleCount(null);
		assert cnt == 0 : "表中无数据";
	}
	
	/***
	 * 查询列表
	 *
	 */
	@Test
	public void testQueryUserRoleList(){
		List list = userRoleService.queryUserRoleList(null);
		assert list != null;
	}
	
	/***
	 * 查询用户角色对象
	 *
	 */
	@Test
	public void testQueryUserRoleByUserRoleId(){
		userRole = userRoleService.queryUserRoleByUserRoleId(userRole.getUserRoleId());
		assert userRole!=null:"查无记录";
	}
	
	
}
