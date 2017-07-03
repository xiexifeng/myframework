/**
 * Project Name:org.myframework.common <br>
 * File Name:Test.java <br>
 * Package Name:org.myframework.common.secret <br>
 * @author xiezbmf
 * Date:2017年7月3日下午5:09:59 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret;

import org.myframework.common.secret.aes.AESCoder;
import org.myframework.common.secret.aes.IDEACoder;
import org.myframework.common.util.Base64Coder;

/**
 * ClassName: Test <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月3日下午5:09:59 <br>
 * @version
 * @since JDK 1.6
 */
public class Test {

	public static void main(String[] args) throws Exception {
	    String content = "一二三四五一二三四五一二三四五一二三四五一二三四五一二三四五一二三四五一二三四五";//90 192
//	    content = "123456789012345678901234567890";//30 64
//	    content = "abcdefghijabcdefghijabcdefghij";//30 64
	    String password = "1444";
	    // 加密
	    System.out.println("加密前：" + content);
//	    System.out.println("加密前：" + content.getBytes().length);
	    //AES 密文长度 = (原文长度 / 16) * 16 + 16
	    byte[] encryptResult = AESCoder.encrypt(content, password);
	    String encryptResultStr = AESCoder.parseByte2HexStr(encryptResult);
	    System.out.println("加密后：" + encryptResultStr);
	    System.out.println("加密后：HEX," + encryptResultStr.length());
	    // 解密
	    byte[] decryptFrom = AESCoder.parseHexStr2Byte(encryptResultStr);
	    
	    long start = System.currentTimeMillis();
	    byte[] decryptResult = AESCoder.decrypt(decryptFrom, password);
	    long end = System.currentTimeMillis();
	    System.out.println("cost:"+(end-start));
	    System.out.println("解密后：" + new String(decryptResult));

	    String en = AESCoder.encryptToBase64(content, password);
	    System.out.println("加密后：" + en);
	    System.out.println("加密后：64," + en.length());
	    System.out.println("解密后：" + AESCoder.decryptToStrFromBase64(en, password));
	    
	    String inputStr = "一二三四五一二三四五一二三四五一二三四五";
	    byte[] inputData = inputStr.getBytes();
	    System.out.println("原文:"+inputStr);
	    System.out.println("原文:"+inputData.length);
	    byte[] key = IDEACoder.initKey();
	    start = System.currentTimeMillis();
	    inputData = IDEACoder.encrypt(inputData, key);
	    end = System.currentTimeMillis();
	    System.out.println("cost:"+(end-start));
	    System.out.println("加密后:\n"+inputData.length);
	    System.out.println("加密后:\n"+Base64Coder.encodBase64String(inputData));
	    byte[] outputData = IDEACoder.decrypt(inputData, key);
	    System.out.println("解密后:\n"+Base64Coder.encodBase64String(outputData));

	}

}

	