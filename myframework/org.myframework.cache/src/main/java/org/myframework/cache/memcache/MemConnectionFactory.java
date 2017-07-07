/**
 * Project Name:org.myframework.cache <br>
 * File Name:MemConnectionFactory.java <br>
 * Package Name:org.myframework.cache.memcache <br>
 * @author xiezbmf
 * Date:2017年7月4日下午5:42:50 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache.memcache;

import net.spy.memcached.DefaultConnectionFactory;

/**
 * ClassName: MemConnectionFactory <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月4日下午5:42:50 <br>
 * @version
 * @since JDK 1.6
 */
public class MemConnectionFactory extends DefaultConnectionFactory
{
    @Override
    public long getOperationTimeout()
    {
        return MemcacheConfig.MCACHE_OPERATION_TIMEOUT;
    }

}

	