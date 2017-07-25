/**
 * Project Name:org.myframework.system <br>
 * File Name:SysRole.java <br>
 * Package Name:org.myframework.system.model.power <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:40:48 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.power;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysRole <br>
 * Description: 系统角色
 * 
 * @author xiezbmf
 * @Date 2017年7月11日上午9:40:48 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysRole")
public class SysRole {
	/**
	 * roleId:primary key.
	 */
	private String roleId;
	/**
	 * roleName:角色名称.
	 */
	private String roleName;
	/**
	 * roleDesc:角色描述.
	 */
	private String roleDesc;
	/**
	 * isEnable:是否启用.
	 */
	private boolean isEnable;
	private Date createTime;
	private Date updateTime;
	private String remark;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
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
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDesc=" + roleDesc + ", isEnable=" + isEnable
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", remark=" + remark + "]";
	}
	
}
