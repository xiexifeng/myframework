/**
 * Project Name:org.myframework.system <br>
 * File Name:SysUserRoleRelDao.java <br>
 * Package Name:org.myframework.system.dao.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:27:12 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.power;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.power.SysUserRoleRel;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysUserRoleRelDao <br>
 * Description: 系统用户角色关系表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日下午3:27:12 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysUserRoleRelDao")
public interface SysUserRoleRelDao {

	int saveSysUserRoleRel(SysUserRoleRel sysUserRoleRel);
	
	int deleteSysUserRoleRelById(@Param("userId")String userId,@Param("roleId")String roleId);
	
	List<SysUserRoleRel> querySysUserRoleRelByParams(Map<String,String> params);
}

	