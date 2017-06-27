/**
 * Project Name:org.myframework.common <br>
 * File Name:DataException.java <br>
 * Package Name:org.myframework.common.exception <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:14:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.exception;


/**
 * ClassName: DataException <br>
 * Description: 持久层数据操作异常
 * @author xiezbmf
 * @Date 2017年6月27日下午3:14:16 <br>
 * @version
 * @since JDK 1.6
 */
public class DataException  extends BaseException{
	private static final long serialVersionUID = 4093014278554938973L;
	
	public DataException(){
		super();
		this.errCode = "10000";
		this.message = "数据操作异常";
	}
	public DataException(String errCode,String errMsg){
		super(errCode,errMsg);
		String startCode = "1";
		int codeLength = 5;
		if(!isLegalErrCode(startCode,codeLength)){
			throw new IllegalArgumentException("错误的errCode，应以"+startCode+"开头，长度为"+codeLength);
		}
	}

}

	