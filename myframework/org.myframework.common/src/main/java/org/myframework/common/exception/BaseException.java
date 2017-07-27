/**
 * Project Name:org.myframework.common <br>
 * File Name:BaseException.java <br>
 * Package Name:org.myframework.common.exception <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:13:56 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.exception;

import org.myframework.common.util.StringUtil;

/**
 * ClassName: BaseException <br>
 * Description: 异常基类
 * @author xiezbmf
 * @Date 2017年6月27日下午3:13:56 <br>
 * @version
 * @since JDK 1.6
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = 8964125350368022571L;
	/**
	 * errCode:异常码.
	 */
	String errCode;
	/**
	 * message:异常信息.
	 */
	String message;

	public String getErrCode() {
		return errCode;
	}

	public String getMessage() {
		return message;
	}

	BaseException() {
		super();
	}

	BaseException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
		this.message = message;
	}
	
	boolean isLegalErrCode(String startCode,int codeLength){
		if(StringUtil.isEmpty(errCode)||!errCode.startsWith(startCode)||errCode.length()!=codeLength){
			return false;
		}
		return true;
	}
}

	