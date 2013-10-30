package com.gdit.framework.manager.common.web.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.gdit.framework.common.annotation.AuthCode;
import com.gdit.framework.common.annotation.MenuCode;
import com.gdit.framework.common.exception.ControllerException;
import com.gdit.framework.common.util.AuthConstants;
import com.gdit.framework.common.util.AuthUtil;
import com.gdit.framework.common.util.Constants;
import com.gdit.framework.common.util.ConvertUtil;
import com.gdit.framework.common.util.StringUtil;
import com.gdit.framework.manager.common.utils.CommonPageDefine;

public class LoginInterceptor implements MethodInterceptor {

	public Object invoke( MethodInvocation invoke) throws Throwable {
		Method method = invoke.getMethod();
		AuthCode authValue = method.getAnnotation(AuthCode.class);
		HttpServletRequest request = null;
		Object currentUser = null;
		Object obj = invoke.getThis();
		MenuCode menuCode = obj.getClass().getAnnotation(MenuCode.class);
		
		if (menuCode == null) {
			throw new ControllerException("controller未设置菜单编码");
		}
		//如果菜单标注为COMMON时则可以直接访问
		if(StringUtil.isEqualIgnoreCase(Constants.COMMON_MENU, menuCode.value())){
			return invoke.proceed();
		}
		Object[] params = invoke.getArguments();
		request = (HttpServletRequest) params[0];
		currentUser = request.getSession().getAttribute(Constants.USER_INFO);
		if (currentUser == null) {
			/** 未登录跳转到登录页面，并记录本次请求地址 */
			request.setAttribute(Constants.NEXT_PAGE, request.getRequestURI());
			request.setAttribute(Constants.TIP_MSG, "对不起，你还未登录系统");
			return CommonPageDefine.LOGIN;
		}
		request.setAttribute("menuCode", menuCode.value());
		if (menuCode == null) {
			throw new ControllerException("controller未设置菜单编码");
		}
		
		Map<String, String> authSets = (Map<String, String>) request.getSession().getAttribute(Constants.AUTH_SET);
		if(authSets==null){
			request.setAttribute(Constants.TIP_MSG, "你无任何功能操作权限");
			return CommonPageDefine.AUTH_ERROR;
		}
		
		/**
		 * 判断权限码，方法级优先，如果方法上设置了权限码，则根据方法上的权限码去判断。否则则根据类级上的权限码判断
		 */
		if (authValue != null) {
			if (!AuthUtil.hasOperationAuth(Integer.parseInt(authSets.get(menuCode.value())), authValue.value())) {
				/** 跳转到登录页面 */
				return CommonPageDefine.AUTH_ERROR;
			}
		}
		else {
			authValue = obj.getClass().getAnnotation(AuthCode.class);
			if (authValue == null) {
				throw new ControllerException("controller未设置权限值");
			}
			else {
				if (!AuthUtil.hasOperationAuth(ConvertUtil.convertToInteger(authSets.get(menuCode.value())), authValue.value())) {
					/** 跳转到没权限页面 */
					return CommonPageDefine.AUTH_ERROR;
				}
			}
		}
		if(authValue.value()==AuthConstants.LIST){
			if(AuthUtil.hasOperationAuth(ConvertUtil.convertToInteger(authSets.get(menuCode.value())), AuthConstants.EDIT)){
				request.setAttribute("AUTH_EDIT", 1);
			}
			if(AuthUtil.hasOperationAuth(ConvertUtil.convertToInteger(authSets.get(menuCode.value())), AuthConstants.DELETE)){
				request.setAttribute("AUTH_DEL", 1);
			}
		}
		return invoke.proceed();
	}
}
