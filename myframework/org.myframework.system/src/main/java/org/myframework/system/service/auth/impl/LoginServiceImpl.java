/**
 * Project Name:org.myframework.system <br>
 * File Name:LoginServiceImpl.java <br>
 * Package Name:org.myframework.system.service.auth.impl <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:21:01 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.service.auth.impl;

import org.myframework.common.base.BasicServiceModel;
import org.myframework.common.constant.ReqStatusConst;
import org.myframework.common.exception.DataException;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.log.LogTemplate;
import org.myframework.common.util.StringUtil;
import org.myframework.system.component.log.SysUserLoginLogComponent;
import org.myframework.system.component.power.SysUserComponent;
import org.myframework.system.model.power.SysUser;
import org.myframework.system.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginServiceImpl <br>
 * Description: 登录服务接口实现类
 * @author xiezbmf
 * @Date 2017年7月11日下午4:21:01 <br>
 * @version
 * @since JDK 1.6
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	protected static final Log logger = CommonLogger.getInstance();
	@Autowired
	SysUserLoginLogComponent sysUserLoginLogComponent;
	
	@Autowired
	SysUserComponent sysUserComponent;

	@Override
	public BasicServiceModel login(String userAccount, String accPwd,
			String loginIp, String loginClient) {
		String userId = "loginFailUserId";
		String loginRes = "login success!";
		String cmd = "auth:login";
		String msg = null;
		if(StringUtil.isEmpty(userAccount)){
			msg = "登录账户为空";
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
			return new BasicServiceModel(ReqStatusConst.VALUE_NOT_NULL,msg);
		}
		if(StringUtil.isEmpty(accPwd)){
			msg = "登录账户密码为空";
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
			return new BasicServiceModel(ReqStatusConst.VALUE_NOT_NULL,msg);
		}
		SysUser sysUser = sysUserComponent.querySysUserByAuth(userAccount, accPwd);
		try {
			if(sysUser!=null){
				userId = sysUser.getUserId();
				sysUserLoginLogComponent.saveSysUserLoginSucLog(userId, loginIp, loginClient);
				return new BasicServiceModel();
			}else{
				loginRes = "user:"+userAccount+" with pwd:"+userAccount+" login failed";
			}
			sysUserLoginLogComponent.saveSysUserLoginLog(userId, loginIp, loginClient, loginRes);
		} catch (DataException e) {
			msg = "保存日志失败,"+e.getMessage();
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
		}
		msg = "登录失败";
		return new BasicServiceModel(ReqStatusConst.LOGIN_FAIL,msg);
	}

}

	