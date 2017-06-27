/**
 * Project Name:org.myframework.common <br>
 * File Name:BusinessException.java <br>
 * Package Name:org.myframework.common.exception <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:14:03 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.exception;


/**
 * ClassName: BusinessException <br>
 * Description: 业务层操作异常
 * @author xiezbmf
 * @Date 2017年6月27日下午3:14:03 <br>
 * @version
 * @since JDK 1.6
 */
public class BusinessException extends BaseException{
	private static final long serialVersionUID = -6331823123583400194L;
	public BusinessException(){
		super();
		this.errCode = "20000";
		this.message = "业务操作异常";
	}
	public BusinessException(String errCode,String errMsg){
		super(errCode,errMsg);
		String startCode = "2";
		int codeLength = 5;
		if(!isLegalErrCode(startCode,codeLength)){
			throw new IllegalArgumentException("错误的errCode，应以"+startCode+"开头，长度为"+codeLength);
		}
	}

}

	