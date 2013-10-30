package com.gdit.framework.manager.sysmanage.dev.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.dev.vo.Menu;
/**
 * @功能	：查看菜单列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:16:24
 */

public interface MenuMapper extends SupperMapper{
	
	/**
	 * 新增菜单
	 * @param menu 菜单对象
	 * @throws DAOException
	 */
	public int addMenu(Menu menu) ;
	
	
	/**
	 * 根据主键删除菜单
	 * @param menuCode Menu主键
	 * @throws DAOException
	 */
	public int deleteMenuByMenuCode(String menuCode) ;
	
	/**
	 * 根据主键列表批量删除菜单
	 * @param menuCode Menu主键数组
	 * @throws DAOException
	 */
	public int deleteMenuByMenuCodes(String[] menuCodes) ;
	
	/**
	 * 编辑菜单
	 * @param menu 菜单对象
	 * @throws DAOException
	 */
	public int editMenu(Menu menu) ;
	
	/**
	 * 查询菜单数量
	 * @param paramMap 封装的查询参数
	 */
	public int queryMenuCount(Map paramMap) ;
	/**
	 * 查询菜单列表
	 * @param  paramMap 封装的查询参数
	 */
	public List<Menu> queryMenuList(Map paramMap) ;
	
	/**
	 * 查询菜单详情
	 * @param menuCode Menu主键
	 */
	public Menu queryMenuByMenuCode(String menuCode) ;
	/**
	 * 查询用户菜单
	 * @param userId 用户编号
	 */
	public List<Menu> queryUserMenuList(String userId) ;
	/**
	 * 查询用户快捷菜单
	 * @param userId 用户编号
	 */
	public List<Menu> queryShortcutMenuByUser(String userId);
	
}
