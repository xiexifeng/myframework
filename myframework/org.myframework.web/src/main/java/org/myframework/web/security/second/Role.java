/**
 * Project Name:org.myframework.web <br>
 * File Name:Role.java <br>
 * Package Name:org.myframework.web.security.second <br>
 * @author xiezbmf
 * Date:2017年7月21日上午9:38:48 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.second;

import java.util.Set;

/**
 * ClassName: Role <br>
 * Description: TODO
 * 
 * @author xiezbmf
 * @Date 2017年7月21日上午9:38:48 <br>
 * @version
 * @since JDK 1.6
 */
public class Role {
	private String roleId;
	private String roleName;
	private Set<Resource> resources;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
