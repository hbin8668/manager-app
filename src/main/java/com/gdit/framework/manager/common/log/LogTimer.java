package com.gdit.framework.manager.common.log;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.manager.common.utils.Context;
import com.gdit.framework.manager.common.web.request.service.BasicService;
import com.gdit.framework.manager.sysmanage.vo.LogOpt;

public class LogTimer extends TimerTask {
	
	private static final Log log = LogFactory.getLog(LogTimer.class);
	
//	@Autowired

	public LogTimer(){		
	}	
    @Override 
    public void run() { 
    	
    	int size=0;
    	for(int i=0;i<50;i++)
    	{
    	   List<LogOpt>  logList = LogQueue.outLog50();    	   
    	   if(logList!=null)
    	   {
    		   try {
    			   for(LogOpt sysLog : logList)
    			   {
//    				   basicService.insertObj("addLotOpt",sysLog);
    			   }
				}
				catch (Exception e) {
					e.printStackTrace();
					log.error("日志记录异常："+e);
				}
    		   size+=logList.size();
    	   }    	   
    	}
    	if(size>0)
    	{
    		System.out.println("现在时间: " + new Date()+" 添加日志数:"+size); 
    	}    	
    }
}
