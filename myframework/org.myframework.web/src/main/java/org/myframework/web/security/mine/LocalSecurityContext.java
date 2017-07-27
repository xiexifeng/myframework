/**
 * Project Name:my-web <br/>
 * File Name:LocalSecurityContext.java <br/>
 * Package Name:org.myframework.web.security.mine <br/>
 * @author schelling
 * Date:2017年7月27日下午9:55:14 <br/>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 Rights Reserved.
 */

package org.myframework.web.security.mine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

/**
 * ClassName: LocalSecurityContext
 * Description: TODO
 * @author schelling
 * Date:2017年7月27日下午9:55:14 <br/>
 * @version
 * @since JDK 1.6
 */
public class LocalSecurityContext {
	
	static Map<String, Collection<ConfigAttribute>> METADATA_SOURCE_MAP = 
			new HashMap<String, Collection<ConfigAttribute>>();
	
	public static Map<String, Collection<ConfigAttribute>> getMetadataSource() {
		
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		String key = "/user*";
		String value = "USER";
	    ConfigAttribute configAttribute = new SecurityConfig(value);
	    value = "ADMIN";
	    configAttribute = new SecurityConfig(value);
	    configAttributes.add(configAttribute);
	    METADATA_SOURCE_MAP.put(key, configAttributes);
	    value = "/admin*";
	    key = "ADMIN";
		configAttributes = new ArrayList<ConfigAttribute>();
	    configAttribute = new SecurityConfig(key);
	    configAttributes.add(configAttribute);
	    METADATA_SOURCE_MAP.put(value, configAttributes);
	    return METADATA_SOURCE_MAP;
	}

}

	