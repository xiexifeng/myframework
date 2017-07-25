/**
 * Project Name:org.myframework.web <br>
 * File Name:MyFilterSecurotyInterceptor.java <br>
 * Package Name:org.myframework.web.security <br>
 * @author xiezbmf
 * Date:2017年7月10日上午9:51:22 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * ClassName: MyFilterSecurotyInterceptor <br>
 * Description: TODO
 * @author xiezbmf
 * @Date 2017年7月10日上午9:51:22 <br>
 * @version
 * @since JDK 1.6
 */
public class MyFilterSecurotyInterceptor  extends AbstractSecurityInterceptor implements Filter{
private FilterInvocationSecurityMetadataSource securityMetadataSource;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        FilterInvocation fi = new FilterInvocation(request, response,chain);
        invoke(fi);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Class<?> getSecureObjectClass() {
        // TODO Auto-generated method stub
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        // TODO Auto-generated method stub
        return this.securityMetadataSource;
    }

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return securityMetadataSource;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

    public void invoke(FilterInvocation fi) throws IOException
        ,ServletException{
        
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            super.afterInvocation(token, null);
        }
    }
}

	