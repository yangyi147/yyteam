package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Subjects;
import com.bean.Sys_Subject;
import com.service.SubjectsService;
import com.service.Sys_Subjectervice;
import com.util.JsonUtils;
@Controller
@RequestMapping("/admin")
public class SubjectsController {
	@Autowired  
	private Sys_Subjectervice sys_Subjectervice;
	@RequestMapping("/getSuAll")
	public ModelAndView  getlistAll(){
		ModelAndView md=new ModelAndView();
		List<Sys_Subject> su=sys_Subjectervice.getAllSubjict();
		String json=JsonUtils.objectToJson(su);
		System.out.println(json);
		md.addObject("su", json);
        md.setViewName("/admin/teacher/addteacher");		
		return md;
	}
}
