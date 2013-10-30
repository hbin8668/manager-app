package com.gdit.framework.manager.sysmanage.dev.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.mapper.MenuMapper;
import com.gdit.framework.manager.sysmanage.dev.service.MenuService;
import com.gdit.framework.manager.sysmanage.dev.vo.Menu;
/**
 * @功能	：查看菜单列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-23 09:12:58
 */

@Service
public class MenuServiceImpl implements MenuService {
	
	private static final Log log = LogFactory.getLog(MenuServiceImpl.class);
	
	@Autowired
	private MenuMapper menuMapper;
	
	public ResultVO addMenu(Menu menu){
		try {
			menuMapper.addMenu(menu);
			return ResultVO.success("菜单添加成功");
		} catch (Exception e) {
			log.error("添加菜单异常：", e);
			return ResultVO.failure("菜单添加失败");
		}
	}
	
	public ResultVO deleteMenuByMenuCode(String menuCode){
		try {
			menuMapper.deleteMenuByMenuCode(menuCode);
			return ResultVO.success("菜单删除成功");
		} catch (Exception e) {
			log.error("删除菜单异常：", e);
			return ResultVO.failure("菜单删除失败");
		}
	}
	
	
	public ResultVO deleteMenuByMenuCodes(String[] menuCodes) {
		try {
			menuMapper.deleteMenuByMenuCodes(menuCodes);
			return ResultVO.success("菜单删除成功");
		} catch (Exception e) {
			log.error("删除菜单异常：", e);
			return ResultVO.failure("菜单删除失败");
		}
	}
	
	
	public ResultVO editMenu(Menu menu){
		try {
			menuMapper.editMenu(menu);
			return ResultVO.success("菜单修改成功");
		} catch (Exception e) {
			log.error("修改菜单异常：", e);
			return ResultVO.failure("菜单修改失败");
		}
	}
	
	
	public int queryMenuCount(Map paramMap){
		try {
			return menuMapper.queryMenuCount(paramMap);
		} catch (Exception e) {
			log.error("查询菜单总数异常：", e);
			return 0;
		}
	}
	
	public List<Menu> queryMenuList(Map paramMap){
		try {
			return menuMapper.queryMenuList(paramMap);
		} catch (Exception e) {
			log.error("查询菜单列表异常：", e);
			return null;
		}
	}
	
	
	public Menu queryMenuByMenuCode(String menuCode) {
		try {
			return menuMapper.queryMenuByMenuCode(menuCode);
		} catch (Exception e) {
			log.error("查询菜单对象异常：", e);
			return null;
		}
	}

	@Override
	public List<Menu> queryUserMenuList(String userId) {
		return menuMapper.queryUserMenuList(userId);
	}

	@Override
	public List<Menu> queryShortcutMenuByUser(String userId) {
		return menuMapper.queryShortcutMenuByUser(userId);
	}
	
	
}
