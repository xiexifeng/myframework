/**
 * Project Name:org.myframework.web <br>
 * File Name:PasscardAuthenticationProcessingFilter.java <br>
 * Package Name:org.myframework.web.security.third <br>
 * @author xiezbmf
 * Date:2017年7月24日下午2:33:03 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.third;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * ClassName: PasscardAuthenticationProcessingFilter <br>
 * Description: TODO
 * 
 * @author xiezbmf
 * @Date 2017年7月24日下午2:33:03 <br>
 * @version
 * @since JDK 1.6
 */
public class PasscardAuthenticationProcessingFilter extends
		AbstractAuthenticationProcessingFilter {

	private String successPage = "/home/admin/index";
	private String failurePage = "/public/adminLoginEntry";
	private boolean forward = false;
	private boolean useVerifyCode = true;
	private String certLoginUrl;

	/**
	 * 实现AbstractAuthenticationProcessingFilter的有参构造 没记错的话，相当于该filter的访问路径
	 */
	protected PasscardAuthenticationProcessingFilter() {
		super("/adminLoginCheck");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {

		HttpSession s = request.getSession(true);
		PassCardAuthenticationToken token = new PassCardAuthenticationToken();

		String verifyCode = request.getParameter("verifyCode");
		String userID = request.getParameter("username");
		// ....此处省略获取参数，并且验证、赋值的逻辑
		Authentication auth = null;

		try {
			// 此处调用getAuthenticationManager的authenticate方法，当supports方法返回true时执行authenticate方法
			auth = this.getAuthenticationManager().authenticate(token);

			// 此处为登录成功后，相应的处理逻辑
			if (auth == null || !auth.isAuthenticated()) {
				s.setAttribute("__login_error", token.getErrCode());
			} else {
				s.removeAttribute("__login_error");
				s.removeAttribute("__login_username");
				s.removeAttribute("__cert_userid");
				if (token.isEnablePasscard()) {
					s.removeAttribute("__passcard_row1");
					s.removeAttribute("__passcard_row2");
					s.removeAttribute("__passcard_column1");
					s.removeAttribute("__passcard_column2");
				}
			}
		} catch (AuthenticationException e) {
			s.setAttribute("__login_error", token.getErrCode());
			throw e;
		}

		return auth;
	}
	
	public void setSuccessPage(String successPage) {  
        this.successPage = successPage;  
    }  
  
    public void setFailurePage(String failurePage) {  
        this.failurePage = failurePage;  
    }  
  
    public void setForward(boolean forward) {  
        this.forward = forward;  
    }  
  
    public void setCertLoginUrl(String certLoginUrl) {  
        this.certLoginUrl = certLoginUrl;  
    }  
  
    @Override  
    public void afterPropertiesSet() {  
        super.afterPropertiesSet();  
        /* 
        *该处理器实现了AuthenticationSuccessHandler, AuthenticationFailureHandler 
        *用于处理登录成功或者失败后，跳转的界面 
        */  
        AuthenticationResultHandler handler = new AuthenticationResultHandler();  
        handler.setForward(forward);  
        handler.setLoginFailurePage(failurePage);  
        handler.setLoginSuccessPage(successPage);  
        handler.setCertLoginUrl(certLoginUrl);  
        //设置父类中的处理器  
        this.setAuthenticationSuccessHandler(handler);  
        this.setAuthenticationFailureHandler(handler);  
  
    }  

}
