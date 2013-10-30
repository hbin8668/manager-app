package com.gdit.framework.manager.common.web.request.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gdit.framework.manager.common.log.LogQueue;
import com.gdit.framework.common.util.Constants;
import com.gdit.framework.common.util.IpTools;
import com.gdit.framework.common.util.StringUtil;
import com.gdit.framework.common.vo.PaginationVO;
import com.gdit.framework.common.vo.ResultCode;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;
import com.gdit.framework.manager.sysmanage.vo.LogOpt;

/*******************************************************************************
 * 所有controller的父类
 * 
 * @功能
 * @作者 HuangBin
 * @创建日期 2011-12-20
 * @版本 V1.0
 */
public class BasicController {

	protected static Log log = null;

	protected String nextPage;// 上一页地址

	protected SysUser sysUser;// 登录用户信息

	protected String message;

	protected PaginationVO pagination;

	public BasicController() {
		log = LogFactory.getLog(this.getClass());
	}

	protected Object getBean(String beanId) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		return wac.getBean(beanId);
	}

	// 存入session
	protected void set(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

	// 获取session中的值
	protected Object get(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}

	// 获取session中的用户 因为使用太多。所以直接在该父类中写好
	protected void setUserInfo(HttpServletRequest request) {
		sysUser = (SysUser) request.getSession().getAttribute(Constants.USER_INFO);
	}

	/**
	 * 将请求参数转换为attribute
	 * 
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	protected Map parameterToMap(HttpServletRequest request) {
		Map parameterMap = null;
		Enumeration parameterNames = request.getParameterNames();
		if (parameterNames != null) {
			parameterMap = new HashMap();
			while (parameterNames.hasMoreElements()) {
				String name = StringUtil.trim(((String) parameterNames.nextElement()));
				String value = StringUtil.trim(request.getParameter(name));
				parameterMap.put(name, value);
			}
		}
		return parameterMap;
	}

	/**
	 * 设置需要查询的分页数据
	 * 
	 * @param parameterMap
	 * @param cnt
	 */
	protected void setPageInfo(Map parameterMap, int cnt) {
		// if (pageVO == null) {
		// pageVO = new PageVO(cnt);
		// pageVO.setPageSize(SysConstants.PAGE_SIZE);
		// }
		// else {
		// pageVO.setRowCount(cnt);
		// pageVO.setPageSize(SysConstants.PAGE_SIZE);
		// }
		// parameterMap.put("startIndex", pageVO.getStartIndex());
		// parameterMap.put("endIndex", pageVO.getEndIndex());
	}

	/***************************************************************************
	 * 组装操作日志记录，将日志记录到数据库.重要日志.如要计算积分,异常等日志 functionId 功能编号 optType 操作类类型(0操作异常
	 * 1查看 2新增4修改8删除) desc 操作描述 args 如果args不为空。则第一个参数必须是request
	 */
	public void addLogOpt(String functionId, int optType, Object dest, String desc, HttpServletRequest requet) {
		LogOpt sysLog = new LogOpt();
		if (sysUser == null) {
			sysLog.setOptIp(IpTools.getIpAddr(requet));
			sysLog.setUserId("未登录用户");
		} else {
			sysLog.setOptIp(sysUser.getLoginIP());
			sysLog.setUserId(sysUser.getUserId());
		}
		sysLog.setActionName(this.getClass().getName());
		sysLog.setDescription(desc);
		sysLog.setOptObj(StringUtil.trim(dest));
		sysLog.setOptType(optType);
		sysLog.setActionName(functionId);
		sysLog.setMenuCode(functionId);
		sysLog.setLogResult( 1);
		sysLog.setOptTime(new Date());
		LogQueue.addLog(sysLog);
	}
	
	/***************************************************************************
	 * 组装操作日志记录，将日志记录到数据库.重要日志.如要计算积分,异常等日志 functionId 功能编号 optType 操作类类型(0操作异常
	 * 1查看 2新增4修改8删除) desc 操作描述 args 如果args不为空。则第一个参数必须是request
	 */
	public void addLogOpt(String functionId, int optType, String dest,ResultVO result) {
		/**
		 * 如果处理失败，则不需要入日志表
		 */
		if(result==null || !ResultCode.SUCCESS.equals(result.getCode())){
			return;
		}
		LogOpt sysLog = new LogOpt();
		if (sysUser != null) {
			sysLog.setOptIp(sysUser.getLoginIP());
			sysLog.setUserId(sysUser.getUserId());
		} else {
			sysLog.setUserId("未登录用户");
		}
		sysLog.setActionName(this.getClass().getName());
		sysLog.setDescription(result.getMsg());
		sysLog.setOptObj(StringUtil.trim(dest));
		sysLog.setOptType(optType);
		sysLog.setActionName(functionId);
		sysLog.setMenuCode(functionId);
		sysLog.setLogResult( 1);
		sysLog.setOptTime(new Timestamp(System.currentTimeMillis()));
		LogQueue.addLog(sysLog);
	}


	// 直接输出日志到日志文件 主要是输出一些不是很重要的信息
	/**
	 * args 如果args不为空。则第一个参数必须是request
	 */
	public void outLog(String desc, HttpServletRequest request) {
		if (sysUser == null) {
			if (request != null) {
				log.info("未登录用户访问了" + this.getClass().getName() + ";IP:" + IpTools.getIpAddr((HttpServletRequest) request) + "=="
						+ desc);
			} else {
				log.info("未登录用户访问了" + this.getClass().getName() + "==" + desc);
			}
		} else {
			log.info("用户编号：" + sysUser.getUserId() + ";用户名：" + sysUser.getUserName() + "访问了" + this.getClass().getName() + "=="
					+ desc);
		}
	}

	/**
	 * args 如果args不为空。则第一个参数必须是request
	 */
	public void errorLog(String desc, Exception e, HttpServletRequest request) {
		if (sysUser == null) {
			if (request != null) {
				log.info("未登录用户访问了" + this.getClass().getName() + ";IP:" + IpTools.getIpAddr((HttpServletRequest) request) + "=="
						+ desc);
			} else {
				log.info("未登录用户访问了" + this.getClass().getName() + "==" + desc);
			}
		} else {
			log.info("用户：" + sysUser.getUserId() + ";用户名：" + sysUser.getUserName() + "访问了" + this.getClass().getName() + "=="
					+ desc);
		}
		log.error(desc, e);
	}
	
	/**
	 * args 如果args不为空。则第一个参数必须是request
	 */
	public void errorLog(String desc, Exception e) {
		if (sysUser == null) {
				log.info("未登录用户访问了" + this.getClass().getName() + "==" + desc);
		} else {
			log.info("用户：" + sysUser.getUserId() + ";用户名：" + sysUser.getUserName() + "访问了" + this.getClass().getName() + "=="
					+ desc);
		}
		log.error(desc, e);
	}
}
