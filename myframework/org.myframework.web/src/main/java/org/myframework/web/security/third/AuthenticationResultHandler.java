/**
 * Project Name:org.myframework.web <br>
 * File Name:AuthenticationResultHandler.java <br>
 * Package Name:org.myframework.web.security.third <br>
 * @author xiezbmf
 * Date:2017年7月24日下午2:41:01 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.third;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * ClassName: AuthenticationResultHandler <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月24日下午2:41:01 <br>
 * @version
 * @since JDK 1.6
 */
public class AuthenticationResultHandler implements AuthenticationFailureHandler,AuthenticationSuccessHandler{
	private boolean forward;
	private String loginFailurePage;
	private String loginSuccessPage;
	private String certLoginUrl;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
			// TODO Auto-generated method stub
			
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
			// TODO Auto-generated method stub
			
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getLoginFailurePage() {
		return loginFailurePage;
	}

	public void setLoginFailurePage(String loginFailurePage) {
		this.loginFailurePage = loginFailurePage;
	}

	public String getLoginSuccessPage() {
		return loginSuccessPage;
	}

	public void setLoginSuccessPage(String loginSuccessPage) {
		this.loginSuccessPage = loginSuccessPage;
	}

	public String getCertLoginUrl() {
		return certLoginUrl;
	}

	public void setCertLoginUrl(String certLoginUrl) {
		this.certLoginUrl = certLoginUrl;
	}


}

	