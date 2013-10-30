package com.gdit.framework.manager.common.web.request.service;

import java.util.List;
import java.util.Map;

import com.gdit.framework.common.exception.ServiceException;

public interface BasicService {

	public Object insert( String sqlName , Map parameterMap ) throws ServiceException;
	
	public Object insertObj( String sqlName , Object obj ) throws ServiceException;
	
	public int update( String sqlName , Map parameterMap ) throws ServiceException;

	public Object updateObj( String sqlName , Object obj ) throws ServiceException;

	public Object delete( String sqlName , Map parameterMap ) throws ServiceException;

	public int queryIntBySqlName( String sqlName , Map parameterMap ) throws ServiceException;

	public List queryList( String sqlName , Map parameterMap ) throws ServiceException;

	public Object queryByPkNo( String sqlName , Map parameterMap ) throws ServiceException;


}
