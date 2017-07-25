/**
 * Project Name:org.myframework.web <br>
 * File Name:MyPasswordEncoder.java <br>
 * Package Name:org.myframework.web.security.second <br>
 * @author xiezbmf
 * Date:2017年7月21日上午9:53:09 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.second;

import org.myframework.common.secret.digest.MD5Digest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ClassName: MyPasswordEncoder <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日上午9:53:09 <br>
 * @version
 * @since JDK 1.6
 */
public class MyPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("------------------"+rawPassword+"------------------");
		try {
			return MD5Digest.encodeMD5Hex(rawPassword.toString());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		try {
			String encodedRawPassword = MD5Digest.encodeMD5Hex(rawPassword.toString());
			System.out.println("------------------"+rawPassword+"------------------"+encodedPassword);
			if(encodedPassword.equals(encodedRawPassword)){
				return true;
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return false;
	}

}

	