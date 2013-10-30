package com.gdit.framework.manager.sysmanage.dev.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.vo.Menu;
/**
 * @功能	：查看菜单列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:12:58
 */

public interface MenuService{
	
	/**
	 * 新增菜单
	 * @param menu 菜单对象
	 */
	public ResultVO addMenu(Menu menu) ;
	
	
	/**
	 * 根据主键删除菜单
	 * @param menuCode Menu主键
	 */
	public ResultVO deleteMenuByMenuCode(String menuCode) ;
	
	/**
	 * 根据主键列表批量删除菜单
	 * @param menuCode Menu主键数组
	 */
	public ResultVO deleteMenuByMenuCodes(String[] menuCodes) ;
	
	/**
	 * 编辑菜单
	 * @param menu 菜单对象
	 */
	public ResultVO editMenu(Menu menu) ;
	
	/**
	 * 查询菜单数量
	 * @param paramMap 查询参数
	 */
	public int queryMenuCount(Map paramMap) ;
	/**
	 * 查询菜单列表
	 * @param paramMap 查询参数
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
	public List<Menu> queryShortcutMenuByUser(String userId) ;
	
}
