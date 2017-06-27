/**
 * Project Name:org.myframework.common <br>
 * File Name:CommonLogger.java <br>
 * Package Name:org.myframework.common.log <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:16:25 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.log;


/**
 * ClassName: CommonLogger <br>
 * Description: 输出到名为common的日志器
 * @author xiezbmf
 * @Date 2017年6月27日下午3:16:25 <br>
 * @version
 * @since JDK 1.6
 */
public class CommonLogger extends BaseLogger {
	
	private static CommonLogger commonLogger = null;

	/**
	 * 私有构造函数
	 */
	private CommonLogger() {
	};
	
	/**
	 * getInstance:返回贷款模块的日志记录器实例 <br/>
	 *
	 * @author xiezbmf
	 * Date:2016年9月9日上午10:28:34 <br/>
	 * @return
	 */
	public static CommonLogger getInstance() {
		if (commonLogger == null) {
			commonLogger = new CommonLogger();
		}
		return commonLogger;
	}

	@Override
	protected String getLogName() {
		return "common";
	}


}

	