/**
 * Project Name:org.myframework.system <br>
 * File Name:UserService.java <br>
 * Package Name:org.myframework.system.service.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午4:51:54 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.service.power;

import org.myframework.common.base.BasicServiceModel;
import org.myframework.common.base.ServiceParam;
import org.myframework.common.exception.BusinessException;
import org.myframework.system.model.power.SysUser;

/**
 * ClassName: UserService <br>
 * Description: 用户服务接口
 * @author xiezbmf
 * @Date 2017年7月11日下午4:51:54 <br>
 * @version
 * @since JDK 1.6
 */
public interface UserService {

	BasicServiceModel addUser(SysUser sysUser,ServiceParam sp) throws BusinessException;
	
}

	