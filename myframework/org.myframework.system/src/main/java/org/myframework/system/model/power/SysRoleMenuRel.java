/**
 * Project Name:org.myframework.system <br>
 * File Name:SysRoleMenuRel.java <br>
 * Package Name:org.myframework.system.model.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:17:38 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.power;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysRoleMenuRel <br>
 * Description: TODO
 * 
 * @author xiezbmf
 * @Date 2017年7月11日下午3:17:38 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysRoleMenuRel")
public class SysRoleMenuRel {
	private String roleId;
	private String menuId;
	private Date createTime;
	private Date updateTime;
	private String remark;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
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
		return "SysRoleMenuRel [roleId=" + roleId + ", menuId=" + menuId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", remark=" + remark + "]";
	}
}
