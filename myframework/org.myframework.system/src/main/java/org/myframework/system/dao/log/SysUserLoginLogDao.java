/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserLoginLogDao.java <br>
 * Package Name:org.myframework.system.dao.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:03:27 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.log;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.log.SysUserLoginLog;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysUserLoginLogDao <br>
 * Description: 系统用户登录表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日下午3:03:27 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysUserLoginLogDao")
public interface SysUserLoginLogDao {
	int saveSysUserLoginLog(SysUserLoginLog sysUserLoginLog);
	
	int deleteSysUserLoginLogById(@Param("userLoginLogId")String userLoginLogId);
	
	List<SysUserLoginLog> querySysUserLoginLogByParams(Map<String,String> params);
}

	