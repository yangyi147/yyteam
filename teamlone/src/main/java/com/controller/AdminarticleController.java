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

import com.bean.Edu_article;
import com.bean.Edu_article_content;
import com.service.Edu_articleService;
import com.service.Edu_article_contentService;
import com.service.Edu_commentService;

@Controller
@RequestMapping("/admin")
public class AdminarticleController {

	
	@Autowired
	private Edu_articleService eimpl;
	@Autowired
	private Edu_article_contentService eacimpl;
	@Autowired
	private Edu_commentService ecs;
	
	@RequestMapping("/essayst")
	public ModelAndView essay(){
		List<Edu_article> list = eimpl.getlistAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("admin/essay/articleList");
		return mv;
	}

	@RequestMapping("/essaysadd")
	public String essayadd(){
		
		return "admin/essay/articleAdd";
	}
	
	@RequestMapping(value="/articleadd",method = RequestMethod.POST)
	public String articleAdd(@RequestParam("file")MultipartFile file,HttpServletRequest request,Edu_article_content edu_article_content,Edu_article article){
		String filename = file.getOriginalFilename();
		String path = request.getRealPath("/images/");
		File articlefile = new File(path,filename);
		System.out.print(filename);
		try {
			if(!articlefile.exists()){
				articlefile.createNewFile();
			}
			file.transferTo(articlefile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String vardv = "/images/"+filename;
		article.setImage_url(vardv);
		Date date = new Date();
		System.out.print(date);
		article.setPublish_time(date);
		article.setCreate_time(date);
		eacimpl.artcleAdd(article);
		edu_article_content.setEdu_article(article);
		eacimpl.addarticle(edu_article_content);
		return "redirect:/admin/essayst";
	}
	
	
	@RequestMapping("/deletearticle/{article_id}")
	public String deleteArticle(@PathVariable("article_id")int article_id){
		
		eimpl.deleteArtcle(article_id);
		return "redirect:/admin/essayst";
	}
	
	@RequestMapping("/artcleupdate/{article_id}")
	public ModelAndView updateArtcle(@PathVariable("article_id")int article_id){
		Edu_article_content eacget = eacimpl.getByid(article_id);
		ModelAndView mc = new ModelAndView();
		mc.addObject("eacget", eacget);
		mc.setViewName("admin/essay/articleUpdate");
		return mc;
	}

	
}
