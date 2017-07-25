/**
 * Project Name:org.myframework.web <br>
 * File Name:MyAccessDecisionManager.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月10日上午9:58:42 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * ClassName: MyAccessDecisionManager <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月10日上午9:58:42 <br>
 * @version
 * @since JDK 1.6
 */
public class MyAccessDecisionManager implements AccessDecisionManager{

    @Override
    public void decide(Authentication authentication, Object object,
            Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
            InsufficientAuthenticationException {
        if(configAttributes  == null){
            return ;
        }
        System.out.println(object.toString());
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while(ite.hasNext()){
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig)ca).getAttribute();
            
            for(GrantedAuthority ga : authentication.getAuthorities()){
                if(needRole.equals(ga.getAuthority())){
                    return ;
                }
            }
        }
        throw new AccessDeniedException("no right");
        
    }

    @Override
    public boolean supports(ConfigAttribute arg0) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return true;
    }

}

	