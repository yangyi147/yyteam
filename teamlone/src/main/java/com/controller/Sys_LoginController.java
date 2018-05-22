package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Sys_Fuction;
import com.bean.Sys_User;
import com.service.Sys_FuctionService;
import com.service.Sys_UserService;
@Controller
@RequestMapping("/admin/login")
public class Sys_LoginController {

	@Autowired
	Sys_UserService userService;
	@Autowired
	Sys_FuctionService fuctionService;
	@Autowired
	Sys_User user;
	@RequestMapping("/login")
	public String login(Sys_User user,HttpSession session) {
		UsernamePasswordToken token=new UsernamePasswordToken(user.getLogin_name(),user.getLogin_pwd());
		Sys_User userByName = userService.getUserByName(user.getLogin_name());
		if(userByName!=null){
			session.setAttribute("userByName", userByName.getUser_id());
		}
		Subject subject=SecurityUtils.getSubject();
		System.out.println("token.getUsername():"+token.getUsername()+",token.getPassword():"+token.getPassword());
		if (!subject.isAuthenticated()) {
			try {
				subject.login(token);
			} catch (Exception e) {
				return "/common/login";
			}
		}
		return "redirect:/admin/login/home";
	}
	@RequestMapping("/home")
	public String home(HttpSession session,HttpServletRequest request) {
		List<Sys_Fuction> allFuctionByUserID = fuctionService.getAllFuctionByUserID((int)session.getAttribute("userByName"));
		session.setAttribute("allFuctionByUserID", allFuctionByUserID);
		String ipAddr = getIpAddr(request);
		user.setLast_login_ip(ipAddr);
		user.setLast_login_time(new Date());
		user.setUser_id((int)session.getAttribute("userByName"));
		userService.updateUserIpTime(user);
		return "admin/index";
	}

	public static String getIpAddr(HttpServletRequest request) {     
	 /*    String ip = request.getHeader("x-forwarded-for");     
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	         ip = request.getHeader("Proxy-Client-IP");     
	     }     
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	         ip = request.getHeader("WL-Proxy-Client-IP");     
	      }     
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	          ip = request.getRemoteAddr();     
	     }     
	     return ip;   */  
		 if (request.getHeader("x-forwarded-for") == null) {  
		        return request.getRemoteAddr();  
		    }  
		    return request.getHeader("x-forwarded-for");  
	} 
	
}
