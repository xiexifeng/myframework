/**
 * Project Name:org.myframework.common <br>
 * File Name:Base64Coder.java <br>
 * Package Name:org.myframework.common.util <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:54:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.util;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;

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

	public static String encodeString(String content) {
		byte[] data = content.getBytes(Charsets.UTF_8);
		return encodBase64String(data);
	}

	public static String decodeString(String content) {
		byte[] data = decodeBase64(content);
	    return new String(data, Charsets.UTF_8);
	}

	public static String encodBase64String(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	public static byte[] decodeBase64(String content) {
		return Base64.decodeBase64(content);
	}
}
