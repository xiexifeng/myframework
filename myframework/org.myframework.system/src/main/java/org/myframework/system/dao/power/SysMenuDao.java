/**
 * Project Name:org.myframework.system <br>
 * File Name:SysMenuDao.java <br>
 * Package Name:org.myframework.system.dao.power <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:42:18 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.dao.power;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.myframework.system.model.power.SysMenu;
import org.springframework.stereotype.Repository;

/**
 * ClassName: SysMenuDao <br>
 * Description: 系统菜单表操作接口
 * @author xiezbmf
 * @Date 2017年7月11日上午9:42:18 <br>
 * @version
 * @since JDK 1.6
 */
@Repository("sysMenuDao")
public interface SysMenuDao {
	
	/**
	 * saveSysMenu:保存菜单. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:45 <br>
	 * @param sysMenu
	 * @return
	 */
	int saveSysMenu(SysMenu sysMenu);
	
	/**
	 * deleteSysMenuById:删除菜单. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:23:57 <br>
	 * @param menuId
	 * @return
	 */
	int deleteSysMenuById(@Param("menuId")String menuId);
	
	/**
	 * updateSysMenuById:更新菜单. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:24:05 <br>
	 * @param sysMenu
	 * @return
	 */
	int updateSysMenuById(SysMenu sysMenu);
	
	/**
	 * querySysMenuByParams:查询菜单. <br>
	 *
	 * @author xiezbmf
	 * @Date 2017年7月11日上午10:24:13 <br>
	 * @param params
	 * @return
	 */
	List<SysMenu> querySysMenuByParams(Map<String,String> params);
}

	