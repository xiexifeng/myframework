/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserRoleRel.java <br>
 * Package Name:org.myframework.system.model.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:18:28 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.power;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysUserRoleRel <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午3:18:28 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysUserRoleRel")
public class SysUserRoleRel {
	private String userId;
    private String roleId;
    private Date createTime;
    private Date updateTime;
    private String remark;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
		return "SysUserRoleRel [userId=" + userId + ", roleId=" + roleId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", remark=" + remark + "]";
	}
}

	