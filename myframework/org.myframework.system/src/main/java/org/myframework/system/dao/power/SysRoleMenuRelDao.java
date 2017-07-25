/**
 * Project Name:org.myframework.system <br>
 * File Name:SysRoleMenuRelDao.java <br>
 * Package Name:org.myframework.system.dao.power <br>
 * @author xiezbmf
 * Date:2017年7月11日下午3:21:14 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.power;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.power.SysRoleMenuRel;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysRoleMenuRelDao <br>
 * Description: 系统角色菜单关联表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日下午3:21:14 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysRoleMenuRelDao")
public interface SysRoleMenuRelDao {

	int saveSysRoleMenuRel(SysRoleMenuRel sysRoleMenuRel);
	
	int deleteSysRoleMenuRelById(@Param("roleId")String roleId,@Param("menuId")String menuId);
	
	List<SysRoleMenuRel> querySysRoleMenuRelByParams(Map<String,String> params);
}

	