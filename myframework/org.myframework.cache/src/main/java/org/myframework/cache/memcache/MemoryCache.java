/**
 * Project Name:org.myframework.cache <br>
 * File Name:MemoryCache.java <br>
 * Package Name:org.myframework.cache.memcache <br>
 * @author xiezbmf
 * Date:2017年7月4日下午5:42:12 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache.memcache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.LogTemplate;

/**
 * ClassName: MemoryCache <br>
 * Description: memcache 
 * 
 * @author xiezbmf
 * @Date 2017年7月4日下午5:42:12 <br>
 * @version
 * @since JDK 1.6
 */
public class MemoryCache {
	private static CommonLogger logger = CommonLogger.getInstance();

	private static MemcachedClient memcachedClient = null;
	/**
	 * CONFIG_KEY_PREFIX:key前缀.
	 */
	private static final String CONFIG_KEY_PREFIX = MemcacheConfig.MCACHE_KEY_PREFIX;

	static {
		try {
			memcachedClient = new MemcachedClient(new MemConnectionFactory(),
					AddrUtil.getAddresses(MemcacheConfig.MCACHE_ADDRESS));// 192.168.9.106:11211
		} catch (IOException e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:getClient", "获取memcache连接失败"), e);
		}
	}

	/**
	 * 
	 * set:使用过期时间进行缓存,单位为秒. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:53:12 <br>
	 * @param key 关键值
	 * @param value 值
	 * @param exp 过期时间
	 * 
	 * @return boolean
	 */
	public static boolean set(String key, Object value, int exp) {
		if (null == value) {
			return false;
		}
		try {
			OperationFuture<Boolean> future = memcachedClient.set(CONFIG_KEY_PREFIX + key, exp, value);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:set", e.getMessage()));
		}
		return false;
	}

	/**
	 * set:默认缓存，过期时间为永不过期（默认一月）. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:54:34 <br>
	 * @param key
	 * @param value
	 * 
	 * @return boolean
	 */
	public static boolean set(String key, Object value) {
		if (null == value) {
			return false;
		}
		try {
			OperationFuture<Boolean> future = memcachedClient.set(CONFIG_KEY_PREFIX + key, 0, value);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:set", e.getMessage()));
		}
		return false;
	}

	/**
	 * 
	 * get:获取缓存内容. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:55:20 <br>
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object value = null;
		try {
			value = memcachedClient.get(CONFIG_KEY_PREFIX + key);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:get", e.getMessage()));
		}
		return value;
	}

	/**
	 * 
	 * touch:使用2进制协议，更新时间，单位为秒. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:55:51 <br>
	 * @param key
	 * @param newExp
	 * @return
	 */
	public static Object touch(String key, int newExp) {
		Object value = null;
		try {
			value = memcachedClient.touch(CONFIG_KEY_PREFIX + key,newExp);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:touch", e.getMessage()));
		}
		return value;
	}

	/**
	 * 
	 * touch:使用2进制协议，更新时间（默认设置为永不过期）. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:58:56 <br>
	 * @param key
	 * @return
	 */
	public static Object touch(String key) {
		Object value = null;
		try {
			value = memcachedClient.touch(CONFIG_KEY_PREFIX + key,0);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:touch", e.getMessage()));
		}
		return value;
	}

	/**
	 * 
	 * delete:删除缓存内容. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:59:27 <br>
	 * @param key
	 * 
	 * @return boolean
	 */
	public static boolean delete(String key) {
		try {
			OperationFuture<Boolean> future = memcachedClient.delete(CONFIG_KEY_PREFIX + key);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:delete", e.getMessage()));
		}
		return false;
	}

	/**
	 * 
	 * replace:更新缓存内容及过期时间. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午5:59:51 <br>
	 * @param key
	 * @param value
	 * @param exp
	 * 
	 * @return boolean
	 */
	public static boolean replace(String key, Object value, int exp) {
		try {
			OperationFuture<Boolean> future = memcachedClient.replace(CONFIG_KEY_PREFIX + key, exp, value);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:replace", e.getMessage()));
		}
		return false;
	}

	/**
	 * 
	 * replace:更新缓存内容及过期时间,默认永不过期. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午6:00:17 <br>
	 * @param key
	 * @param value
	 * 
	 * @return boolean
	 */
	public static boolean replace(String key, Object value) {
		try {
			OperationFuture<Boolean> future = memcachedClient.replace(CONFIG_KEY_PREFIX + key, 0, value);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:replace", e.getMessage()));
		}
		return false;
	}

	/**
	 * 
	 * incr:自增操作. 失败时返回自增值by<br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午6:01:00 <br>
	 * @param key
	 * @param by
	 * @return 
	 */
	public static long incr(String key, long by) {
		long incr = by;
		try {
			incr = memcachedClient.incr(MemcacheConfig.MCACHE_KEY_PREFIX + key, by);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:incr", e.getMessage()));
		}
		return incr;
	}

	/**
	 * 
	 * decr:自减操作.失败时返回自减值by <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月4日下午6:02:00 <br>
	 * @param key
	 * @param by
	 * @return
	 */
	public static long decr(String key, long by) {
		long decr = by;
		try {
			decr = memcachedClient.decr(MemcacheConfig.MCACHE_KEY_PREFIX + key, by);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:decr", e.getMessage()));
		}
		return decr;
	}

	/**
	 * 刷新缓存，即清除,此方法会使用所有缓存项失效，慎用
	 * 
	 * @return
	 */
	@Deprecated
	public static boolean flush() {
		boolean flag = false;
		try {
			OperationFuture<Boolean> future = memcachedClient.flush();
			flag = getBooleanValue(future);
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:flush", e.getMessage()));
		}
		return flag;
	}

	/**
	 * 
	 * append:追加值. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月5日上午9:49:35 <br>
	 * @param key
	 * @param val
	 * @return
	 */
	public static boolean append(String key, Object val) {
		try {
			CASValue<Object> casV = memcachedClient.gets(key);
			if(casV==null){
				return false;
			}
			long cas = casV.getCas();
			System.out.println(cas);
			OperationFuture<Boolean> future = memcachedClient.append(cas, key, val);
			return future.get();
		} catch (Exception e) {
			logger.error(LogTemplate.genCommonSysFailLogStr("MemoryCache:append", e.getMessage()));
		}
		return false;
	}

	private static boolean getBooleanValue(OperationFuture<Boolean> f) {
		try {
			Boolean bool = f.get(2500, TimeUnit.MILLISECONDS);
			return bool.booleanValue();
		} catch (Exception e) {
			f.cancel(false);
			return false;
		}
	}
	
	public static MemcachedClient getMemcachedClient() {
		return memcachedClient;
	}
	
	public static void main(String[] args) {
		boolean flag = MemoryCache.set("123", "hello world!");
		System.out.println(flag);
		Object obj = MemoryCache.get("123");
		System.out.println(obj.toString());
		System.out.println(MemoryCache.append("1234", "hi"));
		for(int i=0;i<10;i++){
			Thread t = new Thread(){
				public void run(){
					System.out.println(MemoryCache.append("123", "hi"));
					Object obj = MemoryCache.get("123");
					System.out.println(obj.toString());
				}
			};
			t.start();
		}
//		MemoryCache.append("123", "hi");
//		MemoryCache.append("123", "hi");
		 
//		MemoryCache.memcachedClient.shutdown();
	}

	
}
