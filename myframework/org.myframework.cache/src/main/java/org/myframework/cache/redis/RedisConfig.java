/**
 * Project Name:org.myframework.cache <br>
 * File Name:RedisConfig.java <br>
 * Package Name:org.myframework.cache.redis <br>
 * @author xiezbmf
 * Date:2017年7月5日下午3:01:46 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache.redis;

import org.myframework.common.util.PropertiesUtil;

/**
 * ClassName: RedisConfig <br>
 * Description: Redis配置常量
 * @author xiezbmf
 * @Date 2017年7月5日下午3:01:46 <br>
 * @version
 * @since JDK 1.6
 */
public interface RedisConfig {
	/**
	 * ADDR:Redis服务器IP.
	 */
	String ADDR = PropertiesUtil.getProperty("redis.addr", "10.50.10.203");
    /**
     * PORT:Redis的端口号.
     */
    int PORT = PropertiesUtil.getPropertyInt("redis.port", 6379);
  	/**
  	 * MAX_ACTIVE:RedisPool可用连接实例的最大数目，默认值为8.<br>
  	 * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽).
  	 */
  	int MAX_ACTIVE = PropertiesUtil.getPropertyInt("redis.pool.max.active", 200);
    /**
     * MAX_IDLE:控制一个RedisPool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8.
     */
    int MAX_IDLE = PropertiesUtil.getPropertyInt("redis.pool.max.idle", 50);
  	/**
  	 * MAX_WAIT:RedisPool等待可用连接的最大时间，单位毫秒，默认值为-1，
  	 * 表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException.
  	 */
  	int MAX_WAIT = PropertiesUtil.getPropertyInt("redis.pool.max.wait", 10000);
  	/**
  	 * TIMEOUT:Redis socket连接超时时间，单位毫秒.
  	 */
  	int TIMEOUT = PropertiesUtil.getPropertyInt("redis.conn.timeout", 10000);
  	/**
  	 * TEST_ON_BORROW:RedisPool在borrow一个jedis实例时，
  	 * 是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的.
  	 */
  	boolean TEST_ON_BORROW = PropertiesUtil.getPropertyBoolean("redis.pool.test.onborrow", true);
}

	