package com.gdit.framework.manager.sysmanage.dev.vo;

import java.util.List;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-22 07:25:29
 */

public class Dict extends CommonVO {

	private String dictId;// 主键编码
	private String dictCode;// 常量码
	private String dictName;// 常量名
	private String description;// 描述
	private String dataState;// 数据状态
	private String delState;// 删除状态
	
	private List<DictValue> dictValueList;
	
	

	public List<DictValue> getDictValueList() {
		return dictValueList;
	}

	public void setDictValueList(List<DictValue> dictValueList) {
		this.dictValueList = dictValueList;
	}

	public String getDictId() {
		return this.dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataState() {
		return this.dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public String getDelState() {
		return this.delState;
	}

	public void setDelState(String delState) {
		this.delState = delState;
	}

}