/**
 * Project Name:org.myframework.system <br>
 * File Name:BasicJunit.java <br>
 * Package Name:org.myframework.system.test <br>
 * @author xiezbmf
 * Date:2017年7月11日上午9:11:20 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.system.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.myframework.common.util.StringUtil;
import org.myframework.system.dao.power.SysMenuDao;
import org.myframework.system.dao.power.SysRoleDao;
import org.myframework.system.model.power.SysMenu;
import org.myframework.system.model.power.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * ClassName: BasicJunit <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月11日上午9:11:20 <br>
 * @version
 * @since JDK 1.6
 */
@TransactionConfiguration(transactionManager = "tm_mycat", defaultRollback = false)
@ContextConfiguration(locations = {
        "classpath*:xml/system.xml"})
public class BasicJunit extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Test
	public void testHello(){
		System.out.println("hello test");
	}
	
	@Test
	public void testSaveSysRole(){
		SysRole role = new SysRole();
		String roleId = StringUtil.getUUID32();
		role.setRoleId(roleId);
		role.setEnable(true);
		role.setRoleName("test");
		role.setRoleDesc("desc");
		role.setCreateTime(new Date());
		role.setRemark("remark");
		role.setUpdateTime(new Date());
		int i = sysRoleDao.saveSysRole(role);
		Assert.assertTrue(i==1);
		Map<String,String> params = new HashMap<String,String>();
		params.put("roleId", roleId);
		role = sysRoleDao.querySysRoleByParams(params).get(0);
		logger.info(role);
	}

	@Override
	public void setDataSource(DataSource dataSource_mycat) {
			super.setDataSource(dataSource_mycat);
	}
	
	@Test
	public void testSaveSysMenu(){
		SysMenu menu = new SysMenu();
		String menuId = StringUtil.getUUID32();
		menu.setMenuId(menuId);
		menu.setMenuCode("C_001");
		menu.setMenuName("菜单1");
		menu.setMenuOrder(1);
		menu.setMenuType("A");
		menu.setMenuUrl("/ddd/dd.do");
		menu.setCreateTime(new Date());
		menu.setRemark("remark");
		menu.setUpdateTime(new Date());
		int i = sysMenuDao.saveSysMenu(menu);
		Assert.assertTrue(i==1);
		Map<String,String> params = new HashMap<String,String>();
		params.put("menuId", menuId);
		menu = sysMenuDao.querySysMenuByParams(params).get(0);
		logger.info(menu);
	}
}

	