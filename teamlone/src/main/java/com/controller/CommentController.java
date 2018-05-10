package com.controller;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Comment;
import com.bean.Subjects;
import com.bean.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.CommentService;
import com.service.SubjectsService;
import com.service.TeacherService;
import com.util.InfoNode;
import com.util.JsonUtils;
@Controller
@RequestMapping("/admin")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@RequestMapping("/comment")
    public ModelAndView findall(@RequestParam(name="page",defaultValue="0")int page,HttpServletRequest request) {
		ModelAndView md=new ModelAndView();
		Map map=inerMap(request);
		PageInfo<Comment> tc=commentService.getListAll(map,page);
		md.addObject("tc", tc);
		md.setViewName("/admin/comment/comment");
		return md;
	}
	@RequestMapping("/delCo/{id}")
	public String  delTe(@PathVariable("id")int id){
		commentService.delCo(id);
		return "redirect:/admin/comment";
	}
	private Map inerMap(HttpServletRequest request){
	 String startdate=request.getParameter("startdate");
	 String  stopdate=request.getParameter("stopdate");
	 Map map=new HashMap<>();
	 String pname=request.getParameter("qname");
	 String qemail=request.getParameter("qemail");
	 String  ptype=request.getParameter("qtype");
	 System.out.println(startdate);
	 System.out.println(stopdate);
	 System.out.println(pname+"pname");
	 System.out.println(qemail+"qemail");
	request.setAttribute("qtype", ptype);
		if (ptype==null) {
			ptype="-1";
		}
		map.put("qtype", ptype);
		request.setAttribute("qname", pname);
		request.setAttribute("qemail", qemail);
		map.put("qname", pname);
		map.put("qemail", qemail);
		map.put("startdate", startdate);
		map.put("stopdate", stopdate);
		request.setAttribute("startdate", startdate);
		request.setAttribute("stopdate", stopdate);
		return map;
	}
	@RequestMapping("/incom")
	public String incom( Comment comment) {
		incom(comment);
		return "redirect:/admin/comment";
	}
}
