package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Sys_Fuction;
import com.service.FunctionService;
import com.service.Sys_FuctionService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/fuction")
public class Sys_FuctionController {
	@Autowired
	Sys_FuctionService fuctionService;
	@RequestMapping("/login")
	public String login() {
		return "common/login";
	}
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		List<Sys_Fuction> allSys_Fuction = fuctionService.getAllSys_Fuction();
			String json=JsonUtils.objectToJson(allSys_Fuction);
			request.setAttribute("allper", json);
			return "admin/UserRightsManagement";
	}
	@RequestMapping("/updataSys_Function")
	public String updataSys_Function(Sys_Fuction fuction) {
		fuctionService.updateSys_Fuction(fuction);
		return "redirect:/admin/fuction/list";
	}
	
	@RequestMapping("/insertSys_Function")
	public String insertSys_Function(Sys_Fuction fuction) {
		fuctionService.insertSys_Function(fuction);
		return "redirect:/admin/fuction/list";
	}
	@ResponseBody
	@RequestMapping("/daleteSys_Function")
	public List<Sys_Fuction> daleteSys_Function(int id) {
		List<Sys_Fuction> sys_FunctionByPid = fuctionService.getSys_FunctionByPid(id);
		return sys_FunctionByPid;
	}
	@RequestMapping("/updateSys_Function")
	public String updateSys_Function(Sys_Fuction fuction) {
		fuctionService.updateSys_Fuction(fuction);
		return "redirect:/admin/fuction/list";
	}
	//·â×°Map
	private Map init(HttpServletRequest request){
		Map map=new HashMap<>();
		
		return map;
	}
}