/**
 * Project Name:org.myframework.system <br>
 * File Name:SysOperateLogDao.java <br>
 * Package Name:org.myframework.system.dao.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午2:58:06 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.log;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.log.SysOperateLog;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysOperateLogDao <br>
 * Description: 系统操作日志表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日下午2:58:06 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysOperateLogDao")
public interface SysOperateLogDao {
	int saveSysOperateLog(SysOperateLog sysOperateLog);
	
	int updateSysOperateLogById(SysOperateLog sysOperateLog);
	
	int deleteSysOperateLogById(@Param("operateLogId")String operateLogId);
	
	List<SysOperateLog> querySysOperateLogByParams(Map<String,String> params);
}

	