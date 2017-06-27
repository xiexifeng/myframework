/**
 * Project Name:org.myframework.common <br>
 * File Name:LocalConfig.java <br>
 * Package Name:org.myframework.common.config <br>
 * @author xiezbmf
 * Date:2017年6月27日下午3:13:19 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.common.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;


/**
 * ClassName: LocalConfig <br>
 * Description: 获取配置类
 * @author xiezbmf
 * @Date 2017年6月27日下午3:13:19 <br>
 * @version
 * @since JDK 1.6
 */
public class LocalConfig {
	private static final Log logger = CommonLogger.getInstance();
	public static String CONFIG_PATH ;
	
	static{
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(LocalConfig.class.getResource("/local.properties").getPath()));
		} catch (FileNotFoundException e) {
			logger.error("local.properties fileNotFound ,system will exit");
			System.exit(-1);
		} catch (IOException e) {
			logger.error("read local.properties file error, system will exit");
			System.exit(-1);
		}
		CONFIG_PATH = pro.getProperty("config.path");
	}
}

	