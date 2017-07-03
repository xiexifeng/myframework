/**
 * Project Name:org.myframework.common <br>
 * File Name:SecretTool.java <br>
 * Package Name:org.myframework.common.tool <br>
 * @author xiezbmf
 * Date:2017年7月3日下午5:21:11 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.tool;

import org.myframework.common.constant.ConfigConst;
import org.myframework.common.secret.KeyUtil;
import org.myframework.common.secret.aes.AESCoder;

/**
 * ClassName: SecretTool <br>
 * Description: 加密/解密工具类
 * 
 * @author xiezbmf
 * @Date 2017年7月3日下午5:21:11 <br>
 * @version
 * @since JDK 1.6
 */
public class SecretTool {
	/**
	 * 
	 * decrypt:数据解密，返回原文. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日下午2:30:32 <br>
	 * @param content 待解密16进制字符内容
	 * 
	 * @return String 解密后的原文
	 * @throws Exception
	 */
	public static String decrypt(String content) throws Exception {
		if (content == null) {
			throw new IllegalArgumentException("解密内容为空");
		}
		try {
			String decrptStr = AESCoder.decryptToStr(content, KeyUtil.getKey());
			return decrptStr;
		} catch (Exception e) {
			throw new Exception("解密失败", e);
		}
	}
	
	/**
	 * 
	 * encrypt:数据加密，返回16进制字符串. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日下午2:30:32 <br>
	 * @param content 待加密内容
	 * 
	 * @return String 加密后的内容
	 * @throws Exception
	 */
	public static String encrypt(String content) throws Exception {
		if (content == null) {
			throw new IllegalArgumentException("加密内容为空");
		}
		if (content.getBytes().length > ConfigConst.ENCRYPT_BYTE_LENGTH) {
			throw new IllegalArgumentException("加密内容过长");
		}
		try {
			String encrptStr = AESCoder.encryptToStr(content, KeyUtil.getKey());
			return encrptStr;
		} catch (Exception e) {
			throw new Exception("加密失败", e);
		}
	}

	/**
	 * 
	 * decrypt:数据解密，返回原文. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日下午2:30:32 <br>
	 * @param content 待解密16进制字符内容
	 * @param key 解密秘钥
	 * 
	 * @return String 解密后的原文
	 * @throws Exception
	 */
	public static String decrypt(String content, String key) throws Exception {
		if (content == null ) {
			throw new IllegalArgumentException("解密内容为空");
		}
		if (key == null ) {
			throw new IllegalArgumentException("秘钥为空");
		}
		try {
			String decrptStr = AESCoder.decryptToStr(content, key);
			return decrptStr;
		} catch (Exception e) {
			throw new Exception("解密失败", e);
		}
	}
	
	/**
	 * 
	 * encrypt:数据加密，返回16进制字符串. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日下午2:30:32 <br>
	 * @param content 待加密内容
	 * @param key 加密秘钥
	 * 
	 * @return String 加密后的内容
	 * @throws Exception
	 */
	public static String encrypt(String content,String key) throws Exception {
		if (content == null) {
			throw new IllegalArgumentException("加密内容为空");
		}
		if (key == null) {
			throw new IllegalArgumentException("秘钥为空");
		}
		if (content.getBytes().length > ConfigConst.ENCRYPT_BYTE_LENGTH) {
			throw new IllegalArgumentException("加密内容过长");
		}
		try {
			String encrptStr = AESCoder.encryptToStr(content, key);
			return encrptStr;
		} catch (Exception e) {
			throw new Exception("加密失败", e);
		}
	}
}
