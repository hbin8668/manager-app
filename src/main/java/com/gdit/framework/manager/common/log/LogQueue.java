package com.gdit.framework.manager.common.log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.gdit.framework.manager.sysmanage.vo.LogOpt;

/***
 * @功能 日志队列
 * @作者 HuangBin
 * @创建日期 2011-6-24
 * @版本 V1.0
 */
public class LogQueue {

	public static Queue qlog = new LinkedList();

	public static void addLog( Object object ) {
		qlog.add(object);
	}

	public static Object outLog() {
		if (qlog.size() > 0) {
			return qlog.poll();
		}
		else {
			return null;
		}
	}

	public static List outLog50() {
		if (qlog.size() > 0) {
			List list = new ArrayList();
			for (int i = 0; i < 50; i++) {
				LogOpt log = (LogOpt) LogQueue.outLog();
				if (log == null) {
					break;
				}
				list.add(log);
			}
			return list;
		}
		else {
			return null;
		}
	}
}
