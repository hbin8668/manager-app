package com.gdit.framework.manager.sysmanage.dev.vo ;

import com.gdit.framework.common.vo.CommonVO;

/**
 * @author: HUANGBIN
 * @DATE: 2013-10-22 07:46:10
 */

public class Menu extends CommonVO{

	private String parentCode ;// 父级菜单
	private String menuCode ;// 菜单编码
	private String menuName ;// 菜单名称
	private String parentName ;// 
	private String menuType ;// F 前台 B后台菜单
	private String isLeaf ;// 是否叶子菜单
	private String linkUrl ;// 菜单链接地址
	private Integer taxis ;// 排序值
	private String imageFlag ;// 菜单前缀图标
	private String description ;// 描述
	private String dataState ;// 数据状态
	private String delState ;// 删除状态
	
	public String getParentCode(){
			return this.parentCode ;
	}

	public void setParentCode(String parentCode){
			this.parentCode=parentCode ;
	}
	
	public String getMenuCode(){
			return this.menuCode ;
	}

	public void setMenuCode(String menuCode){
			this.menuCode=menuCode ;
	}
	
	public String getMenuName(){
			return this.menuName ;
	}

	public void setMenuName(String menuName){
			this.menuName=menuName ;
	}
	
	public String getParentName(){
			return this.parentName ;
	}

	public void setParentName(String parentName){
			this.parentName=parentName ;
	}
	
	public String getMenuType(){
			return this.menuType ;
	}

	public void setMenuType(String menuType){
			this.menuType=menuType ;
	}
	
	public String getIsLeaf(){
			return this.isLeaf ;
	}

	public void setIsLeaf(String isLeaf){
			this.isLeaf=isLeaf ;
	}
	
	public String getLinkUrl(){
			return this.linkUrl ;
	}

	public void setLinkUrl(String linkUrl){
			this.linkUrl=linkUrl ;
	}
	
	public Integer getTaxis(){
			return this.taxis ;
	}

	public void setTaxis(Integer taxis){
			this.taxis=taxis ;
	}
	
	public String getImageFlag(){
			return this.imageFlag ;
	}

	public void setImageFlag(String imageFlag){
			this.imageFlag=imageFlag ;
	}
	
	public String getDescription(){
			return this.description ;
	}

	public void setDescription(String description){
			this.description=description ;
	}
	
	public String getDataState(){
			return this.dataState ;
	}

	public void setDataState(String dataState){
			this.dataState=dataState ;
	}
	
	public String getDelState(){
			return this.delState ;
	}

	public void setDelState(String delState){
			this.delState=delState ;
	}
	
}