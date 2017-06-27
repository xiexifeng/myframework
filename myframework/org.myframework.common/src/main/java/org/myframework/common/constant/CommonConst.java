/**
 * Project Name:org.myframework.common <br>
 * File Name:CommonConst.java <br>
 * Package Name:org.myframework.common.constant <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:13:30 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.constant;

/**
 * ClassName: CommonConst <br>
 * Description: 公用常量
 * 
 * @author xiezbmf
 * @Date 2017年6月27日下午3:13:30 <br>
 * @version
 * @since JDK 1.6
 */
public class CommonConst {
	
	/**
	 * TIME_MILLISECOND:毫秒单位.
	 */
	public static final int TIME_MILLISECOND = 1000;
	/**
	 * HTTP_CONN_TIMEOUT:连接超时时间 单位为毫秒.
	 */
	public static final int HTTP_CONN_TIMEOUT = 3*TIME_MILLISECOND;

	/**
	 * HTTP_READ_TIMEOUT:读取超时时间 单位为毫秒.
	 */
	public static final int HTTP_READ_TIMEOUT = 10*TIME_MILLISECOND; 
}
