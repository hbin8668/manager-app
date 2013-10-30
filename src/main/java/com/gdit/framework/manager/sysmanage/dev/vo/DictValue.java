package com.gdit.framework.manager.sysmanage.dev.vo;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-22 07:25:29
 */

public class DictValue extends CommonVO {

	private String dictValueId;// 常量值编号
	private String dictId;// 主键编码
	private String valueCode;// 常量值编码
	private String valueName;// 常量值编码名称
	private String dataState;// 常量值的状态
	private Integer taxis;// 

	private String optFlag;

	public String getDictValueId() {
		return this.dictValueId;
	}

	public void setDictValueId(String dictValueId) {
		this.dictValueId = dictValueId;
	}

	public String getDictId() {
		return this.dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getValueCode() {
		return this.valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public String getValueName() {
		return this.valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getDataState() {
		return this.dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public Integer getTaxis() {
		return this.taxis;
	}

	public void setTaxis(Integer taxis) {
		this.taxis = taxis;
	}

	public String getOptFlag() {
		return optFlag;
	}

	public void setOptFlag(String optFlag) {
		this.optFlag = optFlag;
	}
	
	

}