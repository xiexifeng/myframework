/**
 * Project Name:my-web <br/>
 * File Name:LocalSecurityMetadataSource.java <br/>
 * Package Name:org.myframework.web.security.mine <br/>
 * @author schelling
 * Date:2017年7月27日下午9:50:21 <br/>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 Rights Reserved.
 */

package org.myframework.web.security.mine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * ClassName: LocalSecurityMetadataSource Description: 本地资源管理器
 * 
 * @author schelling Date:2017年7月27日下午9:50:21 <br/>
 * @version
 * @since JDK 1.6
 */
public class LocalSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	/**
	 * 返回url所需权限.
	 * 返回null表示不需要权限
	 * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		FilterInvocation fi = (FilterInvocation) object;
		Map<String, Collection<ConfigAttribute>> metadataSource = LocalSecurityContext.getMetadataSource();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : metadataSource.entrySet()) {
			String uri = entry.getKey();
			RequestMatcher requestMatcher = new AntPathRequestMatcher(uri);
			if (requestMatcher.matches(fi.getHttpRequest())) {
				return entry.getValue();
			}
		}
		return null;
	}

	/**
	 * 如果返回了所有定义的权限资源，Spring
	 * Security会在启动时校验每个ConfigAttribute是否配置正确，不需要校验直接返回null.
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/**
	 * 返回类对象是否支持校验，web项目一般使用FilterInvocation来判断，或者直接返回true.
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
