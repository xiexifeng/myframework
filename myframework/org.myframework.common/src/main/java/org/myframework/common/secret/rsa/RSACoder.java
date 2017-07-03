/**
 * Project Name:org.myframework.common <br>
 * File Name:RSACoder.java <br>
 * Package Name:org.myframework.common.secret.rsa <br>
 * @author xiezbmf
 * Date:2017年7月3日下午5:12:50 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.secret.rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.myframework.common.constant.ConfigConst;
import org.myframework.common.util.Base64Coder;

/**
 * ClassName: RSACoder <br>
 * Description: RSA
 * 
 * @author xiezbmf
 * @Date 2017年7月3日下午5:12:50 <br>
 * @version
 * @since JDK 1.6
 */
public class RSACoder {
	public static final Provider pro = new BouncyCastleProvider();

	private static final String charSet = ConfigConst.DEFAULT_ENCODE;

	/**
	 * 
	 * generateKeyPair:生成密钥对 默认1024位. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:42:24 <br>
	 * @param seedKey 种子
	 * @return
	 * @throws Exception
	 */
	public static KeyPair generateKeyPair(String seedKey) throws Exception {
		return generateKeyPair(seedKey, ConfigConst.RSA_KEY_LENGTH);
	}

	/**
	 * 
	 * generateKeyPair:生成密钥对. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:42:37 <br>
	 * @param seedKey 种子
	 * @param keysize 秘钥长度
	 * @return
	 * @throws Exception
	 */
	public static KeyPair generateKeyPair(String seedKey, int keysize)
			throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", pro);
		kpg.initialize(keysize, new SecureRandom(seedKey.getBytes()));
		KeyPair kp = kpg.generateKeyPair();
		return kp;
	}

	/**
	 * 
	 * encodeBase64PublicKey:将publicKey转换成Base64以进行保存. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:47:29 <br>
	 * @param publicKey
	 * @return
	 */
	public static String encodeBase64PublicKey(PublicKey publicKey) {
		String encode = Base64Coder.encodBase64String(publicKey.getEncoded());
		return encode;
	}

	/**
	 * 
	 * encodeBase64PrivateKey:将publicKey转换成Base64以进行保存. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:50:39 <br>
	 * @param privateKey
	 * @return
	 */
	public static String encodeBase64PrivateKey(PrivateKey privateKey) {
		String encode = Base64Coder.encodBase64String(privateKey.getEncoded());
		return encode;
	}

	/**
	 * 根据Base64编码的公钥值生成公钥对象
	 * <p>
	 * 测试时使用，可以用于从证书文件中的公钥生成公钥对象。如果不涉及到证书操作，可以忽略该方法。
	 */
	public static PublicKey getPublicRSAKey(String key) throws Exception {
		X509EncodedKeySpec x509 = new X509EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePublic(x509);
	}

	/**
	 * 根据Base64编码的私钥值生成私钥对象
	 * <p>
	 * 测试时使用，可以用于从证书文件中的私钥生成私钥对象。如果不涉及到证书操作，可以忽略该方法。
	 */
	public static PrivateKey getPrivateRSAKey(String key) throws Exception {
		PKCS8EncodedKeySpec pkgs8 = new PKCS8EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePrivate(pkgs8);
	}

	/**
	 * 
	 * encrypt:公钥加密. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:55:18 <br>
	 * @param input 待加密内容
	 * @param publicKey 公钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(String input, PublicKey publicKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] re = cipher.doFinal(input.getBytes(charSet));
		return re;
	}

	/**
	 * 
	 * decrypt:私钥解密. <br>
	 * 
	 * @author xiezbmf
	 * @Date 2017年6月29日上午9:55:45 <br>
	 * @param encrypted 加密后的字节码
	 * @param privateKey 私钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encrypted, PrivateKey privateKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] re = cipher.doFinal(encrypted);
		return re;
	}

}
