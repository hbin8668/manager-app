package com.gdit.framework.manager.common.web.request.controller;
//package com.gdit.manager.common.request;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Timestamp;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.gdit.common.annotation.MenuCode;
//import com.gdit.common.exception.ServiceException;
//import com.gdit.common.util.Constants;
//import com.gdit.common.util.DateUtil;
//import com.gdit.common.util.FileUtil;
//import com.gdit.common.util.StringUtil;
//import com.gdit.common.vo.ResultVO;
//import com.gdit.manager.common.pojo.sysmanage.FileInfo;
//
//@Controller
//@MenuCode(Constants.COMMON_MENU)
//
//public class FileUploadController extends BasicController {
//
//	private BasicService basicService;
//
//
//	@RequestMapping("/upload.shtml")
//	@ResponseBody
//	public FileInfo upload(HttpServletRequest request,String filePath,String userId,String fileType) {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		MultipartFile file = multipartRequest.getFile("file");
//		String serverFileName = null;
//		serverFileName = DateUtil.getFullDateStr(null) + StringUtil.random(4)+FileUtil.getExtendName(file.getOriginalFilename());
//		File uploadFile = new File(filePath, serverFileName);
//		try {
//			FileCopyUtils.copy(file.getBytes(), uploadFile);
//		} catch (IOException e) {
//			// TODO Autos-generated catch block
//			e.printStackTrace();
//		}
//		FileInfo fileVO = new FileInfo();
//		fileVO.setFilePath(filePath);
//		fileVO.setServerName(serverFileName);
//		fileVO.setFileName(file.getOriginalFilename());
//		fileVO.setFcu(userId);
//		fileVO.setLcu(userId);
//		fileVO.setFcd(new Timestamp(System.currentTimeMillis()));
//		fileVO.setLcd(new Timestamp(System.currentTimeMillis()));
//		fileVO.setType(fileType);
//		try {
//			basicService.save(fileVO);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return fileVO;
//	}
//	
//	@RequestMapping(value="/file_del.shtml",method=RequestMethod.POST)
//	@ResponseBody
//	public ResultVO file_del(HttpServletRequest request,String fileId){
//		try {
//			basicService.delete(FileInfo.class, fileId);
//			return ResultVO.success("文件删除成功");
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			return ResultVO.failure("文件删除失败");
//		}
//	}
//
//}
