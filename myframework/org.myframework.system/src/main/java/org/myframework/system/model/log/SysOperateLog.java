/**
 * Project Name:org.myframework.system <br>
 * File Name:SysOperateLog.java <br>
 * Package Name:org.myframework.system.model.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午2:53:07 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.model.log;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * ClassName: SysOperateLog <br>
 * Description: 系统操作日志表
 * @author xiezbmf
 * @Date 2017年7月11日下午2:53:07 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("sysOperateLog")
public class SysOperateLog {
	private String operateLogId;
    private String userId;
    private String operate;
    private String modelName;
    private String operateDesc;
    private String ip;
    private String client;
    private Date createTime;
    private String remark;
	public String getOperateLogId() {
		return operateLogId;
	}
	public void setOperateLogId(String operateLogId) {
		this.operateLogId = operateLogId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getOperateDesc() {
		return operateDesc;
	}
	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "SysOperateLog [operateLogId=" + operateLogId + ", userId="
				+ userId + ", operate=" + operate + ", modelName=" + modelName
				+ ", operateDesc=" + operateDesc + ", ip=" + ip + ", client="
				+ client + ", createTime=" + createTime + ", remark=" + remark
				+ "]";
	}
}

	