/**
 * Project Name:org.myframework.cache <br>
 * File Name:MemcacheConfig.java <br>
 * Package Name:org.myframework.cache.memcache <br>
 * @author xiezbmf
 * Date:2017年7月5日下午3:01:24 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache.memcache;

import org.myframework.common.util.PropertiesUtil;

/**
 * ClassName: MemcacheConfig <br>
 * Description: Memcache配置常量
 * @author xiezbmf
 * @Date 2017年7月5日下午3:01:24 <br>
 * @version
 * @since JDK 1.6
 */
public interface MemcacheConfig {
	/**
	 * MCACHE_OPERATION_TIMEOUT:memcache operation timeout 单位ms.
	 */
	long MCACHE_OPERATION_TIMEOUT = PropertiesUtil.getPropertyLong("mcache.operation.timeout", 2500);
	
	/**
	 * MCACHE_ADDRESS:memcache服务器地址.
	 */
	String MCACHE_ADDRESS = PropertiesUtil.getProperty("mcache.address", "10.50.10.208:11222");
	
	/**
	 * MCACHE_KEY_PREFIX:memcache缓存key前缀.
	 */
	String MCACHE_KEY_PREFIX = PropertiesUtil.getProperty("mcache.key.prefix","");
	
	/**
	 * CACHE_TIMEOUT:缓存失效时间，单位分钟.
	 */
	int CACHE_TIMEOUT = PropertiesUtil.getPropertyInt("mcache.cache.timeout",60);
	/**
	 * CACHE_TIMEOUT_MINUTE:1m=60s.
	 */
	int CACHE_TIMEOUT_MINUTE = 60;
}

	