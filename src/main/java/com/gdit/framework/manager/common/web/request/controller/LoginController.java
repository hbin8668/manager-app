package com.gdit.framework.manager.common.web.request.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gdit.framework.common.annotation.MenuCode;
import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.common.exception.ValidException;
import com.gdit.framework.common.util.Constants;
import com.gdit.framework.common.util.Valid;
import com.gdit.framework.manager.sysmanage.dev.service.MenuService;
import com.gdit.framework.manager.sysmanage.dev.vo.Menu;
import com.gdit.framework.manager.sysmanage.roleauth.service.UserService;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;
import com.gdit.framework.manager.sysmanage.util.MenuDefine;

@Controller
@MenuCode(Constants.COMMON_MENU)
@SessionAttributes( { Constants.USER_INFO, Constants.AUTH_SET, Constants.MENU_SET, Constants.SHORTCUT_MENU })
public class LoginController extends BasicController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/login.shtml")
	public String handle_login(HttpServletRequest request, ModelMap modelMap, SysUser sysUser) throws ServiceException {
		try {
			sysUser = userService.login(sysUser.getUserId(), sysUser.getPassword());

			Valid.isNull(sysUser, "用户名或密码有误");

			/***
			 * 查询用户的菜单
			 */
			List<Menu> menuList = menuService.queryUserMenuList(sysUser.getUserId());

			/**
			 * 获取用户权限
			 */
			Map<String, Integer> userMenuAuth = userService.queryMenuAuthByUser(sysUser.getUserId());
			modelMap.put(Constants.USER_INFO, sysUser);// 当前登录用户
			modelMap.put(Constants.MENU_SET, menuList);// 菜单
			modelMap.put(Constants.AUTH_SET, userMenuAuth);// 权限集

			/**
			 * 快捷菜单
			 */

			List<Menu> shortMenuList = menuService.queryShortcutMenuByUser(sysUser.getUserId());
			modelMap.put("shortcutMenuList", shortMenuList);
			this.sysUser = sysUser;
			this.addLogOpt(MenuDefine.LOGIN, 1, sysUser.getUserId(), "用户登录", null);
			return "/index";
		} catch (ValidException e) {
			modelMap.put("message", e.getMessage());
		} catch (Exception e) {
			this.errorLog("登录异常，请稍后再试", e, request);
		}
		return "/login";
	}

	@RequestMapping("/loginOut.shtml")
	public String handle_loginOut(HttpServletRequest request) {
		if (request.getSession() != null) {
			request.getSession().removeAttribute(Constants.USER_INFO);
			request.getSession().removeAttribute(Constants.AUTH_SET);
			request.getSession().removeAttribute(Constants.MENU_SET);
			this.setUserInfo(request);
			this.addLogOpt(MenuDefine.LOGIN, 2, sysUser != null && sysUser.getUserId() != null ? sysUser.getUserId() : "",
					"用户退出", request);
		}
		return "/login";
	}

	@RequestMapping("/jump_login_page.shtml")
	public String go_login_page(HttpServletRequest request) {
		return "/login";
	}

}
