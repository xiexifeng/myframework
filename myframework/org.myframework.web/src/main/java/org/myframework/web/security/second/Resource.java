/**
 * Project Name:org.myframework.web <br>
 * File Name:Resource.java <br>
 * Package Name:org.myframework.web.security.second <br>
 * @author xiezbmf
 * Date:2017年7月21日上午9:38:56 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.second;

import java.util.Set;

/**
 * ClassName: Resource <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日上午9:38:56 <br>
 * @version
 * @since JDK 1.6
 */
public class Resource {
	private String resId;
	private String resName;
	private String resUrl;
	private String type;
	private Set<Role> roles;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}

	