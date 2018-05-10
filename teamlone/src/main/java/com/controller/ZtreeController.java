package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Function;
import com.service.FunctionService;

@Controller
public class ZtreeController {
	
	@Autowired 
	private FunctionService functionService;
	@RequestMapping("/admin/getZtree")
	public ModelAndView getlistZtree(){
		ModelAndView md=new ModelAndView();
		List<Function> ft=functionService.getListAll();
		md.addObject("ft", ft);
		md.setViewName("admin/index");
		return md;
	}
	

}
