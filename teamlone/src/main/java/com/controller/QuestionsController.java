package com.controller;

import java.io.UnsupportedEncodingException;

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
import org.springframework.web.servlet.ModelAndView;

import com.bean.Questions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.QuestionsService;
import com.service.Questions_commentService;

@Controller
@RequestMapping("/admin/questions")
public class QuestionsController {
	@Autowired
	private QuestionsService questionsService;
	
	@Autowired
	private Questions_commentService questions_commentService;
	/**
	 * 查询所有问答
	 *
	 */
	@RequestMapping("/listAll")
	public ModelAndView listAll(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model md) throws UnsupportedEncodingException {
		PageHelper.startPage(page, 5);
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap();
		map = initMap(request, map);
		List<Questions> questions = questionsService.listAll(map);
		PageInfo<Questions>  pageInfo = new PageInfo<Questions>(questions);
		mv.setViewName("/admin/question/questionsList");
		mv.addObject("page", pageInfo);
		mv.addObject("questions",questions);
		return mv;
	}
	/**
	 * map
	 * 封装查询所需要的值
	 *
	 */
	private Map initMap(HttpServletRequest request,Map map) throws UnsupportedEncodingException {
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		if (title!=null && title.length() > 0) {
			map.put("title", title);
			request.setAttribute("title", title);
		}
		if (type != null && type.length() > 0) {
			map.put("type", Integer.valueOf(type));
			request.setAttribute("type", Integer.valueOf(type));
		}
		if (start != null && start.length() > 0) {
			map.put("start", start);
			request.setAttribute("start", start);
		}
		if (end !=null && end.length() > 0) {
			map.put("end", end);
			request.setAttribute("end", end);
		}
		return map;
	}
	
	/**
	 *通过id删除问答
	 *
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")int id) {
		questions_commentService.deleteqid(id);
		questionsService.delete(id);
		return "redirect:/admin/questions/listAll";
	}
}
