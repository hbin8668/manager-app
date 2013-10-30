package com.gdit.framework.manager.sysmanage.dev.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.vo.State;

/**
 * @功能	：查看状态列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-22 17:00:51
 */

public interface StateService{
	
	/**
	 * 新增状态
	 * @param state 状态对象
	 * @throws ServiceException
	 */
	public ResultVO addState(State state) ;
	
	
	/**
	 * 根据主键删除状态
	 * @param stateId State主键
	 * @throws ServiceException
	 */
	public ResultVO deleteStateByStateId(String stateId) ;
	
	/**
	 * 根据主键列表批量删除状态
	 * @param stateId State主键数组
	 * @throws ServiceException
	 */
	public ResultVO deleteStateByStateIds(String[] stateIds) ;
	
	/**
	 * 编辑状态
	 * @param state 状态对象
	 * @throws ServiceException
	 */
	public ResultVO editState(State state) ;
	
	/**
	 * 查询状态总数
	 * @param stateId State主键
	 * @throws ServiceException
	 */
	public int queryStateCount(Map paramMap) ;
	/**
	 * 查询状态列表
	 * @param stateId State主键
	 * @throws ServiceException
	 */
	public List<State> queryStateList(Map paramMap) ;
	
	/**
	 * 查询状态详情
	 * @param stateId State主键
	 * @throws ServiceException
	 */
	public State queryStateByStateId(String stateId) ;
	
	/**
	 * 查询父级状态列表
	 * @throws ServiceException
	 */
	public List<String> queryParentStateList() ;
	
}
