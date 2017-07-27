/**
 * Project Name:org.myframework.web <br>
 * File Name:LoginController.java <br>
 * Package Name:org.myframework.web.controller <br>
 * @author xiezbmf
 * Date:2017年7月20日上午11:08:00 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package org.myframework.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myframework.common.base.BasicServiceModel;
import org.myframework.common.constant.ReqStatusConst;
import org.myframework.common.log.CommonLogger;
import org.myframework.common.log.Log;
import org.myframework.common.tool.NetHelper;
import org.myframework.system.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: LoginController <br>
 * Description: TODO
 * 
 * @author xiezbmf
 * @Date 2017年7月20日上午11:08:00 <br>
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping("/")
public class LoginController {

	private Log logger = CommonLogger.getInstance();
	@Autowired
	LoginService loginService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request) {
		String userAccount = request.getParameter("userAccount");
		String accPwd = request.getParameter("accPwd");
		String loginIp = NetHelper.getIpAddr(request);
		String loginClient = request.getHeader("User-Agent");
		loginClient = loginClient.substring(0,100);
		BasicServiceModel bsm = loginService.login(userAccount, accPwd,
				loginIp, loginClient);
		ModelAndView mv = new ModelAndView();
		if (ReqStatusConst.OK.equals(bsm.getCode())) {
			mv.setViewName("main");
			try {
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
						userAccount, accPwd);
				// 调用loadUserByUsername设置权限信息
				Authentication authentication = authenticationManager.authenticate(authRequest);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				HttpSession session = request.getSession();
	            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); 
				logger.info("恭喜用户  " + userAccount + " 登录成功。");
			} catch (Exception e) {

			}
		} else {
			mv.setViewName("loginErr");
		}
		return mv;
	}

	@RequestMapping(value = "/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		// clear();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/main.do")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value = "/showMenu.do")
	public ModelAndView showMenu(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showMenu");
		return mv;
	}
	
	@RequestMapping(value = "/user.do")
	public ModelAndView user(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	
	@RequestMapping(value = "/admin.do")
	public ModelAndView admin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
}
