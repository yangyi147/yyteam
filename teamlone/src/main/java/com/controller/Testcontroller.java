package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class Testcontroller {
	
	@RequestMapping("ss")
	public String  sd() {
		
		return "web/header";
	}
	

}
