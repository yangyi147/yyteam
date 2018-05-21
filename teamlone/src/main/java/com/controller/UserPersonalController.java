package com.controller;

import javax.servlet.http.HttpServletRequest;
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
public class UserPersonalController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping("/uc/initUpdateUser/0")
	public String initUpdateUser(Model model) {

		model.addAttribute("index", 0);
		return "/web/ucenter/user-info";	
	}
	@RequestMapping("/uc/initUpdateUser/1")
	public String initUpdateUser1(Model model) {
		model.addAttribute("index", 1);
		return "/web/ucenter/user-info";	
	}
	@RequestMapping("/uc/initUpdateUser/2")
	public String initUpdateUser2(Model model) {
		model.addAttribute("index", 2);
		return "/web/ucenter/user-info";	
	}
	@RequestMapping("/uc/updatePwd")
	@ResponseBody
	public Result updatePwd(HttpServletRequest request,HttpSession session) {
		Result result = new Result();
//		拿到数据库的密码
		Users users1=(Users) session.getAttribute("login_success");
		String password=users1.getPassword();	
//		新密码
		String newPassword =request.getParameter("newPassword");
//		用户iD
		String userId =request.getParameter("userId");
//		旧密码
		String nowPassword =request.getParameter("nowPassword");
		nowPassword = MD5Utils.md5(nowPassword);
//		再次输入密码
	 	String confirmPwd = request.getParameter("confirmPwd");
//	 	与以前的密码判断
          if (password.equals(nowPassword)) {
//       判断两次密码是否一致
			if (newPassword.equals(confirmPwd)) {
				  Users users = new Users();
				   users.setPassword(MD5Utils.md5(confirmPwd));
				   users.setUser_id(Integer.valueOf(userId));
				   userServiceImpl.update(users);
				   return new Result(true, "yes！", null);
			}else {
				return new Result(false, "no！", null);
			}
		}else {
			return new Result(false, "nos！", null);
		}
		

	}
	
	@RequestMapping("/uc/updateUser")
	 public Result updateUser(Users users ,HttpSession session) {
		Users loginUser = (Users) session.getAttribute("login_success");
		loginUser.setUser_id(loginUser.getUser_id());
        userServiceImpl.updateAll(users);
		Users byId = userServiceImpl.getById(loginUser.getUser_id());
		session.setAttribute("login_success", byId);
		return new Result(true, "yes！", null);
		
	}
	
}
