/**
 * Project Name:org.myframework.common <br>
 * File Name:KeyUtil.java <br>
 * Package Name:org.myframework.common.secret <br>
 * @author xiezbmf
 * Date:2017年7月3日下午4:58:53 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret;

import org.myframework.common.secret.aes.AESCoder;
import org.myframework.common.util.PropertiesUtil;

/**
 * ClassName: KeyUtil <br>
 * Description: 获取秘钥工具类
 * 
 * @author xiezbmf
 * @Date 2017年7月3日下午4:58:53 <br>
 * @version
 * @since JDK 1.6
 */
public class KeyUtil {
	/**
	 * 
	 * getKey:获取加密秘钥. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日下午4:12:38 <br>
	 * @return
	 * @throws Exception
	 */
	public static String getKey() throws Exception {
		String encryptKey = PropertiesUtil.getProperty("AES.KEY");
		if (encryptKey == null || "".equals(encryptKey.trim())) {
			throw new Exception("获取AES.KEY为空");
		}
		String encrypt = PropertiesUtil.getProperty("AES.KEY.ENCRYPT");
		if (encrypt == null) {
			encrypt = "false";
		}
		boolean isEncrypt = Boolean.valueOf(encrypt);
		if (isEncrypt) {
			String key = AESCoder.getDecryptKey(encryptKey);
			return key;
		}
		return encryptKey;
	}
}
