package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Role_Fuction;
import com.bean.Sys_Fuction;
import com.bean.Sys_Role;
import com.service.Role_FuctionService;
import com.service.Sys_FuctionService;
import com.service.Sys_RoleService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/RoleManagement")
public class RightsManagementController {
	@Autowired
	Sys_FuctionService functionService;
	@Autowired
	Role_FuctionService role_FuctionService;
	@Autowired
	Sys_RoleService roleService;
	@RequestMapping("/list")
	public String list(int id,HttpServletRequest request) {
		List<Sys_Fuction> allSys_Fuction = functionService.getAllSys_Fuction();
		if (id==0) {
			id=1;
		}
		List<Role_Fuction> allRole_FuctionByID = role_FuctionService.getAllRole_FuctionByID(id);
		for (Sys_Fuction sys_Fuction : allSys_Fuction) {
			for (Role_Fuction role_Fuction : allRole_FuctionByID) {
				if (sys_Fuction.getId()==role_Fuction.getFunction_id()) {
					sys_Fuction.setChecked("true");
				}
			}
		}
	
		String json=JsonUtils.objectToJson(allSys_Fuction);
		List<Sys_Role> allSys_Role = roleService.getAllSys_Role();
		request.setAttribute("id", id);
		request.setAttribute("allRole", allSys_Role);
		request.setAttribute("allper", json);
		return "admin/RightsManagement";
	}
	@RequestMapping("/insertRole_Function")
	public String insertRole_Function(int id,String str,HttpServletRequest request) {
		role_FuctionService.insertRole_function(id, str);
		return "redirect:/admin/RoleManagement/list?id="+id;
	}

}
