package com.controller;

import java.util.List;

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
	@RequestMapping("/login")
	public String login(Sys_User user,HttpSession session) {
		UsernamePasswordToken token=new UsernamePasswordToken(user.getLogin_name(),user.getLogin_pwd());
		Sys_User userByName = userService.getUserByName(user.getLogin_name());
		session.setAttribute("userByName", userByName.getUser_id());
		Subject subject=SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			try {
				subject.login(token);
			} catch (Exception e) {
				e.printStackTrace();
				return "common/login";
			}
		}
		return "redirect:/admin/login/home";
	}
	@RequestMapping("/home")
	public String home(HttpSession session) {
		List<Sys_Fuction> allFuctionByUserID = fuctionService.getAllFuctionByUserID((int)session.getAttribute("userByName"));
		session.setAttribute("allFuctionByUserID", allFuctionByUserID);
		return "admin/index";
	}
	
}
