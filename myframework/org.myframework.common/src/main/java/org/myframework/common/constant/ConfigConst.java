/**
 * Project Name:org.myframework.common <br>
 * File Name:ConfigConst.java <br>
 * Package Name:org.myframework.common.constant <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:13:40 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.constant;

import org.myframework.common.util.PropertiesUtil;

/**
 * ClassName: ConfigConst <br>
 * Description: 配置常量
 * 
 * @author xiezbmf
 * @Date 2017年6月27日下午3:13:40 <br>
 * @version
 * @since JDK 1.6
 */
public interface ConfigConst {
	/**
	 * DEFAULT_ENCODE:默认编码.
	 */
	String DEFAULT_ENCODE = "UTF-8";
	/**
	 * DB_PWD_ENCRTY_KEY:数据库加密key.
	 */
	String DB_PWD_ENCRTY_KEY = "Edsf2W!#333s1231sfweqbjroiyq";
	/**
	 * PWD_TYPE_CIPHER:加密类型.
	 */
	int PWD_TYPE_CIPHER = 1;

	int RSA_KEY_LENGTH = 1024;
	int AES_KEY_LENGTH = 128;
	/**
	 * ENCRYPT_BYTE_LENGTH:加密字节码长度，英文90，中文30.
	 */
	int ENCRYPT_BYTE_LENGTH = PropertiesUtil.getPropertyInt("AES.ENCRYPT.LENGTH", 90);

	/**
	 * GEN_ENCRYPT_KEY:生成加密key的key.
	 */
	String GEN_ENCRYPT_KEY = "org.myframework.";
}
