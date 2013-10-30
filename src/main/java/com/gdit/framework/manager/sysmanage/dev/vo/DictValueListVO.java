package com.gdit.framework.manager.sysmanage.dev.vo;

import java.util.List;

import com.gdit.framework.common.vo.CommonVO;

public class DictValueListVO extends CommonVO {
	private List<DictValue> dictValueList;

	public List<DictValue> getDictValueList() {
		return dictValueList;
	}

	public void setDictValueList(List<DictValue> dictValueList) {
		this.dictValueList = dictValueList;
	}

}
