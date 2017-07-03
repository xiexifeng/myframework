/**
 * Project Name:org.myframework.common <br>
 * File Name:IDEACoder.java <br>
 * Package Name:org.myframework.common.secret.aes <br>
 * @author xiezbmf
 * Date:2017年7月3日下午5:02:39 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret.aes;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * ClassName: IDEACoder <br>
 * Description: IDEA
 * 
 * @author xiezbmf
 * @Date 2017年7月3日下午5:02:39 <br>
 * @version
 * @since JDK 1.6
 */
public class IDEACoder {
	public static final String KEY_ALGRORITHM = "IDEA";
	public static final String CIPHER_ALGORITHM = "IDEA/ECB/ISO10126Padding";

	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGRORITHM);
		return secretKey;
	}

	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM,
				new BouncyCastleProvider());
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	public static byte[] initKey() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGRORITHM);
		kg.init(128);
		SecretKey sk = kg.generateKey();
		return sk.getEncoded();
	}
}
