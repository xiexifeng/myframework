/**
 * Project Name:org.myframework.web <br>
 * File Name:User.java <br>
 * Package Name:org.myframework.web.security.third <br>
 * @author xiezbmf
 * Date:2017年7月21日下午5:49:21 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.third;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * ClassName: User <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日下午5:49:21 <br>
 * @version
 * @since JDK 1.6
 */
public class User implements Authentication {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -5224468191078837398L;
	
	Set<GrantedAuthority>  accesses;

	@Override
	public String getName() {

		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public Object getCredentials() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {

		// TODO Auto-generated method stub

	}

	public Set<GrantedAuthority> getAccesses() {
		return accesses;
	}

	public void setAccesses(Set<GrantedAuthority> accesses) {
		this.accesses = accesses;
	}

}

	