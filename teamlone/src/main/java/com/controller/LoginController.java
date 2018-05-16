package com.controller;

import java.util.Date;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Users;
import com.service.UserServiceImpl;
import com.util.MD5Utils;
import com.util.Result;

@Controller
public class LoginController {
	@Autowired
	private UserServiceImpl userServiceImpl;


	private static final String getKopintHtml = "/web/course/videocode";
	// 前台登录
	@RequestMapping("/front/login")
	@ResponseBody
	public Result frontLogin(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {
		String userName = request.getParameter("account");
		String pwd = request.getParameter("password");
		Result result = new Result();
		if (pwd == null && "".equals(pwd)) {
			result.setMessage("");
			result.setSuccess(false);
			return result;
		}
		pwd = MD5Utils.md5(pwd);
		String ipForget = request.getParameter("ipForget");
		Users edu_User = userServiceImpl.getPwd(userName);
		//		判断用户是否冻结状态   判断密码是否正确
		if (edu_User.getPassword().equals(pwd)) {
			if (edu_User.getIs_avalible()==0) {
				return new Result(false, "此账号已被冻结", null);
			}else {
			result.setMessage("");
			result.setSuccess(true);
			session.setAttribute("login_success", edu_User);
		
			return new Result(true, null, null);
			}
		}
		return result;
	
	}

	//	注册
	@RequestMapping("/front/uc/createuser")
	@ResponseBody
	public Result createUser(HttpServletRequest request) {
		Users user = new Users();		
		String email = request.getParameter("user.email");
		Users users=userServiceImpl.getPwd(email);
		if (users==null) {
			user.setPic_img("/images/yangfan.jpg");
			user.setUser_name("yangfan");
			user.setIs_avalible(1);
			user.setLast_system_time(new Date());
			user.setEmail(email);
			user.setPassword(MD5Utils.md5(request.getParameter("user.password")));
			user.setMobile(request.getParameter("user.mobile"));
			userServiceImpl.addUser(user);
			return new Result(true, null, null);
		}else {
			return new Result(false, null, null);
		}

	}
	//  验证是否登录
	@RequestMapping("/front/uc/getloginUser")
	@ResponseBody
	public Result getLogin(HttpSession session){
		Users user=(Users)session.getAttribute("login_success");
		Result result=new Result();
		result.setSuccess(true);
		result.setEntity(user);
		return result;
	}
	//	学员退出登录
	@RequestMapping("/front/uc/exit")
	@ResponseBody
	public Result exit(HttpSession session){
		session.removeAttribute("login_success");
		session.invalidate();
		Result result=new Result();
		result.setSuccess(true);
		return result;
	}

}
