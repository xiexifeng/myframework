/**
 * Project Name:org.myframework.system <br>
 * File Name:SysOperateLogComponentImpl.java <br>
 * Package Name:org.myframework.system.component.log.impl <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:59:49 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.log.impl;

import java.util.Date;

import org.myframework.common.exception.DataException;
import org.myframework.common.util.AssertUtil;
import org.myframework.common.util.StringUtil;
import org.myframework.system.component.log.SysOperateLogComponent;
import org.myframework.system.dao.log.SysOperateLogDao;
import org.myframework.system.model.log.SysOperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: SysOperateLogComponentImpl <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午4:59:49 <br>
 * @version
 * @since JDK 1.6
 */
@Component("sysOperateLogComponent")
public class SysOperateLogComponentImpl implements SysOperateLogComponent {
	@Autowired
	SysOperateLogDao sysOperateLogDao;
	@Override
	public void saveOperateLog(SysOperateLog sysOperateLog) throws DataException{
		
		AssertUtil.notNull(sysOperateLog);
		sysOperateLog.setCreateTime(new Date());
		sysOperateLog.setOperateLogId(StringUtil.getUUID32());
		int saveNum = sysOperateLogDao.saveSysOperateLog(sysOperateLog);
		if(saveNum!=1){
			throw new DataException();
		}
	}

}

	