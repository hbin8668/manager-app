package com.gdit.framework.manager.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gdit.framework.common.util.CollectionUtil;
import com.gdit.framework.manager.sysmanage.dev.service.DictService;
import com.gdit.framework.manager.sysmanage.dev.service.StateService;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.dev.vo.DictValue;
import com.gdit.framework.manager.sysmanage.dev.vo.State;

/**
 * 加载相关数据到内存
 * 
 * @author EX-HUANGBIN001
 * 
 */
public final class Memory {

	private static final Log LOG = LogFactory.getLog(Memory.class);

	/**
	 * 状态值Map
	 */
	private static Map<String, Map<String, String>> stateMap = null;

	/**
	 * 数据字典Map
	 */
	private static Map<String, Map<String, String>> dictValueMap = null;

	/**
	 * 返回stateMap
	 * 
	 * @return
	 */
	public static Map<String, Map<String, String>> getStateMap() {
		if (stateMap != null) {
			return stateMap;
		}
		return refreshMemoryState();
	}

	/**
	 * 刷新内存中的状态信息
	 */
	public static Map<String, Map<String, String>> refreshMemoryState() {
		try {
			StateService ss = Context.getBean("stateService", StateService.class);
			// 先查询有哪几种状态
			List<String> parentList = ss.queryParentStateList();
			if (CollectionUtil.isNotEmpty(parentList)) {
				Map<String, Map<String, String>> stateMapTemp = new HashMap<String, Map<String, String>>();
				Map<String, String> param = new HashMap();
				// 遍历查询各种状态的状态值列表
				for (String stateCode : parentList) {
					param.put("stateCode", stateCode);
					List<State> stateValueList = ss.queryStateList(param);
					if (CollectionUtil.isNotEmpty(stateValueList)) {
						Map<String, String> stateValueMap = new HashMap<String, String>();
						for (State state : stateValueList) {
							stateValueMap.put(state.getStateValue(), state.getStateName());
						}
						stateMapTemp.put(stateCode, stateValueMap);
					}
				}
			} else {
				stateMap = null;
			}
		} catch (Exception e) {
			LOG.error("刷新内存中的状态值异常", e);
		}
		return stateMap;
	}

	/**
	 * 返回stateMap
	 * 
	 * @return
	 */
	public static Map<String, Map<String, String>> getDictValueMap() {
		if (dictValueMap != null) {
			return dictValueMap;
		}
		return refreshMemoryDictValue();
	}

	/**
	 * 刷新内存中的状态信息
	 */
	public static Map<String, Map<String, String>> refreshMemoryDictValue() {
		try {
			DictService dictService = Context.getBean("dictService", DictService.class);
			// 先查询出所有的数据字典
			List<Dict> dictList = dictService.queryDictAndDictValue();
			if (CollectionUtil.isNotEmpty(dictList)) {
				Map<String, Map<String, String>> dictMapTemp = new HashMap<String, Map<String, String>>();
				// 遍历查询各种状态的数据字典值列表
				for (Dict dict : dictList) {
					List<DictValue> dictValueList = dict.getDictValueList();
					if (CollectionUtil.isNotEmpty(dictValueList)) {
						Map<String, String> dictValueMap = new HashMap<String, String>();
						for (DictValue dictValue : dictValueList) {
							dictValueMap.put(dictValue.getValueCode(), dictValue.getValueName());
						}
						dictMapTemp.put(dict.getDictCode(), dictValueMap);
					}
				}
				dictValueMap = dictMapTemp;
			} else {
				dictValueMap = null;
			}
		} catch (Exception e) {
			LOG.error("刷新内存中的数据字典异常", e);
		}
		return dictValueMap;
	}

}
