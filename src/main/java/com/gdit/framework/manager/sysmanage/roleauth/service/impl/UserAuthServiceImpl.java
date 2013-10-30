package com.gdit.framework.manager.sysmanage.roleauth.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gdit.framework.manager.sysmanage.roleauth.vo.UserAuth;
import com.gdit.framework.manager.sysmanage.roleauth.mapper.UserAuthMapper;
import com.gdit.framework.manager.sysmanage.roleauth.service.UserAuthService;
import com.gdit.framework.common.vo.ResultVO;
import java.util.List;
import java.util.Map;
/**
 * @功能	：查看用户权限列表
 * @公司	：
 * @作者	：hbin
 * @日期	：2013-10-30 16:47:01
 */

@Service
public class UserAuthServiceImpl implements UserAuthService {
	
	private static final Log LOG = LogFactory.getLog(UserAuthServiceImpl.class);
	
	@Autowired
	private UserAuthMapper userauthMapper;
	
	public ResultVO addUserAuth(UserAuth userAuth){
		try {
			userauthMapper.addUserAuth(userAuth);
			return ResultVO.success("用户权限添加成功");
		} catch (Exception e) {
			LOG.error("添加用户权限异常：", e);
			return ResultVO.failure("用户权限添加失败");
		}
	}
	
	public ResultVO deleteUserAuthByUserAuthId(String userAuthId){
		try {
			userauthMapper.deleteUserAuthByUserAuthId(userAuthId);
			return ResultVO.success("用户权限删除成功");
		} catch (Exception e) {
			LOG.error("删除用户权限异常：", e);
			return ResultVO.failure("用户权限删除失败");
		}
	}
	
	
	public ResultVO deleteUserAuthByUserAuthIds(String[] userAuthIds) {
		try {
			userauthMapper.deleteUserAuthByUserAuthIds(userAuthIds);
			return ResultVO.success("用户权限删除成功");
		} catch (Exception e) {
			LOG.error("删除用户权限异常：", e);
			return ResultVO.failure("用户权限删除失败");
		}
	}
	
	
	public ResultVO editUserAuth(UserAuth userAuth){
		try {
			userauthMapper.editUserAuth(userAuth);
			return ResultVO.success("用户权限修改成功");
		} catch (Exception e) {
			LOG.error("修改用户权限异常：", e);
			return ResultVO.failure("用户权限修改失败");
		}
	}
	
	
	public int queryUserAuthCount(Map paramMap){
		try {
			return userauthMapper.queryUserAuthCount(paramMap);
		} catch (Exception e) {
			LOG.error("查询用户权限总数异常：", e);
			return 0;
		}
	}
	
	public List<UserAuth> queryUserAuthList(Map paramMap){
		try {
			return userauthMapper.queryUserAuthList(paramMap);
		} catch (Exception e) {
			LOG.error("查询用户权限列表异常：", e);
			return null;
		}
	}
	
	
	public UserAuth queryUserAuthByUserAuthId(String userAuthId) {
		try {
			return userauthMapper.queryUserAuthByUserAuthId(userAuthId);
		} catch (Exception e) {
			LOG.error("查询用户权限对象异常：", e);
			return null;
		}
	}
	
}
