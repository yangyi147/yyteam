package com.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Comment;
import com.bean.Edu_article;
import com.bean.Edu_article_content;
import com.service.Edu_articleService;
import com.service.Edu_article_contentService;
import com.service.Edu_commentService;

@Controller
@RequestMapping("/front")
public class ArticleController {

	@Autowired
	private Edu_articleService eimpl;
	@Autowired
	private Edu_article_contentService eacimpl;
	@Autowired
	private Edu_commentService ecs;

	@RequestMapping("/article")
	public ModelAndView article(){
		List<Edu_article> list = eimpl.getlistAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("web/article/article-list");
		return mv;
	}
	@RequestMapping("/articleinfo/{article_id}")
	public ModelAndView getarticle(@PathVariable("article_id")int id){
		Edu_article_content eac = eacimpl.getByid(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("eac", eac);
		mv.setViewName("/web/article/article-info");
		return mv;
	}
	
	@RequestMapping("/web/comment/ajax/query")
	public ModelAndView getpinlun(int otherId){
		List<Comment> ec = ecs.getcomment(otherId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ec", ec);
		mv.setViewName("/web/comment/comment");
		return mv;
	}
	
	
	
	@RequestMapping("/web/comment/ajax/commentreply")
	public String commentreply(int otherId,int pCommentId){
		return "";
	}
	
	
	@RequestMapping("/web/comment/ajax/addcomment")
	public String addcomment(int pCommentId,String content,int type,int otherId){
		return "";
	}
	
	@RequestMapping("/web/comment/ajax/commentreplypage")
	public String commentreplypage(int otherId,int pCommentId){
		return "";
	}
}
