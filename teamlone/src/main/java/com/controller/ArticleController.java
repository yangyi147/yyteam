package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Comment;
import com.bean.Edu_article;
import com.bean.Edu_article_content;
import com.bean.Users;
import com.service.Edu_articleService;
import com.service.Edu_article_contentService;
import com.service.Edu_commentService;
import com.util.Result;

@Controller
@RequestMapping("/front")
public class ArticleController {

	@Autowired
	private Edu_articleService eimpl;
	@Autowired
	private Edu_article_contentService eacimpl;
	@Autowired
	private Edu_commentService ecs;

	
	//首页面文章列表
	@RequestMapping("/article")
	public ModelAndView article(){
		List<Edu_article> list = eimpl.getlistAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("web/article/article-list");
		return mv;
	}
	
	//文章详情页
	@RequestMapping("/articleinfo/{article_id}")
	public ModelAndView getarticle(@PathVariable("article_id")int id){
		Edu_article_content eac = eacimpl.getByid(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("eac", eac);
		mv.setViewName("/web/article/article-info");
		return mv;
	}
	
	@RequestMapping("/web/comment/ajax/query")
	@ResponseBody
	public ModelAndView comment(int otherId){
		System.out.println("otherId"+otherId);
		List<Comment> ec = ecs.getcomment(otherId);
		System.out.println("ec:////"+ec);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ec", ec);
		mv.setViewName("/web/comment/comment");
		return mv;
	}
	
	
	@RequestMapping("/web/comment/ajax/addcomment")
	@ResponseBody
	public String addcomment(HttpSession session,int pCommentId,String content,int type,int otherId){
		Users user=(Users)session.getAttribute("login_success");
			int user_id = user.getUser_id();
			Date addtime = new Date();
			System.out.println("asf");
			System.out.println("pCommentId:"+pCommentId+"/content:"+content+"/type:"+type+"/otherId"+otherId);	

			Map map = new HashMap<>();
			map.put("content", content);
			map.put("addtime", addtime);
			map.put("type", type);
			map.put("otherId", otherId);
			map.put("p_comment_id", pCommentId);
			map.put("user_id", user_id);
			ecs.insertComment(map);
			return "redirect:/articleinfo/"+otherId;
	}
	
	@RequestMapping("/web/comment/ajax/commentreply")
	@ResponseBody
	public ModelAndView commentreply(int otherId,int pCommentId) {
		Map map = new HashMap<>();
		map.put("otherId", otherId);
		map.put("pCommentId", pCommentId);
		List<Comment> commentList = ecs.getcommentpcomm(map);
//		System.out.println(commentList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentList", commentList); 
		mv.setViewName("/web/comment/comment_reply");
		return mv;
	}
	
	@RequestMapping("/web/comment/ajax/addChildComment")
	public String addChildComment(HttpSession session,int pCommentId,String content,int type,int otherId){
		
		Users user=(Users)session.getAttribute("login_success");
		int user_id = user.getUser_id();
		Date addtime = new Date();
		System.out.println("asf");
		System.out.println("pCommentId:"+pCommentId+"/content:"+content+"/type:"+type+"/otherId"+otherId);	

		Map map = new HashMap<>();
		map.put("content", content);
		map.put("addtime", addtime);
		map.put("type", type);
		map.put("otherId", otherId);
		map.put("p_comment_id", pCommentId);
		map.put("user_id", user_id);
		ecs.insertComment(map);
		return "redirect:/articleinfo/"+otherId;
		
	}
}
