/**
 * Project Name:org.myframework.web <br>
 * File Name:MyUserDetailsService.java <br>
 * Package Name:org.myframework.web.security.mine <br>
 * @author xiezbmf
 * Date:2017年7月24日下午4:08:23 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.mine;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ClassName: MyUserDetailsService <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月24日下午4:08:23 <br>
 * @version
 * @since JDK 1.6
 */
public class MyUserDetailsService  implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
        System.out.println("userDetail********");
        Collection <GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        GrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
        auths.add(auth2);
        User user = new User(username,"123121",true,true,true,true,auths);
        return user;
	}

}

	