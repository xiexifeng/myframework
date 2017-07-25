/**
 * Project Name:org.myframework.system <br>
 * File Name:SysOperateLogComponent.java <br>
 * Package Name:org.myframework.system.component.log <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:59:38 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.component.log;

import org.myframework.common.exception.DataException;
import org.myframework.system.model.log.SysOperateLog;

/**
 * ClassName: SysOperateLogComponent <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日下午4:59:38 <br>
 * @version
 * @since JDK 1.6
 */
public interface SysOperateLogComponent {

	void saveOperateLog(SysOperateLog sysOperateLog) throws DataException;
}

	