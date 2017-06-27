/**
 * Project Name:org.myframework.common <br>
 * File Name:Base64Coder.java <br>
 * Package Name:org.myframework.common.util <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:54:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.myframework.common.constant.ConfigConst;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.log.LogTemplate;

/**
 * ClassName: Base64Coder <br>
 * Description: Base64加密解密
 * 
 * @author xiezbmf
 * @Date 2017年6月27日下午3:54:16 <br>
 * @version
 * @since JDK 1.6
 */
public class Base64Coder {
	private static String cmd = "common:Base64Coder";

	private static final Log logger = CommonLogger.getInstance();

	public static String encodeString(String content) {
		try {
			return new String(Base64.encodeBase64(content
					.getBytes(ConfigConst.DEFAULT_ENCODE)),
					ConfigConst.DEFAULT_ENCODE);
		} catch (UnsupportedEncodingException e) {
			logger.error(String.format(LogTemplate.COMMON_SYS_FAIL, cmd,
					"encode String " + content + " is failed"), e);
		}
		return null;
	}

	public static String decodeString(String content) {
		try {
			return new String(Base64.decodeBase64(content),
					ConfigConst.DEFAULT_ENCODE);
		} catch (UnsupportedEncodingException e) {
			logger.error(String.format(LogTemplate.COMMON_SYS_FAIL, cmd,
					"decode String " + content + " is failed"), e);
		}
		return null;
	}
}
