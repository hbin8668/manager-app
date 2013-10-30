package com.gdit.framework.manager.sysmanage.dev.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdit.framework.common.annotation.AuthCode;
import com.gdit.framework.common.annotation.MenuCode;
import com.gdit.framework.common.vo.ResultCode;
import com.gdit.framework.common.vo.ResultVO;
import com.gdit.framework.manager.common.web.request.controller.BasicController;
import com.gdit.framework.manager.sysmanage.dev.service.DictService;
import com.gdit.framework.manager.sysmanage.util.MenuDefine;
import com.gdit.framework.manager.sysmanage.util.ModulePathDefine;

/**
 * @功能 ：删除数据字典
 * @公司 ：高度网络
 * @作者 ：hbin
 * @日期 ：2011-11-28
 */

@Controller
@RequestMapping(ModulePathDefine.SM_DEV)
@MenuCode(MenuDefine.SM_DEV_DICT)
public class DictDelController extends BasicController {

	@Autowired
	private DictService dictService;

	/**
	 * 删除
	 */
	@RequestMapping("/dict_del.shtml")
	@ResponseBody
	@AuthCode(8)
	public ResultVO handle_dict_del(HttpServletRequest request, String id) {
		try {
			/** 先删除字典值 */
			ResultVO result = dictService.deleteDictById(id);
			this.addLogOpt(MenuDefine.SM_DEV_DICT, 4, id, result);
			return result;
		} catch (Exception e) {
			this.errorLog("删除数据字典异常:", e);
			return new ResultVO(ResultCode.EXCEPTION, "删除数据字典失败");
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("/dict_batchDel.shtml")
	@ResponseBody
	@AuthCode(8)
	public ResultVO handle_dict_batchDel(HttpServletRequest request, String id) {
		try {
			ResultVO result = dictService.deleteDictById(id);
			this.addLogOpt(MenuDefine.SM_DEV_DICT, 4, id, result);
			return result;
		} catch (Exception e) {
			this.errorLog("批量删除数据字典失败", e);
			return new ResultVO(ResultCode.EXCEPTION, "批量删除数据字典失败");
		}
	}
}
