package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Comment;
import com.bean.Edu_Course;
import com.bean.Images;
import com.bean.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.CommentService;
import com.service.Edu_CourseService;
import com.service.ImagesService;
import com.service.TeacherService;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Autowired
	private Edu_CourseService edu_CourseService;
	@Autowired
	private  CommentService commentService;
	@Autowired
	private ImagesService imagesService;
	@Autowired
	private  TeacherService teacherService;
	@RequestMapping("/front")
	public ModelAndView list(@RequestParam(name="page",defaultValue="0")int page){
		Map map=new HashMap<>();
		PageInfo<Teacher> th=teacherService.getlistAll(map, page);
		PageInfo<Edu_Course> ts=edu_CourseService.getAllEnd_Course(map, page);
		PageInfo<Images> websiteImagesList=imagesService.getlistAll(map,page);
		PageInfo<Comment>	commentList=commentService.getListAll(map, page);
		ModelAndView md=new ModelAndView();
		md.addObject("websiteImagesList", websiteImagesList);
		md.addObject("subjectList", ts);
		md.addObject("teacherList", th);
		md.addObject("commentList", commentList);
		md.setViewName("web/index/index");
		return md;
	}
}
