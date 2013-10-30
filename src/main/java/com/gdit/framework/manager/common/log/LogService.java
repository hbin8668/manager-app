package com.gdit.framework.manager.common.log;

import java.util.List;

import com.gdit.framework.manager.sysmanage.vo.LogOpt;


public interface LogService {

	
	/**
	 * 添加操作日志
	 * @param logOpt
	 * void
	 * Jun 17, 2012 3:06:11 AM
	 */
	public void addLogOpt(List<LogOpt> logOptList);
	
}
