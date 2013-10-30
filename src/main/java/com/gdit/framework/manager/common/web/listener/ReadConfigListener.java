package com.gdit.framework.manager.common.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gdit.framework.common.util.Constants;
import com.gdit.framework.manager.common.utils.Memory;

/**
 * 服务启动加载配置项
 * 
 * @description 读取一些系统配置
 * @author EX-HUANGBIN001
 * @2012-2-22
 */
public class ReadConfigListener implements ServletContextListener {

	private final static Log LOG = LogFactory.getLog(ReadConfigListener.class);

	public void contextDestroyed(ServletContextEvent context) {
		LOG.info("容器关闭");
	}

	/***************************************************************************
	 * 窗口启动时读取配置信息
	 */
	public void contextInitialized(ServletContextEvent context) {
		/***********************************************************************
		 * 读取属性文件
		 */
		ServletContext application = context.getServletContext();

		try {

			/*******************************************************************
			 * 读取常量类型及值
			 */

			// 加载状态
			application.setAttribute(Constants.STATE_MAP_KEY, Memory.getStateMap());

			// 加载数据字典
			application.setAttribute(Constants.DICT_VALUE_MAP_KEY, Memory.getDictValueMap());


		} catch (Exception e) {
			LOG.error("系统启动时读取配置文件异常>>", e);
			System.exit(0);
		}
	}
}
