package com.gdit.framework.manager.sysmanage.dev.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.mapper.StateMapper;
import com.gdit.framework.manager.sysmanage.dev.service.StateService;
import com.gdit.framework.manager.sysmanage.dev.vo.State;
/**
 * @功能	：查看状态列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-22 17:25:28
 */

@Service("stateService")
public class StateServiceImpl implements StateService {
	
	private static final Log log = LogFactory.getLog(StateServiceImpl.class);
	
	@Autowired
	private StateMapper stateMapper;
	
	public ResultVO addState(State state){
		try {
			stateMapper.addState(state);
			return ResultVO.success("状态添加成功");
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return ResultVO.failure("状态添加失败");
		}
	}
	
	public ResultVO deleteStateByStateId(String stateId){
		try {
			stateMapper.deleteStateByStateId(stateId);
			return ResultVO.success("状态添加成功");
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return ResultVO.failure("状态添加失败");
		}
	}
	
	
	public ResultVO deleteStateByStateIds(String[] stateIds) {
		try {
			stateMapper.deleteStateByStateIds(stateIds);
			return ResultVO.success("状态添加成功");
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return ResultVO.failure("状态添加失败");
		}
	}
	
	
	public ResultVO editState(State state){
		try {
			stateMapper.editState(state);
			return ResultVO.success("状态添加成功");
		} catch (Exception e) {
			log.error("编辑状态信息异常：", e);
			return ResultVO.failure("状态添加失败");
		}
	}
	
	
	public List<State> queryStateList(Map paramMap){
		try {
			return stateMapper.queryStateList(paramMap);
		} catch (Exception e) {
			log.error("查询状态列表异常：", e);
			return null;
		}
	}
	
	
	public State queryStateByStateId(String stateId) {
		try {
			return stateMapper.queryStateByStateId(stateId);
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return null;
		}
	}

	@Override
	public int queryStateCount(Map paramMap) {
		try {
			return stateMapper.queryStateCount(paramMap);
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return 0;
		}
	}

	@Override
	public List<String> queryParentStateList() {
		try {
			return stateMapper.queryParentStateList();
		} catch (Exception e) {
			log.error("添加状态异常：", e);
			return null;
		}
	}
	
}
