/**
 * Project Name:org.myframework.system <br>
 * File Name:RegisterTest.java <br>
 * Package Name:org.myframework.system.test <br>
 * @author xiezbmf
 * Date:2017年7月11日下午5:23:21 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.test;

import org.junit.Test;
import org.myframework.common.auth.UserInfo;
import org.myframework.common.base.ServiceParam;
import org.myframework.common.exception.BusinessException;
import org.myframework.common.util.StringUtil;
import org.myframework.system.model.power.SysUser;
import org.myframework.system.service.power.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: RegisterTest <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午5:23:21 <br>
 * @version
 * @since JDK 1.6
 */
public class RegisterTest extends BasicJunit{

	@Autowired
	UserService userService;
	@Test
	public void Register(){
		SysUser sysUser = new SysUser();
		ServiceParam sp = new ServiceParam();
		sysUser.setAccPwd("123121");
		sysUser.setIsEnable(true);
		sysUser.setUserAccount("qianshenghua");
		sysUser.setUserName("钱生花");
		sysUser.setTelephone("13502536230");
		sp.setFunc("power:addUser");
		String sid = System.currentTimeMillis()+"";
		sp.setSid(sid);
		sp.setTid(sid);
		UserInfo user = new UserInfo();
		user.setUserId(StringUtil.getUUID32());
		sp.setUser(user);
		try {
			userService.addUser(sysUser, sp);
		} catch (BusinessException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
	}
}

	