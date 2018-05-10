package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Sys_Subject;
import com.service.Sys_Subjectervice;
import com.util.JsonUtils;
@Controller
@RequestMapping("/admin/professional")
public class ProfessionalController {
	@Autowired
	Sys_Subjectervice subjectService;
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		List<Sys_Subject> allSubjict = subjectService.getAllSubjict();
		for (Sys_Subject sys_Subject : allSubjict) {
			System.out.println(sys_Subject);
		}
		String json=JsonUtils.objectToJson(allSubjict);
		System.out.println("json:"+json);
		request.setAttribute("allper", json);
		return "/admin/Professional";
	}
	@RequestMapping("/insertSubject")
	public String insertSubject(Sys_Subject subject) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(d);
		Date parse = sdf.parse(format);
		subject.setCreate_time(parse);
		subjectService.insertSubject(subject);
		return "redirect:/admin/professional/list";
	}

}
