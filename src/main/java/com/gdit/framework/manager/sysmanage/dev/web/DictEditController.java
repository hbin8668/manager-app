package com.gdit.framework.manager.sysmanage.dev.web;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdit.framework.common.annotation.AuthCode;
import com.gdit.framework.common.annotation.MenuCode;
import com.gdit.framework.common.vo.ResultCode;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.common.utils.CommonPageDefine;
import com.gdit.framework.manager.common.web.request.controller.BasicController;
import com.gdit.framework.manager.sysmanage.dev.service.DictService;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.util.MenuDefine;
import com.gdit.framework.manager.sysmanage.util.ModulePathDefine;

/**
 * @功能	：编辑数据字典
 * @公司	：高度网络
 * @作者	：hbin
 * @日期	：2011-11-28
 */

@Controller
@RequestMapping(ModulePathDefine.SM_DEV)
@MenuCode(MenuDefine.SM_DEV_DICT)
@AuthCode(4)
public class DictEditController extends BasicController{

	@Autowired
	private DictService dictService;
	
	@RequestMapping("/jump_dict_edit_page.shtml")
	public String go_dict_edit_page(HttpServletRequest request,ModelMap modelMap,String dictId){
		try{
//			Dict dict = (Dict)dictService.(Dict.class,dictId);
//			modelMap.put("dict",dict);
			return ModulePathDefine.SM_DEV+"dict_edit";
		}
		catch(Exception e){
			this.errorLog("编辑数据字典时加载对象异常", e);
			return CommonPageDefine.ERROR;
		}
	}

	@RequestMapping(value="/dict_edit.shtml",method=RequestMethod.POST)
	@ResponseBody
	public ResultVO dict_edit(HttpServletRequest request,Dict dict){
		try{
			this.setUserInfo(request);
			dict.setLcd(new Timestamp(System.currentTimeMillis()));
			dict.setLcu(sysUser.getUserId());
//			this.addLogOpt(MenuDefine.SM_DEV_DICT, 4, dict.getDictCode(), "修改数据字典成功");
			return new ResultVO(ResultCode.SUCCESS, "修改数据字典成功");

		}catch(Exception e){
			this.errorLog("修改数据字典失败", e);
			return new ResultVO(ResultCode.SUCCESS, "修改数据字典失败"+e.getMessage());

		}
	}
}
