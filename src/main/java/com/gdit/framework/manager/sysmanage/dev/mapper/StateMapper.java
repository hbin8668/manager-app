package com.gdit.framework.manager.sysmanage.dev.mapper;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.mapper.SupperMapper;
import com.gdit.framework.manager.sysmanage.dev.vo.State;

/**
 * @功能	：查看状态列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-22 17:00:51
 */

public interface StateMapper extends SupperMapper{
	
	/**
	 * 新增状态
	 * @param state 状态对象
	 * @throws DAOException
	 */
	public int addState(State state) ;
	
	
	/**
	 * 根据主键删除状态
	 * @param stateId State主键
	 * @throws DAOException
	 */
	public int deleteStateByStateId(String stateId) ;
	
	/**
	 * 根据主键列表批量删除状态
	 * @param stateId State主键数组
	 * @throws DAOException
	 */
	public int deleteStateByStateIds(String[] stateIds) ;
	
	/**
	 * 编辑状态
	 * @param state 状态对象
	 * @throws DAOException
	 */
	public int editState(State state) ;
	/**
	 * 编辑总数
	 * @param state 状态对象
	 * @throws DAOException
	 */
	public int queryStateCount(Map paramMap) ;
	
	/**
	 * 查询状态列表
	 * @param stateId State主键
	 * @throws DAOException
	 */
	public List<State> queryStateList(Map paramMap) ;
	
	/**
	 * 查询状态详情
	 * @param stateId State主键
	 * @throws DAOException
	 */
	public State queryStateByStateId(String stateId) ;
	
	/**
	 * 查询父级状态列表
	 * @param stateId State主键
	 * @throws DAOException
	 */
	public List<String> queryParentStateList() ;
	
}
