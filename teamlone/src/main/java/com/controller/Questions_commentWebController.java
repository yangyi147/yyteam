package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Questions;
import com.bean.Questions_comment;
import com.bean.Questions_tag;
import com.service.QuestionsService;
import com.service.Questions_commentService;
import com.service.Questions_tagService;
@Controller
@RequestMapping("/front")
public class Questions_commentWebController {
	@Autowired
	private Questions_commentService questions_commentService;
	@Autowired
	private QuestionsService  questionsService;
	@Autowired
	private Questions_tagService questions_tagService;
	@RequestMapping("/Questionslist")
	public ModelAndView listQuestionList(HttpServletRequest request){
		Map map=initMap(request);
		List<Questions_comment>  qc=questions_commentService.getlistAll(map);
		ModelAndView md=new ModelAndView();
		List<Questions_tag> qt=questions_tagService.getlistAll();
		md.addObject("questionsTagList", qt);
		md.addObject("questionsList", qc);
		md.setViewName("/web/questions/questions-list");
		return md;
	}
	
	private Map initMap(HttpServletRequest request) {
		String orderFalg = request.getParameter("questions.orderFalg");
		String type = request.getParameter("questions.type");
		String status = request.getParameter("questions.status");
		String questionsTagId = request.getParameter("questions.questionsTagId");
		System.out.println("orderFalg"+orderFalg);
		System.out.println("type"+type);
		System.out.println("status"+status);
		System.out.println("questionsTagId"+questionsTagId);
		Map map =new HashMap<>();
		map.put("orderFalg", orderFalg);
		map.put("type", type);
		map.put("status", status);
		map.put("questionsTagId", questionsTagId);
		return map;
	}
	
	@RequestMapping("/questions/info/{id}")
	public ModelAndView questionsinfo( @PathVariable("id")int id){
	System.out.println(id);
	if (id<0) {
		id=-1;
	}
	  Map map=new HashMap<>();
	       map.put("qid", id);
		ModelAndView  md=new ModelAndView();
	     Questions ai= questionsService.getById(id);
		 List<Questions_comment>   qc=  questions_commentService.getlistAll(map);
		md.addObject("questions", qc);
		md.addObject("qt", ai);
		md.setViewName("/web/questions/questions-info");
		return md;
	}
	
	@RequestMapping("/questionscomment/ajax/list")
	public ModelAndView  questions_coment(HttpServletRequest re){
	int id=Integer.parseInt(re.getParameter("questionsComment.questionId"));
		  Map map=new HashMap<>();
		       map.put("qid", id);
		       ModelAndView  md=new ModelAndView();
		 List<Questions_comment>   qc=  questions_commentService.getlistAll(map);
			md.addObject("ec", qc);
			md.setViewName("/web/comment/comment");
		return md;
	}	

	
}
