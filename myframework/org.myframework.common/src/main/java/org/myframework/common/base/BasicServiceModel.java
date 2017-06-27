/**
 * Project Name:org.myframework.common <br>
 * File Name:BasicServiceModel.java <br>
 * Package Name:org.myframework.common.base <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:12:22 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.base;

import org.myframework.common.constant.ReqStatusConst;


/**
 * ClassName: BasicServiceModel <br>
 * Description: service层返回实例
 * @author xiezbmf
 * @Date 2017年6月27日下午3:12:22 <br>
 * @version
 * @since JDK 1.6
 */
public class BasicServiceModel {
	/**
	 * code:请求响应结果.
	 */
	private String code;
	/**
	 * errorCode:请求出错时，详细错误代码.
	 */
	private String errorCode;
	/**
	 * summary:请求返回消息摘要.
	 */
	private String summary;
	/**
	 * data:请求返回消息内容.
	 */
	private Object data;
	
	/**
	 * 
	 * Creates a new instance of BasicServiceModel.
	 * Description:默认成功实例
	 * @author xiezbmf
	 * @Date 2017年6月26日下午4:44:08 <br>
	 */
	public BasicServiceModel(){
		this.code = ReqStatusConst.OK;
	}
	
	/**
	 * 
	 * Creates a new instance of BasicServiceModel.
	 * Description:失败实例
	 * @author xiezbmf
	 * @Date 2017年6月26日下午4:43:23 <br>
	 * @param errCode 失败具体异常码
	 * @param errMsg 失败描述
	 */
	public BasicServiceModel(String errCode,String errMsg){
		this.code = ReqStatusConst.FAIL;
		this.errorCode = errCode;
		this.summary = errMsg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}

	