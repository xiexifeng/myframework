/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserComponent.java <br>
 * Package Name:org.myframework.system.component.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:33:22 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.power;

import org.myframework.common.exception.DataException;
import org.myframework.system.model.power.SysUser;

/**
 * ClassName: SysUserComponent <br>
 * Description: 系统用户数据操作组件接口
 * @author xiezbmf
 * @Date 2017年7月11日下午3:33:22 <br>
 * @version
 * @since JDK 1.6
 */
public interface SysUserComponent {
	/**
	 * 
	 * saveSysUserInfo:保存用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年6月22日下午12:22:46 <br>
	 * @param sysUser
	 * @throws DataException
	 */
	void saveSysUserInfo(SysUser sysUser) throws DataException;
	
	/**
	 * 
	 * querySysUserByAccount:查询用户信息通过用户账户. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年6月22日下午12:23:08 <br>
	 * @param userAccount
	 * @return
	 */
	SysUser querySysUserByAccount(String userAccount);
	
	/**
	 * 
	 * querySysUserById:根据用户主键查询用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年6月22日下午12:23:26 <br>
	 * @param userId
	 * @return
	 */
	SysUser querySysUserById(String userId);
	
	/**
	 * 
	 * querySysUserByAuth:根据认真信息查询用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年6月22日下午12:23:39 <br>
	 * @param userAccount
	 * @param accPwd
	 * @return
	 */
	SysUser querySysUserByAuth(String userAccount,String accPwd);
}

	