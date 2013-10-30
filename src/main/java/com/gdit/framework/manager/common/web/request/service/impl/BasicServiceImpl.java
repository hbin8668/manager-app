package com.gdit.framework.manager.common.web.request.service.impl;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.DAOException;
import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.manager.common.web.request.dao.BasicDAO;
import com.gdit.framework.manager.common.web.request.service.BasicService;

public class BasicServiceImpl<T> implements BasicService {

	private BasicDAO<T> basicDAO;

	public void setBasicDAO(BasicDAO basicDAO) {
		this.basicDAO = basicDAO;
	}

	public int queryIntBySqlName(String sqlName, Map parameterMap) throws ServiceException {
		try {
			return basicDAO.queryIntBySqlName(sqlName, parameterMap);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public Object queryByPkNo(String sqlName, Map parameterMap) throws ServiceException {
		try {
			return basicDAO.queryByPkNo(sqlName, parameterMap);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public List<T> queryList(String sqlName, Map parameterMap) throws ServiceException {
		try {
			return basicDAO.queryList(sqlName, parameterMap);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public Object insert(String sqlName, Map parameterMap) throws ServiceException {
		try {
			Object obj = basicDAO.insert(sqlName, parameterMap);
			return obj;
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public Object insertObj(String sqlName, Object obj) throws ServiceException {
		try {
			return basicDAO.insertObj(sqlName, obj);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public Object delete(String sqlName, Map parameterMap) throws ServiceException {
		try {
			return basicDAO.delete(sqlName, parameterMap);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public int update(String sqlName, Map parameterMap) throws ServiceException {
		try {
			return basicDAO.update(sqlName, parameterMap);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	public Object updateObj(String sqlName, Object obj) throws ServiceException {
		try {
			return basicDAO.updateObj(sqlName, obj);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

}
