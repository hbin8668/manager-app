package com.gdit.framework.manager.sysmanage.dev.service;

import java.util.List;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.dev.vo.DictValueListVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;

public interface DictService {

	/**
	 * 添加数据字典
	 * @param dict 数据字典Bean
	 * @return
	 */
	public ResultVO addDict(Dict dict) throws ServiceException ;
	
	/**
	 * 添加数据字典
	 * @param dict 数据字典Bean
	 * @return
	 */
	public ResultVO editDict(Dict dict) throws ServiceException ;
	
	/**
	 * 根据主键删除数据字典
	 * @param dictId 数据字典主键
	 * @return
	 * @throws ServiceException
	 */
	public ResultVO deleteDictById(String dictId) throws ServiceException;
	
	/**
	 * 查询数据字典
	 * @param dictId 数据字典主键
	 * @return
	 * @throws ServiceException
	 */
	public List<Dict> queryDictAndDictValue() throws ServiceException;
	
	/**
	 * 添加数据字典值
	 * @param dictValueList 数据字典的值信息
	 * @param dictCode 数据字典
	 * @param sysUser 操作用户
	 * @return
	 */
	public ResultVO addDictValue(DictValueListVO dictValueList, String dictCode, SysUser sysUser);
	
}
