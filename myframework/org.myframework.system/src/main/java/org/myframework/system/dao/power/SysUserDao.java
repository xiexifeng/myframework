/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserDao.java <br>
 * Package Name:org.myframework.system.dao.power <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:39:05 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.power;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.power.SysUser;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysUserDao <br>
 * Description: 系统用户表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日上午9:39:05 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysUserDao")
public interface SysUserDao {
	/**
	 * 
	 * saveSysUser:保存用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午9:55:52 <br>
	 * @param sysUser
	 * @return
	 */
	int saveSysUser(SysUser sysUser);
	
	/**
	 * 
	 * deleteSysUserById:删除用户信息通过id. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午9:56:03 <br>
	 * @param userId
	 * @return
	 */
	int deleteSysUserById(@Param("userId")String userId);
	
	/**
	 * 
	 * updateSysUserById:更新用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午9:56:16 <br>
	 * @param sysUser
	 * @return
	 */
	int updateSysUserById(SysUser sysUser);
	
	/**
	 * 
	 * querySysUserByParams:查询用户信息. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午9:56:27 <br>
	 * @param params
	 * @return
	 */
	List<SysUser> querySysUserByParams(Map<String,String> params);
}

	