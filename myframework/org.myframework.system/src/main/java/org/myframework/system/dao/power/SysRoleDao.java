/**
 * Project Name:org.myframework.system <br>
 * File Name:SysRoleDao.java <br>
 * Package Name:org.myframework.system.dao.power <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:42:45 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.power;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.power.SysRole;
import org.springframework.stereotype.Repository;
/**
 * ClassName: SysRoleDao <br>
 * Description: 系统角色表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日上午9:42:45 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysRoleDao")
public interface SysRoleDao {
	
	/**
	 * saveSysRole:保存用户角色. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:02 <br>
	 * @param sysRole
	 * @return
	 */
	int saveSysRole(SysRole sysRole);
	
	/**
	 * deleteSysRoleById:删除用户角色. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:13 <br>
	 * @param roleId
	 * @return
	 */
	int deleteSysRoleById(@Param("roleId")String roleId);
	
	/**
	 * updateSysRoleById:更新用户角色. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:24 <br>
	 * @param sysRole
	 * @return
	 */
	int updateSysRoleById(SysRole sysRole);
	
	/**
	 * querySysRoleByParams:查询用户角色. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:33 <br>
	 * @param params
	 * @return
	 */
	List<SysRole> querySysRoleByParams(Map<String,String> params);
}

	