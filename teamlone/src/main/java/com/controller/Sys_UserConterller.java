package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Sys_Role;
import com.bean.Sys_User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.service.Sys_RoleService;
import com.service.Sys_UserService;

@Controller
@RequestMapping("/admin/user")
public class Sys_UserConterller {
	@Autowired
	Sys_UserService userService;
	@Autowired
	Sys_RoleService roleService;
	@RequestMapping("/list")
	public String list(@RequestParam(name="page",defaultValue="0")int page,HttpServletRequest request) {
		Map map=init(request);
		PageInfo<Sys_User> allUser = userService.getAllUser(map,page);
			request.setAttribute("allUser", allUser);
		return "/admin/listUser";
	}
	
	@RequestMapping("/getUserByID/{id}")
	public String getUserByID(@PathVariable("id")int id,HttpServletRequest request) {
		Object principal = SecurityUtils.getSubject().getPrincipal();
		Sys_User userByID = userService.getUserByID(id);
		List<Sys_Role> allSys_Role = roleService.getAllSys_Role();
		if(userByID.getLogin_name().equals(principal)){
			request.setAttribute("principal", 1);
		}else{
			request.setAttribute("principal", 2);
		}
		request.setAttribute("allSys_Role", allSys_Role);
		request.setAttribute("userByID", userByID);
		return "/admin/updateUser";
	}
	@RequestMapping("/updateUser")
	public String updateUser(Sys_User user,Sys_Role role,HttpServletRequest request) {
		int updateUser = userService.updateUser(user,role);
		System.out.println("updateUser:"+updateUser);
		return "redirect:/admin/user/list";
	}
	@RequestMapping("/goToAddUser")
	public String goToAddUser(HttpServletRequest request) {
		List<Sys_Role> allSys_Role = roleService.getAllSys_Role();
		request.setAttribute("allSys_Role", allSys_Role);
		return "/admin/addUser";
	}
	@RequestMapping("/addUser")
	public String addUser(Sys_User user,Sys_Role role) {
		userService.insertUser(user, role);
		return "redirect:/admin/user/list";
	}

	private Map init (HttpServletRequest request){
		Map map=new HashMap<>();
		return map;
	}
}
