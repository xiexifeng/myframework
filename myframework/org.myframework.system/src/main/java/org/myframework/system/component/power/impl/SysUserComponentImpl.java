/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserComponentImpl.java <br>
 * Package Name:org.myframework.system.component.power.impl <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:34:06 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.power.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myframework.common.exception.DataException;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.util.AssertUtil;
import org.myframework.system.component.power.SysUserComponent;
import org.myframework.system.dao.power.SysUserDao;
import org.myframework.system.model.power.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * ClassName: SysUserComponentImpl <br>
 * Description: 系统用户数据操作组件接口实现类
 * @author xiezbmf
 * @Date 2017年7月11日下午3:34:06 <br>
 * @version
 * @since JDK 1.6
 */
@Component("sysUserComponent")
public class SysUserComponentImpl implements SysUserComponent {

	protected static final Log logger = CommonLogger.getInstance();
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public void saveSysUserInfo(SysUser sysUser) throws DataException {
		AssertUtil.notNull(sysUser, "保存sysUser不能为空");
		int saveNum = sysUserDao.saveSysUser(sysUser);
		if(saveNum!=1){
			throw new DataException();
		}
	}

	@Override
	public SysUser querySysUserByAccount(String userAccount) {
		AssertUtil.hasText(userAccount);
		Map<String,String> params = new HashMap<String,String>();
		params.put("userAccount", userAccount);
		List<SysUser> list = sysUserDao.querySysUserByParams(params);
		if(!CollectionUtils.isEmpty(list)&&list.size()==1){
			return list.get(0);
		}
	    return null;
	}

	@Override
	public SysUser querySysUserById(String userId) {
		AssertUtil.hasText(userId);
		Map<String,String> params = new HashMap<String,String>();
		params.put("userId", userId);
		List<SysUser> list = sysUserDao.querySysUserByParams(params);
		if(!CollectionUtils.isEmpty(list)&&list.size()==1){
			return list.get(0);
		}
	    return null;
	}

	@Override
	public SysUser querySysUserByAuth(String userAccount, String accPwd) {
		
		AssertUtil.hasText(userAccount);
		AssertUtil.hasText(accPwd);
		Map<String,String> params = new HashMap<String,String>();
		params.put("userAccount", userAccount);
		params.put("accPwd", accPwd);
		List<SysUser> list = sysUserDao.querySysUserByParams(params);
		if(!CollectionUtils.isEmpty(list)&&list.size()==1){
			return list.get(0);
		}
	    return null;
	}

}

	