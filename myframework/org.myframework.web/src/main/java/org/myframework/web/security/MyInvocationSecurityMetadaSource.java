/**
 * Project Name:org.myframework.web <br>
 * File Name:MyInvocationSecurityMetadaSource.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月10日上午9:58:00 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * ClassName: MyInvocationSecurityMetadaSource <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月10日上午9:58:00 <br>
 * @version
 * @since JDK 1.6
 */
public class MyInvocationSecurityMetadaSource 
	implements FilterInvocationSecurityMetadataSource{

//	    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	    private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	    
	    public MyInvocationSecurityMetadaSource(){
	        loadResourceDefine();
	    }
	    
	    private void loadResourceDefine(){
	        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
	        
	        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
	        
	        atts.add(ca);
	        resourceMap.put("/user.jsp", atts);
	        resourceMap.put("/admin.jsp", atts);
	        resourceMap.put("/index.jsp",atts);
	        
	    }
	    
	    @Override
	    public Collection<ConfigAttribute> getAttributes(Object object)
	            throws IllegalArgumentException {
	        // TODO Auto-generated method stub
	        String url = ((FilterInvocation)object).getRequestUrl();
	        Iterator<String> ite = resourceMap.keySet().iterator();
	        
	        while(ite.hasNext()){
	            String resURL = ite.next();
	            
	            if(url.equalsIgnoreCase(resURL)){
	                return resourceMap.get(resURL);
	            }
	            
	        }
	        
	        return null;
	    }

	    @Override
	    public Collection<ConfigAttribute> getAllConfigAttributes() {
	        // TODO Auto-generated method stub
	        return null;
	    }

	    @Override
	    public boolean supports(Class<?> clazz) {
	        // TODO Auto-generated method stub
	        return true;
	    }
}

	