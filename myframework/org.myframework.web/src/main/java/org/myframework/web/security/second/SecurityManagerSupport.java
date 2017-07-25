/**
 * Project Name:org.myframework.web <br>
 * File Name:SecurityManagerSupport.java <br>
 * Package Name:org.myframework.web.security.second <br>
 * @author xiezbmf
 * Date:2017年7月21日上午9:34:47 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.second;

import java.util.HashSet;
import java.util.Set;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.secret.digest.MD5Digest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ClassName: SecurityManagerSupport <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日上午9:34:47 <br>
 * @version
 * @since JDK 1.6
 */
public class SecurityManagerSupport implements UserDetailsService{  
    private Log log = CommonLogger.getInstance();

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.info("SecurityManagerSupport.loadUserByUsername.userName:"+username); 
		User user =null;  
        if("admin".equals(username)){         
            Set<Role> roles = new HashSet<Role>() ;  
            Role role = new Role();  
            role.setRoleId("ROLE_USER");  
            role.setRoleName("ROLE_USER");  
              
            Set<Resource> resources=new HashSet<Resource>() ;  
              
            Resource res = new Resource();  
            res.setResId("ME001");  
            res.setResName("首页");  
            res.setResUrl("/jsp/index/main.jsp");  
            res.setType("ROLE_USER");  
            res.setRoles(roles);  
            resources.add(res);  
              
            role.setResources(resources);  
              
            roles.add(role);  
            user = new User();  
            user.setAccount("admin");  
            user.setDisabled(false);  
            try {
				user.setPassword(MD5Digest.encodeMD5Hex("123456"));
			} catch (Exception e) {
				e.printStackTrace();
			}  
            log.info(user.getPassword());  
            user.setRoles(roles);             
        }  
      return user;//返回UserDetails的实现user不为空，则验证通过  
	}

}

	