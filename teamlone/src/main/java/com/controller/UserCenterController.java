package com.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.QuestionsWeb;
import com.bean.Questions_comment;
import com.bean.Users;
import com.service.QuestionsWebService;
import com.service.Questions_commentService;

@Controller
@RequestMapping("/uc")
public class UserCenterController {
	@Autowired
	private QuestionsWebService  questionsWebService;
	@Autowired
	private Questions_commentService  questions_commentService;
	@RequestMapping("/index")
	public String index(){
		return "web/ucenter/uc_freecourse";
	}
	@RequestMapping("myquestions/list")
	public ModelAndView getlistAll(HttpSession session){
		Map map=new HashMap<>();
		Users edu_user=(Users)session.getAttribute("login_success");
		map.put("uid", edu_user.getUser_id());
		List<QuestionsWeb>  qc=questionsWebService.getlistAll(map);
		ModelAndView md=new ModelAndView();
		md.addObject("questionsList", qc);
		md.setViewName("/web/ucenter/questions-mylist");
		return md;
	}
	@RequestMapping("/myrepquestions/list")
	public ModelAndView getquesioncomment(HttpSession session){
		Users edu_user=(Users)session.getAttribute("login_success");
		Map map=new HashMap<>();
		map.put("uid", edu_user.getUser_id());
		List<QuestionsWeb>  qc=questionsWebService.getlistAll(map);
	    System.out.println(qc);
		ModelAndView md= new ModelAndView();
		md.addObject("questionsList", qc);
		md.setViewName("/web/ucenter/questions-myreplist");
		return md;
	}
}
