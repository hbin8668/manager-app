package com.gdit.framework.manager.sysmanage.dev.vo ;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-22 07:42:42
 */

public class State extends CommonVO{

	private String stateId ;// 状态编号
	private String stateCode ;// 状态类型码
	private String stateValue ;// 状态编码
	private String stateName ;// 状态值
	private String dataState ;// 状态
	private Integer taxis ;// 
	private String description ;// 
	
	public String getStateId(){
			return this.stateId ;
	}

	public void setStateId(String stateId){
			this.stateId=stateId ;
	}
	
	public String getStateCode(){
			return this.stateCode ;
	}

	public void setStateCode(String stateCode){
			this.stateCode=stateCode ;
	}
	
	public String getStateValue(){
			return this.stateValue ;
	}

	public void setStateValue(String stateValue){
			this.stateValue=stateValue ;
	}
	
	public String getStateName(){
			return this.stateName ;
	}

	public void setStateName(String stateName){
			this.stateName=stateName ;
	}
	
	public String getDataState(){
			return this.dataState ;
	}

	public void setDataState(String dataState){
			this.dataState=dataState ;
	}
	
	public Integer getTaxis(){
			return this.taxis ;
	}

	public void setTaxis(Integer taxis){
			this.taxis=taxis ;
	}
	
	public String getDescription(){
			return this.description ;
	}

	public void setDescription(String description){
			this.description=description ;
	}
	
}