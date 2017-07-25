/**
 * Project Name:org.myframework.web <br>
 * File Name:PassCardAuthenticationToken.java <br>
 * Package Name:org.myframework.web.security.third <br>
 * @author xiezbmf
 * Date:2017年7月21日下午5:36:42 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security.third;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * ClassName: PassCardAuthenticationToken <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月21日下午5:36:42 <br>
 * @version
 * @since JDK 1.6
 */
public class PassCardAuthenticationToken extends AbstractAuthenticationToken {
	
	private String accPwd;
	private String userAccount;
	private String errCode;
	private boolean isEnablePasscard;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = -6756227128303523396L;

	public PassCardAuthenticationToken(){
		super(null);
	}
	
	public PassCardAuthenticationToken(
			Collection<? extends GrantedAuthority> authorities) {
		
			super(authorities);
	}

	@Override
	public Object getCredentials() {

		return accPwd;  
	}

	@Override
	public Object getPrincipal() {

		// TODO Auto-generated method stub
		return userAccount;
	}

	public String getAccPwd() {
		return accPwd;
	}

	public void setAccPwd(String accPwd) {
		this.accPwd = accPwd;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public boolean isEnablePasscard() {
		return isEnablePasscard;
	}

	public void setEnablePasscard(boolean isEnablePasscard) {
		this.isEnablePasscard = isEnablePasscard;
	}

}

	