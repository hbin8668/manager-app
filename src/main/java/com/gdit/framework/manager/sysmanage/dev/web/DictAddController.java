package com.gdit.framework.manager.sysmanage.dev.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdit.framework.common.annotation.AuthCode;
import com.gdit.framework.common.annotation.MenuCode;
import com.gdit.framework.manager.common.utils.CommonPageDefine;
import com.gdit.framework.common.vo.ResultCode;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.common.web.request.controller.BasicController;
import com.gdit.framework.manager.sysmanage.dev.service.DictService;
import com.gdit.framework.manager.sysmanage.dev.vo.Dict;
import com.gdit.framework.manager.sysmanage.util.MenuDefine;
import com.gdit.framework.manager.sysmanage.util.ModulePathDefine;

/**
 * @功能 ：查看数据字典列表
 * @公司 ：高度网络
 * @作者 ：hbin
 * @日期 ：2011-11-28
 */

@Controller
@RequestMapping(ModulePathDefine.SM_DEV)
@MenuCode(MenuDefine.SM_DEV_DICT)
@AuthCode(2)
public class DictAddController extends BasicController {

	@Autowired
	private DictService dictService;

	/**
	 * 新增
	 */
	@RequestMapping("/jump_dict_add_page.shtml")
	public String go_dict_add_page(HttpServletRequest request) {
		try {
			return ModulePathDefine.SM_DEV + "dict_add";
		} catch (Exception e) {
			return CommonPageDefine.ERROR;
		}
	}

	@RequestMapping(value = "/dict_add.shtml", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO dict_add(HttpServletRequest request, Dict dict) {
		try {
			this.setUserInfo(request);
			dict.setFcu(sysUser.getUserId());
			dict.setLcu(sysUser.getUserId());
			ResultVO result = dictService.addDict(dict);
			this.addLogOpt(MenuDefine.SM_DEV_DICT, 2, dict.getDictName(), result);
			return new ResultVO(ResultCode.SUCCESS, "新增数据字典成功");
		} catch (Exception e) {
			this.errorLog("新增数据字典失败", e);
			return new ResultVO(ResultCode.EXCEPTION, "新增数据字典失败" + e.getMessage());

		}
	}

}
