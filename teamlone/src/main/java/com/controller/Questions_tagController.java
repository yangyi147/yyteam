package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Questions;
import com.bean.Questions_tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.QuestionsService;
import com.service.Questions_tagService;

@Controller
@RequestMapping("/admin/questions_tag")
public class Questions_tagController {
	@Autowired
	private QuestionsService   questionsService;
	@Autowired
	private Questions_tagService Questions_tagService;
	/**
	 * 查询所有问答类型
	 * 
	 */
	@RequestMapping("/listAll")
	public ModelAndView listAll(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request) {
		PageHelper.startPage(page, 5);
		ModelAndView mv=new ModelAndView();
		Map map =new HashMap<>();
		List<Questions_tag> tags = Questions_tagService.listAll();
		PageInfo<Questions_tag>  pageInfo = new PageInfo<Questions_tag>(tags);
		mv.setViewName("/admin/question/tagList");
		mv.addObject("page", pageInfo);
		mv.addObject("tags", tags);
		return mv;
	}
	
	/**
	 * 通过id修改 问答status
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("/updateStatus/{id}")
	public String updateStatus(@PathVariable("id")int id) {
	    Questions_tagService.updateStatus(id);
		return "redirect:/admin/questions_tag/listAll";
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public int updatess(@PathVariable("id")int id) {
	  List<Questions> q= questionsService.getByQaT(id);
	  System.out.println(q.size());
	  if(q.size()>0){
		  System.out.println("11111111");
		  return 1;
	  }else{
		  return 2;
	  }
	}
	
	
	/**
	 * 查询单个类型
	 *
	 *
	 */
	@RequestMapping("/init/{id}")
	public String init(@PathVariable("id")int id,Model model) {
		Questions_tag tag = Questions_tagService.getById(id);
		model.addAttribute("tag", tag);
		return "/admin/question/updateTag";
	}
	
	
	/**
	 * 修改类型
	*
	*
	 */
	@RequestMapping("/update")
	public String update(Questions_tag tag){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date create_time = null;
		try {
			create_time = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tag.setCreate_time(create_time);
		Questions_tagService.update(tag);
		return "redirect:/admin/questions_tag/listAll";
	}
	
	/**
	 * 修改id
	 *添加类型
	 */
	@RequestMapping("/save")
	public String save(Questions_tag tag){
		if (!tag.getQuestions_tag_name().equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date create_time = null;
			try {
				create_time = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tag.setCreate_time(create_time);
			Questions_tagService.save(tag);
		}
		return "redirect:/admin/questions_tag/listAll";
	}
}
