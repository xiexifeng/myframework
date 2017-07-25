/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserLoginLogComponentImpl.java <br>
 * Package Name:org.myframework.system.component.log.impl <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:01:42 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.log.impl;

import java.util.Date;

import org.myframework.common.exception.DataException;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.util.AssertUtil;
import org.myframework.common.util.StringUtil;
import org.myframework.system.component.log.SysUserLoginLogComponent;
import org.myframework.system.dao.log.SysUserLoginLogDao;
import org.myframework.system.model.log.SysUserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: SysUserLoginLogComponentImpl <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午4:01:42 <br>
 * @version
 * @since JDK 1.6
 */
@Component("sysUserLoginLogComponent")
public class SysUserLoginLogComponentImpl implements SysUserLoginLogComponent {
	protected static final Log logger = CommonLogger.getInstance();
	
	@Autowired
	SysUserLoginLogDao sysUserLoginLogDao;
	@Override
	public void saveSysUserLoginSucLog(String userId, String loginIp,
			String loginClient) throws DataException {
		String loginRes = "登录成功";
		this.saveSysUserLoginLog(userId, loginIp, loginClient, loginRes);
	}
	@Override
	public void saveSysUserLoginLog(String userId, String loginIp,
			String loginClient, String loginRes) throws DataException {
		
		AssertUtil.hasText(userId, "userId不能为空");
		SysUserLoginLog sysUserLoginLog = new SysUserLoginLog();
		sysUserLoginLog.setUserLoginLogId(StringUtil.getUUID32());
		sysUserLoginLog.setUserId(userId);
		sysUserLoginLog.setLoginIp(loginIp);
		sysUserLoginLog.setLoginTime(new Date());
		sysUserLoginLog.setLoginClient(loginClient);
		sysUserLoginLog.setLoginRes(loginRes);
		int saveNum = sysUserLoginLogDao.saveSysUserLoginLog(sysUserLoginLog);
		if(saveNum!=1){
			throw new DataException();
		}
			
	}

}

	