package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Sys_User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.service.Sys_UserService;

@Controller
@RequestMapping("/admin/user")
public class Sys_UserConterller {
	@Autowired
	Sys_UserService userService;
	@RequestMapping("/list")
	public String list(@RequestParam(name="page",defaultValue="0")int page,HttpServletRequest request) {
		Map map=init(request);
		PageInfo<Sys_User> allUser = userService.getAllUser(map,page);
			request.setAttribute("allUser", allUser);
		return "/admin/listUser";
	}
	
	private Map init (HttpServletRequest request){
		Map map=new HashMap<>();
		return map;
	}

}
