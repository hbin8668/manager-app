package com.gdit.framework.manager.common.web.request.dao;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;

public interface BasicDAO<T> {

	/**
	 * 插入
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public Object insert(String sqlName, Map parameterMap) throws DAOException;
	
	/**
	 * 插入对象
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public Object insertObj(String sqlName, Object obj) throws DAOException;

	/**
	 * 删除记录
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public Object delete(String sqlName, Map parameterMap) throws DAOException;

	/**
	 * 根据主键删除记录
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public Object delete(String sqlName, String obj) throws DAOException;

	
	/**
	 * 更新记录
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public int update(String sqlName, Map parameterMap) throws DAOException;
	
	/**
	 * 根据对象更新该记录
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public Object updateObj(String sqlName,Object obj) throws DAOException;

	/***
	 * 获取一个整型值，比如获取数据记录总数
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public int queryIntBySqlName(String sqlName, Map parameterMap) throws DAOException;

	/***
	 * 查询记录集
	 * @param sqlName
	 * @param parameterMap
	 * @return
	 * @throws DAOException
	 */
	public List<T> queryList(String sqlName, Map parameterMap) throws DAOException;

	/***
	 * 查询记录集
	 * @param sqlName
	 * @return
	 * @throws DAOException
	 */
	public List<T> queryList(String sqlName) throws DAOException;

	/***
	 * 根据主键查询记录详情
	 * @param sqlName
	 * @return
	 * @throws DAOException
	 */
	public Object queryByPkNo(String sqlName, Map parameterMap) throws DAOException;

	
}
