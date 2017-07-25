/**
 * Project Name:org.myframework.cache <br>
 * File Name:RedisCache.java <br>
 * Package Name:org.myframework.cache.redis <br>
 * @author xiezbmf
 * Date:2017年7月5日下午3:56:10 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache.redis;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.LogTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName: RedisCache <br>
 * Description: Redis缓存
 * 
 * @author xiezbmf
 * @Date 2017年7月5日下午3:56:10 <br>
 * @version
 * @since JDK 1.6
 */
public class RedisCache {

	private static CommonLogger logger = CommonLogger.getInstance();

	private static JedisPool jedisPool = null;
	
	static{
		initJedisPool();
	}

	/**
	 * 
	 * initJedisPool:初始化Redis连接池. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月5日下午4:28:55 <br>
	 */
	private static void initJedisPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(RedisConfig.MAX_ACTIVE);
			config.setMaxIdle(RedisConfig.MAX_IDLE);
			config.setMaxWait(RedisConfig.MAX_WAIT);
			config.setTestOnBorrow(RedisConfig.TEST_ON_BORROW);
			jedisPool = new JedisPool(config, RedisConfig.ADDR,RedisConfig.PORT, RedisConfig.TIMEOUT);
		} catch (Exception e) {
			String msg = "初始化jedis连接池异常," + e.getMessage();
			String cmd = "RedisCache:initJedisPool";
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd,msg));
		}
	}

	/**
	 * 
	 * getJedis:获取Jedis实例. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月5日下午4:29:17 <br>
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		String msg = null;
		String cmd = "RedisCache:getJedis";
		if(jedisPool==null){
			msg = "获取jedis对象失败,jedis连接池为空";
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
			return null;
		}
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			}
		} catch (Exception e) {
			msg = "获取jedis对象异常," + e.getMessage();
			logger.error(LogTemplate.genCommonSysFailLogStr(cmd, msg));
		}
		return null;
	}
	
}
