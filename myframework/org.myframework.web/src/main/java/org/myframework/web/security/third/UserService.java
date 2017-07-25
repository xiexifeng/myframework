/**
 * Project Name:org.myframework.web <br>
 * File Name:UserService.java <br>
 * Package Name:org.myframework.web.security.third <br>
 * @author xiezbmf
 * Date:2017年7月21日下午5:55:25 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.third;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * ClassName: UserService <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日下午5:55:25 <br>
 * @version
 * @since JDK 1.6
 */
public class UserService implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		PassCardAuthenticationToken token=(PassCardAuthenticationToken)authentication;
		if(token.getUserAccount()!=null&&token.getAccPwd()!=null){  
			User user= new User();
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {

		// TODO Auto-generated method stub
		return false;
	}

}

	