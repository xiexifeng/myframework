/**
 * Project Name:org.myframework.common <br>
 * File Name:AESCoder.java <br>
 * Package Name:org.myframework.common.secret.aes <br>
 * @author xiezbmf
 * Date:2017年7月3日下午4:53:56 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret.aes;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.myframework.common.constant.ConfigConst;
import org.myframework.common.util.Base64Coder;

/**
 * ClassName: AESCoder <br>
 * Description: AES
 * @author xiezbmf
 * @Date 2017年7月3日下午4:53:56 <br>
 * @version
 * @since JDK 1.6
 */
public class AESCoder {
	/**
	   * KEY_ALGORITHM:秘钥算法.
	   */
	  private static final String KEY_ALGORITHM = "AES";
	  /**
	   * CIPHER_ALGORITHM:加密/解密算法 /工作模式 /填充方式.
	   */
	  private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认模式
	  private static final String HASH_ALGORITHM = "SHA1PRNG";
	  private static final String ENCODE = ConfigConst.DEFAULT_ENCODE;
	  private static final int KEY_LENGTH = ConfigConst.AES_KEY_LENGTH;
	  private static final String SALT = "$#@Sfdf43232/.fs4fc1dfrw324l234JFDWW1!FFqwe";

	  /**
	   * 
	   * toKey:转换加盐处理后的秘钥. <br>
	   * 
	   * @author xiezbmf
	   * @Date 2017年6月28日下午5:56:56 <br>
	   * @param key
	   * @return
	   * @throws Exception
	   */
	  private static SecretKeySpec toKey(String key) throws Exception {
	    key = key + SALT;
	    KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
	    SecureRandom secureRandom = SecureRandom.getInstance(HASH_ALGORITHM);
	    secureRandom.setSeed(key.getBytes(ENCODE));
	    kgen.init(KEY_LENGTH, secureRandom);
	    SecretKey secretKey = kgen.generateKey();
	    byte[] enCodeFormat = secretKey.getEncoded();
	    SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat,KEY_ALGORITHM);
	    return secretKeySpec;
	  }

	  /**
	   * 
	   * encrypt:加密. <br>
	   * 
	   * @author xiezbmf
	   * @Date 2017年6月28日下午5:57:27 <br>
	   * @param msg 待加密内容
	   * @param key 加密key
	   * @return byte[] 
	   * @throws Exception
	   */
	  public static byte[] encrypt(String msg, String key) throws Exception{
	    SecretKeySpec secretKeySpec = toKey(key);
	    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
	    byte[] byteContent = msg.getBytes(ENCODE);
	    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec); // 初始化
	    byte[] result = cipher.doFinal(byteContent);
	    return result; // 加密
	  }

	  /**
	   * 
	   * encryptNotSalt:不加盐的加密. <br>
	   * 
	   * @author xiezbmf
	   * @Date 2017年6月28日下午5:57:58 <br>
	   * @param msg 待加密内容
	   * @param key 加密key
	   * @return byte[] 
	   * @throws Exception
	   */
	  public static byte[] encryptNotSalt(String msg, String key) throws Exception{
	    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
	    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
	    byte[] byteContent = msg.getBytes(ENCODE);
	    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec); // 初始化
	    byte[] result = cipher.doFinal(byteContent);
	    return result; // 加密
	  }

	  /**
	   * 
	   * encryptToStr:带盐加密成16进制字符串. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月28日下午6:10:50 <br>
	   * @param content 加密内容
	   * @param key 加密key
	   * @return String 加密后的字符串
	   * @throws Exception
	   */
	  public static String encryptToStr(String content, String key) throws Exception {
	    return parseByte2HexStr(encrypt(content, key));
	  }
	  
	  /**
	   * 
	   * encryptToStrNotSalt:不带盐加密成16进制字符串. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月28日下午6:11:58 <br>
	   * @param content 加密内容
	   * @param key 加密key
	   * @return 加密后的字符串
	   * @throws Exception
	   */
	  public static String encryptToStrNotSalt(String content, String key) throws Exception{
	    return parseByte2HexStr(encryptNotSalt(content, key));
	  }

	  /**
	   * 
	   * encryptToBase64:使用AES加密，并转换成base64. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:14:23 <br>
	   * @param content 需要加密的内容
	   * @param key 加密key
	   * @return
	   * @throws Exception
	   */
	  public static String encryptToBase64(String content, String key) throws Exception{
	    String s = encryptToStr(content, key);
	    return Base64Coder.encodeString(s);
	  }

	  /**
	   * 
	   * decrypt:解密. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:16:47 <br>
	   * @param data 待解密数据字节码
	   * @param key key
	   * @return byte[] 解密后的字节码
	   * @throws Exception
	   */
	  public static byte[] decrypt(byte[] data, String key) throws Exception{
	    SecretKeySpec secretKeySpec = toKey(key);
	    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
	    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);// 初始化
	    byte[] result = cipher.doFinal(data);
	    return result; // 加密
	  }

	  /**
	   * 
	   * decryptNotSalt:解密不带盐. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:17:31 <br>
	   * @param data 待解密数据
	   * @param key 秘钥
	   * @return byte[] 解密后的数据
	   * @throws Exception
	   */
	  public static byte[] decryptNotSalt(byte[] data, String key)throws Exception {
	    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
	    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
	    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);// 初始化
	    byte[] result = cipher.doFinal(data);
	    return result; // 加密
	  }

	 /**
	  * 
	  * decrypt:16进制字符串不带盐解密. <br>
	  *
	  * @author xiezbmf
	  * @Date 2017年6月29日下午2:20:18 <br>
	  * @param content 待解密字符串（16进制）
	  * @param key 秘钥
	  * @return byte[] 解密后的数据
	  * @throws Exception
	  */
	  public static byte[] decrypt(String content, String key) throws Exception{
	    return decrypt(parseHexStr2Byte(content), key);
	  }

	  /**
	   * 
	   * decryptNotSalt:16进制字符串带盐解密. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:21:43 <br>
	   * @param content 待解密字符串（16进制）
	   * @param key 秘钥
	   * @return byte[] 解密后的数据
	   * @throws Exception
	   */
	  public static byte[] decryptNotSalt(String content, String key) throws Exception{
	    return decryptNotSalt(parseHexStr2Byte(content), key);
	  }


	  /**
	   * 
	   * decryptToStr:解密后转换成系统默认编码的字符串--原文. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:24:05 <br>
	   * @param content 待解密字符串（16进制）
	   * @param key 秘钥
	   * @return String 原文
	   * @throws Exception
	   */
	  public static String decryptToStr(String content, String key) throws Exception{
	    return new String(decrypt(content, key));
	  }

	  /**
	   * 
	   * decryptToStrNotSalt:带盐解密后转换成系统默认编码的字符串--原文. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午2:26:11 <br>
	   * @param content 待解密字符串（16进制）
	   * @param key 秘钥
	   * @return String 原文
	   * @throws Exception
	   */
	  public static String decryptToStrNotSalt(String content, String key) throws Exception{
	    return new String(decryptNotSalt(content, key));
	  }

	  /**
	   * 
	   * decryptToStrFromBase64:解密. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月28日下午6:03:35 <br>
	   * @param content 待解密内容(base64加密的字符串)
	   * @param keyWord 解密密钥
	   * @return byte[] 
	   * @throws Exception
	   */
	  public static String decryptToStrFromBase64(String content, String keyWord) throws Exception{
	    String msg = Base64Coder.decodeString(content);
	    return decryptToStr(msg, keyWord);
	  }

	  /**
	   * 
	   * parseByte2HexStr:将二进制转换成16进制. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月28日下午6:02:13 <br>
	   * @param buf
	   * @return 
	   */
	  public static String parseByte2HexStr(byte buf[]) {
	    if (buf == null) {
	      return null;
	    }
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < buf.length; i++) {
	      String hex = Integer.toHexString(buf[i] & 0xFF);
	      if (hex.length() == 1) {
	        hex = '0' + hex;
	      }
	      sb.append(hex.toUpperCase());
	    }
	    return sb.toString();
	  }

	 /**
	  * 
	  * parseHexStr2Byte:将16进制转换为二进制. <br>
	  *
	  * @author xiezbmf
	  * @Date 2017年6月28日下午6:02:33 <br>
	  * @param hexStr
	  * @return
	  */
	  public static byte[] parseHexStr2Byte(String hexStr) {
	    if (hexStr == null || hexStr.length() < 1) {
	      return null;
	    }
	    byte[] result = new byte[hexStr.length() / 2];
	    for (int i = 0; i < hexStr.length() / 2; i++) {
	      int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
	      int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
	      result[i] = (byte) (high * 16 + low);
	    }
	    return result;
	  }
	  
	  /**
	   * 
	   * genEncryptKey:生成加密key的密文. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午3:28:16 <br>
	   * @param key 待加密的key
	   * @return String 加密后的key
	   * @throws Exception
	   */
	  public static String genEncryptKey(String key) throws Exception{
	    return encryptToStrNotSalt(key, ConfigConst.GEN_ENCRYPT_KEY);
	  }
	  
	  /**
	   * 
	   * getDecryptKey:获取解密后的key. <br>
	   *
	   * @author xiezbmf
	   * @Date 2017年6月29日下午3:29:46 <br>
	   * @param encryptKey 加密后的key
	   * @return String 解密后的key
	   * @throws Exception
	   */
	  public static String getDecryptKey(String encryptKey) throws Exception{
	    return decryptToStrNotSalt(encryptKey, ConfigConst.GEN_ENCRYPT_KEY);
	  }

}

	