/**
 * Project Name:org.myframework.web <br>
 * File Name:DefaultUserDetailsService.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月10日上午9:52:24 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ClassName: DefaultUserDetailsService <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月10日上午9:52:24 <br>
 * @version
 * @since JDK 1.6
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService{
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("userDetail********");
        Collection <GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        GrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
        auths.add(auth2);
        User user = new User(username,"1111",true,true,true,true,auths);
        return user;
    }
}

	