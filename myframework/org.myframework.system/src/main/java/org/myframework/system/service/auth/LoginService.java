/**
 * Project Name:org.myframework.system <br>
 * File Name:LoginService.java <br>
 * Package Name:org.myframework.system.service.auth <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:17:52 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.service.auth;

import org.myframework.common.base.BasicServiceModel;

/**
 * ClassName: LoginService <br>
 * Description: 登录服务接口
 * @author xiezbmf
 * @Date 2017年7月11日下午4:17:52 <br>
 * @version
 * @since JDK 1.6
 */
public interface LoginService {

	BasicServiceModel login(String userAccount,String accPwd,String loginIp,
			String loginClient);
}

	