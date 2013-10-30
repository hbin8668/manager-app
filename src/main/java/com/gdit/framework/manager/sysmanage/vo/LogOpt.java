package com.gdit.framework.manager.sysmanage.vo ;

import java.util.Date;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-22 08:31:02
 */

public class LogOpt extends CommonVO{

	private String logId ;// 日志编号
	private String menuCode ;// 菜单编码
	private Integer optType ;// 操作类型(1查看2添加3修改4删除)
	private String optObj ;// 操作类型
	private Date optTime ;// 操作时间
	private String description ;// 操作描述
	private String userId ;// 操作人
	private String optIp ;// 操作所在电脑IP地址
	private Integer logResult ;// 操作结果(0 失败　1成功)
	private String actionName ;// 调用的类
	
	public String getLogId(){
			return this.logId ;
	}

	public void setLogId(String logId){
			this.logId=logId ;
	}
	
	public String getMenuCode(){
			return this.menuCode ;
	}

	public void setMenuCode(String menuCode){
			this.menuCode=menuCode ;
	}
	
	public Integer getOptType(){
			return this.optType ;
	}

	public void setOptType(Integer optType){
			this.optType=optType ;
	}
	
	public String getOptObj(){
			return this.optObj ;
	}

	public void setOptObj(String optObj){
			this.optObj=optObj ;
	}
	
	public Date getOptTime(){
			return this.optTime ;
	}

	public void setOptTime(Date optTime){
			this.optTime=optTime ;
	}
	
	public String getDescription(){
			return this.description ;
	}

	public void setDescription(String description){
			this.description=description ;
	}
	
	public String getUserId(){
			return this.userId ;
	}

	public void setUserId(String userId){
			this.userId=userId ;
	}
	
	public String getOptIp(){
			return this.optIp ;
	}

	public void setOptIp(String optIp){
			this.optIp=optIp ;
	}
	
	public Integer getLogResult(){
			return this.logResult ;
	}

	public void setLogResult(Integer logResult){
			this.logResult=logResult ;
	}
	
	public String getActionName(){
			return this.actionName ;
	}

	public void setActionName(String actionName){
			this.actionName=actionName ;
	}
	
}