/**
 * Project Name:org.myframework.cache <br>
 * File Name:ApplicationCache.java <br>
 * Package Name:org.myframework.cache <br>
 * @author xiezbmf
 * Date:2017年7月4日下午4:53:17 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.cache;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ApplicationCache <br>
 * Description: web应用session级缓存
 * @author xiezbmf
 * @Date 2017年7月4日下午4:53:17 <br>
 * @version
 * @since JDK 1.6
 */
public class ApplicationCache {
	
	public void setCache(HttpServletRequest req,String key,Object value){
		req.getSession().getServletContext().setAttribute(key, value);
	}
	
	public Object getCache(HttpServletRequest req,String key){
		return req.getSession().getServletContext().getAttribute(key);
	}
}

	