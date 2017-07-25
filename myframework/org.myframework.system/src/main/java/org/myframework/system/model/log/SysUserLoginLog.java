/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserLoginLog.java <br>
 * Package Name:org.myframework.system.model.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午2:54:19 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.log;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysUserLoginLog <br>
 * Description: 系统用户登录日志表
 * 
 * @author xiezbmf
 * @Date 2017年7月11日下午2:54:19 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysUserLoginLog")
public class SysUserLoginLog {
	private String userLoginLogId;
	private String userId;
	private String loginIp;
	private Date loginTime;
	private String loginClient;
	private String loginRes;
	public String getUserLoginLogId() {
		return userLoginLogId;
	}
	public void setUserLoginLogId(String userLoginLogId) {
		this.userLoginLogId = userLoginLogId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginClient() {
		return loginClient;
	}
	public void setLoginClient(String loginClient) {
		this.loginClient = loginClient;
	}
	@Override
	public String toString() {
		return "SysUserLoginLog [userLoginLogId=" + userLoginLogId
				+ ", userId=" + userId + ", loginIp=" + loginIp
				+ ", loginTime=" + loginTime + ", loginClient=" + loginClient
				+ "]";
	}
	public String getLoginRes() {
		return loginRes;
	}
	public void setLoginRes(String loginRes) {
		this.loginRes = loginRes;
	}
}
