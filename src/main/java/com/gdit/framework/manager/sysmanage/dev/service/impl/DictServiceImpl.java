package com.gdit.framework.manager.sysmanage.dev.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdit.framework.common.exception.ServiceException;
import com.gdit.framework.common.util.StringUtil;
import com.gdit.framework.common.vo.ResultCode;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.sysmanage.dev.mapper.DictMapper;
import com.gdit.framework.manager.sysmanage.dev.service.DictService;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.dev.vo.DictValue;
import com.gdit.framework.manager.sysmanage.dev.vo.DictValueListVO;
import com.gdit.framework.manager.sysmanage.roleauth.vo.SysUser;

@Service("dictService")
public class DictServiceImpl implements DictService {

	private static final Log log = LogFactory.getLog(DictServiceImpl.class);

	@Autowired
	private DictMapper dictMapper;

	@Override
	public ResultVO addDict(Dict dict) throws ServiceException {
		try {
			System.out.println(dictMapper.addDict(dict));
			return ResultVO.success("数据字典添加成功");
		} catch (Exception e) {
			log.error("添加数据字典异常：", e);
			throw new ServiceException(e);
		}
	}

	@Override
	public ResultVO editDict(Dict dict) throws ServiceException {
		try {
			System.out.println(dictMapper.editDict(dict));
			return ResultVO.success("数据字典添加成功");
		} catch (Exception e) {
			log.error("添加数据字典异常：", e);
			throw new ServiceException(e);
		}
	}

	@Override
	public ResultVO deleteDictById(String dictId) throws ServiceException {
		try {
			// dictMapper.delete("sm.dev.addDict", dictId);
			return ResultVO.success("数据字典删除成功");
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/***
	 * 添加字典值
	 */
	@Transactional
	public ResultVO addDictValue(DictValueListVO dictValueList, String dictCode, SysUser sysUser) {
		ResultVO result = new ResultVO();
		result.setCode(ResultCode.FAILURE);
		try {
			if (dictValueList != null && dictValueList.getDictValueList() != null) {
				List<DictValue> list = dictValueList.getDictValueList();
				DictValue dictValue = null;
				for (int index = 0; index < list.size(); index++) {
					dictValue = list.get(index);
					int cnt = 0;
					dictValue.setLcd(new Timestamp(System.currentTimeMillis()));
					dictValue.setDictId(dictCode);
					dictValue.setLcu(sysUser.getUserName());
					/***
					 * update
					 */
					if (StringUtil.isEqualIgnoreCase(dictValue.getOptFlag(), "update")) {
						/***
						 * 表示这条记录已存在，如果dictValue.getDictValueId()不存在值则需要更新否则不处理
						 */
						if (dictValue.getDictValueId() != null && !"0".equals(dictValue.getDictValueId())) {
							Map<String,String> paramMap = new HashMap<String,String>();
							paramMap.put("dictCode", dictCode);
							paramMap.put("valueCode", dictValue.getValueCode());
							paramMap.put("dictValueId", dictValue.getDictValueId());
							cnt = dictMapper.queryDictValueCountByDictId(paramMap);
							if (cnt > 0) {
								result.setMsg("字典码为【" + dictValue.getValueCode() + "】的数据已存在");
								return result;
							}
							paramMap.put("valueCode", null);
							paramMap.put("valueName", dictValue.getValueName());
							cnt = dictMapper.queryDictValueCountByDictId(paramMap);
							if (cnt > 0) {
								result.setMsg("字典值为【" + dictValue.getValueName() + "】的数据已存在");
								return result;
							}
							dictMapper.editDictValue(dictValue);
							result.setCode(ResultCode.SUCCESS);
						}
					} else {
						cnt = 0;
						Map<String,String> paramMap = new HashMap<String,String>();
						paramMap.put("dictCode", dictCode);
						paramMap.put("valueCode", dictValue.getValueCode());
						cnt = dictMapper.queryDictValueCountByDictId(paramMap);
						if (cnt > 0) {
							result.setMsg("字典码为【" + dictValue.getValueCode() + "】的数据已存在");
							return result;
						}
						paramMap.clear();
						paramMap.put("dictCode", dictCode);
						paramMap.put("valueName", dictValue.getValueName());
						cnt = dictMapper.queryDictValueCountByDictId(paramMap);
						if (cnt > 0) {
							result.setMsg("字典值为【" + dictValue.getValueName() + "】的数据已存在");
							return result;
						}
						dictValue.setFcu(sysUser.getUserName());
						dictValue.setFcd(new Timestamp(System.currentTimeMillis()));
						dictMapper.addDictValue(dictValue);
						result.setCode(ResultCode.SUCCESS);
					}
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("处理出现异常，请联系管理员");
			result.setCode(ResultCode.EXCEPTION);
			return result;
		}
	}

	@Override
	public List<Dict> queryDictAndDictValue() throws ServiceException {
		try{
			return dictMapper.queryDictAndDictValue();
		}catch(Exception e){
			log.error("查询数据字典及其值异常",e);
			return null;
		}
	}

}
