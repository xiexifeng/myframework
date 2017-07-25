/**
 * Project Name:org.myframework.system <br>
 * File Name:SysMenu.java <br>
 * Package Name:org.myframework.system.model.power <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:41:14 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.power;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysMenu <br>
 * Description: 系统菜单
 * @author xiezbmf
 * @Date 2017年7月11日上午9:41:14 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysMenu")
public class SysMenu {
	/**
	 * menuId:primary key.
	 */
	private String menuId;
    /**
     * menuName:菜单名称.
     */
    private String menuName;
    /**
     * menuCode:菜单编码.
     */
    private String menuCode;
    /**
     * menuType:菜单类型.
     */
    private String menuType;
    /**
     * menuUrl:菜单url.
     */
    private String menuUrl;
    /**
     * menuOrder:菜单排序.
     */
    private Integer menuOrder;
    /**
     * menuStyle:菜单样式.
     */
    private String menuStyle;
    /**
     * menuParentId:菜单父节点id.
     */
    private String menuParentId;
    private Date createTime;
    private Date updateTime;
    private String remark;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	public String getMenuStyle() {
		return menuStyle;
	}
	public void setMenuStyle(String menuStyle) {
		this.menuStyle = menuStyle;
	}
	public String getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(String menuParentId) {
		this.menuParentId = menuParentId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SysMenu [menuId=" + menuId + ", menuName=" + menuName
				+ ", menuCode=" + menuCode + ", menuType=" + menuType
				+ ", menuUrl=" + menuUrl + ", menuOrder=" + menuOrder
				+ ", menuStyle=" + menuStyle + ", menuParentId=" + menuParentId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", remark=" + remark + "]";
	}
}

	