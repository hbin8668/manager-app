package com.gdit.framework.manager.common.web.request.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.manager.common.web.request.dao.BasicDAO;

/**
 * @author EX-HUANGBIN001
 * @2011-12-7
 * @param <T>
 */
public class BasicDAOImpl<T> extends SqlSessionDaoSupport implements BasicDAO<T> {
	
	
	public int queryIntBySqlName(String sqlName, Map parameterMap) throws DAOException {
		int cnt = Integer.parseInt(this.getSqlSession().selectOne(sqlName, parameterMap).toString());
		return cnt;

	}

	public Object insert(String sqlName, Map parameterMap) throws DAOException {
		return this.getSqlSession().insert(sqlName, parameterMap);
	}

	public int update(String sqlName, Map parameterMap) throws DAOException {
		return this.getSqlSession().update(sqlName, parameterMap);
	}

	public List<T> queryList(String sqlName, Map parameterMap) throws DAOException {
		return this.getSqlSession().selectList(sqlName, parameterMap);
	}

	public Object insertObj(String sqlName, Object obj) throws DAOException {
		return this.getSqlSession().insert(sqlName, obj);
	}

	public Object delete(String sqlName, Map parameterMap) throws DAOException {
		return this.getSqlSession().delete(sqlName, parameterMap);
	}

	public Object delete(String sqlName, String obj) throws DAOException {
		return this.getSqlSession().delete(sqlName, obj);
	}

	public Object queryByPkNo(String sqlName, Map parameterMap) throws DAOException {
		return this.getSqlSession().selectOne(sqlName, parameterMap);
	}

	public Object updateObj(String sqlName, Object obj) throws DAOException {
		return this.getSqlSession().update(sqlName, obj);
	}

	@Override
	public List<T> queryList(String sqlName) throws DAOException {
		return this.getSqlSession().selectList(sqlName);
	}

}
