/**
 * Project Name:org.myframework.web <br>
 * File Name:AuthenticationExample.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月7日下午4:29:17 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * ClassName: AuthenticationExample <br>
 * Description: 授权例子
 * 
 * @author xiezbmf
 * @Date 2017年7月7日下午4:29:17 <br>
 * @version
 * @since JDK 1.6
 */
public class AuthenticationExample {
	private static AuthenticationManager am = new SampleAuthenticationManager();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Please enter your username:");
			String name = in.readLine();
			System.out.println("Please enter your password:");
			String password = in.readLine();
			try {
				Authentication request = new UsernamePasswordAuthenticationToken(
						name, password);
				Authentication result = am.authenticate(request);
				SecurityContextHolder.getContext().setAuthentication(result);
				break;
			} catch (AuthenticationException e) {
				System.out.println("Authentication failed: " + e.getMessage());
			}
		}
		System.out.println("Successfully authenticated. Security context contains: "
						+ SecurityContextHolder.getContext()
								.getAuthentication());
	}
}

class SampleAuthenticationManager implements AuthenticationManager {
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		if (auth.getName().equals(auth.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(auth.getName(),
					auth.getCredentials(), AUTHORITIES);
		}
		throw new BadCredentialsException("Bad Credentials");
	}
}
