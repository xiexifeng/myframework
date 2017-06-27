/**
 * Project Name:org.myframework.common <br>
 * File Name:LogTemplate.java <br>
 * Package Name:org.myframework.common.log <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:16:39 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.log;
/**
 * ClassName: LogTemplate <br>
 * Description: 日志输出模板
 * @author xiezbmf
 * @Date 2017年6月27日下午3:16:39 <br>
 * @version
 * @since JDK 1.6
 */
public class LogTemplate {
	public static final String COMMON_BIZ = "cmd=%s | result=%s | sid=%s | tid=%s | uid=%s | msg=%s |";
	
	public static final String COMMON_BIZ_REQ = "cmd=%s | result=%s | sid=%s | tid=%s | uid=%s | msg=%s | data=%s |";
	
	public static final String COMMON_SYS = "cmd=%s | result=%s | msg=%s |";
	
	public static final String COMMON_SYS_OK = "cmd=%s | result=OK | msg=%s |";
	
	public static final String COMMON_SYS_FAIL = "cmd=%s | result=FAIL | msg=%s |";
}

	