/**
 * Project Name:org.myframework.web <br>
 * File Name:User.java <br>
 * Package Name:org.myframework.web.security.second <br>
 * @author xiezbmf
 * Date:2017年7月21日上午9:37:45 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.commons.lang.StringUtils;

/**
 * ClassName: User <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日上午9:37:45 <br>
 * @version
 * @since JDK 1.6
 */
public class User implements UserDetails{
	private static final long serialVersionUID = 8026813053768023527L;  
	  
    
    private String account;  
      
    private String name;  
      
    private String password;  
      
    private boolean disabled;  
   
    private Set<Role> roles;  
      
   
    private Map<String, List<Resource>> roleResources;  
      
    /** 
     * The default constructor 
     */  
    public User() {  
          
    }  
      
    /** 
     * Returns the authorites string 
     *  
     * eg.  
     *    downpour --- ROLE_ADMIN,ROLE_USER 
     *    robbin --- ROLE_ADMIN 
     *  
     * @return 
     */  
    public String getAuthoritiesString() {  
        List<String> authorities = new ArrayList<String>();  
        for(GrantedAuthority authority : this.getAuthorities()) {  
            authorities.add(authority.getAuthority());  
        }  
        return StringUtils.join(authorities, ",");  
    }  
  
    @Override  
    public Collection<? extends GrantedAuthority> getAuthorities() {  
        // 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过  
        if(!roles.isEmpty()){  
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();  
            GrantedAuthority au = new SimpleGrantedAuthority("ROLE_USER");  
            list.add(au);  
            return list;  
        }  
        return null;  
    }  
  
    /*  
     * 密码 
     */  
    public String getPassword() {  
        return password;  
    }  
  
    /*  
     * 用户名 
     */  
    public String getUsername() {  
        return name;  
    }  
  
    /*  
     *帐号是否不过期，false则验证不通过 
     */  
    public boolean isAccountNonExpired() {  
        return true;  
    }  
  
    /*  
     * 帐号是否不锁定，false则验证不通过 
     */  
    public boolean isAccountNonLocked() {  
        return true;  
    }  
  
    /*  
     * 凭证是否不过期，false则验证不通过 
     */  
    public boolean isCredentialsNonExpired() {  
        return true;  
    }  
  
    /*  
     * 该帐号是否启用，false则验证不通过 
     */  
    public boolean isEnabled() {  
        return !disabled;  
    }  
  
   
  
    /** 
     * @return the name 
     */  
    public String getName() {  
        return name;  
    }  
  
    /** 
     * @return the disabled 
     */  
    public boolean isDisabled() {  
        return disabled;  
    }  
  
    /** 
     * @return the roles 
     */  
    public Set<Role> getRoles() {  
        return roles;  
    }  
  
    /** 
     * @return the roleResources 
     */  
    public Map<String, List<Resource>> getRoleResources() {  
        // init roleResources for the first time  
        System.out.println("---------------------------------------------------");  
        if(this.roleResources == null) {  
              
            this.roleResources = new HashMap<String, List<Resource>>();  
              
            for(Role role : this.roles) {  
                String roleName = role.getRoleName();  
                Set<Resource> resources = role.getResources();  
                for(Resource resource : resources) {  
                    String key = roleName + "_" + resource.getType();  
                    if(!this.roleResources.containsKey(key)) {  
                        this.roleResources.put(key, new ArrayList<Resource>());  
                    }  
                    this.roleResources.get(key).add(resource);                    
                }  
            }  
              
        }  
        return this.roleResources;  
    }  
  
   
    /** 
     * @param name the name to set 
     */  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    /** 
     * @param password the password to set 
     */  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    /** 
     * @param disabled the disabled to set 
     */  
    public void setDisabled(boolean disabled) {  
        this.disabled = disabled;  
    }  
  
    /** 
     * @param roles the roles to set 
     */  
    public void setRoles(Set<Role> roles) {  
        this.roles = roles;  
    }  
  
    public String getAccount() {  
        return account;  
    }  
  
    public void setAccount(String account) {  
        this.account = account;  
    }  
  
    public void setRoleResources(Map<String, List<Resource>> roleResources) {  
        this.roleResources = roleResources;  
    }  
}

	