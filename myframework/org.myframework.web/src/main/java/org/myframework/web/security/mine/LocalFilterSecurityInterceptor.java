/**
 * Project Name:my-web <br/>
 * File Name:LocalFilterSecurityInterceptor.java <br/>
 * Package Name:org.myframework.web.security.mine <br/>
 * @author schelling
 * Date:2017年7月27日下午10:15:21 <br/>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 Rights Reserved.
 */

package org.myframework.web.security.mine;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * ClassName: LocalFilterSecurityInterceptor Description: TODO
 * 
 * @author schelling Date:2017年7月27日下午10:15:21 <br/>
 * @version
 * @since JDK 1.6
 */
public class LocalFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void destroy() {

		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getSecureObjectClass() {

		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {

		return this.securityMetadataSource;
	}

	public void invoke(FilterInvocation fi) throws IOException,
			ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			super.afterInvocation(token, null);
		}
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

}
