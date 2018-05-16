package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uc")
public class UserCenterController {
	@RequestMapping("/index")
	public String index(){
		
		
		
		
		return "web/ucenter/uc_freecourse";
	}
}
