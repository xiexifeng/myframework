/**
 * Project Name:my-web <br/>
 * File Name:LocalAccessDecisionManager.java <br/>
 * Package Name:org.myframework.web.security.mine <br/>
 * @author schelling
 * Date:2017年7月27日下午10:04:05 <br/>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 Rights Reserved.
 */

package org.myframework.web.security.mine;

import java.util.Collection;
import java.util.Iterator;

import org.myframework.common.util.StringUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

/**
 * ClassName: LocalAccessDecisionManager
 * Description: TODO
 * @author schelling
 * Date:2017年7月27日下午10:04:05 <br/>
 * @version
 * @since JDK 1.6
 */
public class LocalAccessDecisionManager implements AccessDecisionManager {

	/**
	 * authentication包含了当前的用户信息，包括拥有的权限。这里的权限来源就是前面登录时UserDetailsService中设置的authorities.<br/>
	 * object就是FilterInvocation对象，可以得到request等web资源.<br/>
	 * configAttributes是本次访问需要的权限.<br/>
	 * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            if (authentication == null) {
                throw new AccessDeniedException("当前访问没有权限");
            }
            ConfigAttribute configAttribute = iterator.next();
            String needCode = configAttribute.getAttribute();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (StringUtil.equals(authority.getAuthority(), "ROLE_" + needCode)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("当前访问没有权限");

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}

	