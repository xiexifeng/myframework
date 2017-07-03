/**
 * Project Name:org.myframework.common <br>
 * File Name:MD5Digest.java <br>
 * Package Name:org.myframework.common.secret.digest <br>
 * @author xiezbmf
 * Date:2017年7月3日下午4:51:15 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret.digest;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * ClassName: MD5Digest <br>
 * Description: TODO
 * 
 * @author xiezbmf
 * @Date 2017年7月3日下午4:51:15 <br>
 * @version
 * @since JDK 1.6
 */
public class MD5Digest {
	/**
	 * 
	 * encodeMD5:MD5消息摘要. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年7月3日上午9:23:29 <br>
	 * @param data 待做摘要处理的数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception {
		return DigestUtils.md5(data);
	}

	/**
	 * 
	 * encodeMD5Hex:MD5消息摘要. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年7月3日上午9:24:11 <br>
	 * @param data 待做摘要处理的数据
	 * @return String 消息摘要(32位的16进制小写字符串)
	 * @throws Exception
	 */
	public static String encodeMD5Hex(String data) throws Exception {
		return DigestUtils.md5Hex(data);
	}
}
