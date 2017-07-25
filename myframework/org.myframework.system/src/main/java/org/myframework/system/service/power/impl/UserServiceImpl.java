/**
 * Project Name:org.myframework.system <br>
 * File Name:UserServiceImpl.java <br>
 * Package Name:org.myframework.system.service.power.impl <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:52:38 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.service.power.impl;

import java.util.Date;

import org.myframework.common.base.BasicServiceModel;
import org.myframework.common.base.ServiceParam;
import org.myframework.common.constant.ReqStatusConst;
import org.myframework.common.exception.BusinessException;
import org.myframework.common.exception.DataException;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.log.LogTemplate;
import org.myframework.common.util.StringUtil;
import org.myframework.system.component.log.SysOperateLogComponent;
import org.myframework.system.component.power.SysUserComponent;
import org.myframework.system.model.power.SysUser;
import org.myframework.system.service.power.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午4:52:38 <br>
 * @version
 * @since JDK 1.6
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	protected static final Log logger = CommonLogger.getInstance();
	@Autowired
	SysOperateLogComponent sysOperateLogComponent;
	
	@Autowired
	SysUserComponent sysUserComponent;
	@Override
	public BasicServiceModel addUser(SysUser sysUser,ServiceParam sp) throws BusinessException {
		
		String cmd = sp.getFunc();
		String sid = sp.getSid();
		String tid = sp.getTid();
		String uid = sp.getUser().getUserId();
		String msg = null;
		try {
			sysUser.setUserId(StringUtil.getUUID32());
			sysUser.setCreateTime(new Date());
			sysUserComponent.saveSysUserInfo(sysUser);
			return new BasicServiceModel();
		} catch (DataException e) {
			msg = "添加系统用户失败,"+e.getMessage();
			logger.error(LogTemplate.genCommonBizLogStr(cmd, ReqStatusConst.DO_DATA_EXCEPTION, sid, tid, uid, msg));
			return new BasicServiceModel(ReqStatusConst.DO_DATA_EXCEPTION,"添加系统用户失败");
		}catch(Exception e){
			throw new BusinessException();
		}
	}

}

	