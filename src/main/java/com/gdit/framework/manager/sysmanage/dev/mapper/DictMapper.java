package com.gdit.framework.manager.sysmanage.dev.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.dev.vo.DictValue;

public interface DictMapper extends SupperMapper {

	public int addDict(Dict dict);

	public int editDict(Dict dict);

	public int deleteDictByDictId(String dictId);

	
	/***=================	sys_dict_value	=================**/
	
	public int editDictValue(DictValue dictValue);
	
	public int addDictValue(DictValue dictValue);
	
	public int queryDictValueCountByDictId(Map<String, String> paramMap);
	
	
	public List<Dict> queryDictAndDictValue() ;

}
