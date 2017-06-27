/**
 * Project Name:org.myframework.common <br>
 * File Name:CheckException.java <br>
 * Package Name:org.myframework.common.exception <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:14:10 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.exception;


/**
 * ClassName: CheckException <br>
 * Description: 检查验证性异常
 * @author xiezbmf
 * @Date 2017年6月27日下午3:14:10 <br>
 * @version
 * @since JDK 1.6
 */
public class CheckException extends BaseException{

	private static final long serialVersionUID = 7305413359496028798L;
	
	public CheckException(){
		super();
		this.errCode = "30000";
		this.message = "验证异常";
	}
	public CheckException(String errCode,String errMsg) {
		super(errCode,errMsg);
		String startCode = "3";
		int codeLength = 5;
		if(!isLegalErrCode(startCode,codeLength)){
			throw new IllegalArgumentException("错误的errCode，应以"+startCode+"开头，长度为"+codeLength);
		}
	}
}

	