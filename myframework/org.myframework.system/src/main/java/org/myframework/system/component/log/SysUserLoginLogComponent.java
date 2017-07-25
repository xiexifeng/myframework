/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserLoginLogComponent.java <br>
 * Package Name:org.myframework.system.component.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:56:51 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.log;

import org.myframework.common.exception.DataException;

/**
 * ClassName: SysUserLoginLogComponent <br>
 * Description: 系统用户登录日志组件接口
 * @author xiezbmf
 * @Date 2017年7月11日下午3:56:51 <br>
 * @version
 * @since JDK 1.6
 */
public interface SysUserLoginLogComponent {

	/**
	 * 
	 * saveSysUserLoginSucLog:登录成功日志. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日下午4:13:40 <br>
	 * @param userId
	 * @param loginIp
	 * @param loginClient
	 * @throws DataException
	 */
	void saveSysUserLoginSucLog(String userId,String loginIp,String loginClient) throws DataException;
	
	/**
	 * 
	 * saveSysUserLoginLog:保存用户登录日志. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日下午4:13:49 <br>
	 * @param userId
	 * @param loginIp
	 * @param loginClient
	 * @param loginRes
	 * @throws DataException
	 */
	void saveSysUserLoginLog(String userId,String loginIp,String loginClient,String loginRes) throws DataException;
}

	