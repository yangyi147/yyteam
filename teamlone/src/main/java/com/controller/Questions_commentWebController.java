package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Qcuid;
import com.bean.QuestionsWeb;
import com.bean.Questions_Webcomment;
import com.bean.Questions_Webtag;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.QcuidService;
import com.service.QuestionsWebService;
import com.service.Questions_WebcommentService;
import com.service.Questions_WebtagService;
import com.util.Result;
@Controller
@RequestMapping("/front")
public class Questions_commentWebController {
	@Autowired
	private Questions_WebcommentService questions_commentService;
	@Autowired
	private QuestionsWebService  questionsService;
	@Autowired
	private Questions_WebtagService questions_tagService;
	@Autowired
	private QcuidService qcuidService;
	/**
	 * 查询全部问答+pagehelper
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/Questionslist")
	public ModelAndView listQuestionList(@RequestParam(required=true,defaultValue="0")Integer page, HttpServletRequest request){
		Map map=initMap(request);
		PageHelper.startPage(page, 5);
		List<QuestionsWeb>  qc=questionsService.getlistAll(map);
		ModelAndView md=new ModelAndView();
		List<Questions_Webtag> qt=questions_tagService.getlistAll();
		PageInfo<QuestionsWeb>  pageInfo = new PageInfo<QuestionsWeb>(qc);
		md.addObject("questionsTagList", qt);
		md.addObject("questionsList", qc);
		md.addObject("th", pageInfo);
		md.setViewName("/web/questions/questions-list");
		return md;
	}


	/**
	 *Map 封装传过来的值
	 * @param page
	 * @param request
	 * @return
	 */
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
	
	/**
	 * 根据id查询问答内容
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questions/info/{id}")
	public ModelAndView questionsinfo( @PathVariable("id")int id){
		if (id<0) {
			id=-1;
		}
		Map map=new HashMap<>();
		map.put("qid", id);
		ModelAndView  md=new ModelAndView();
		QuestionsWeb ai= questionsService.getById(id);
		questionsService.upBrowse(id);
		List<Questions_Webcomment>   qc=  questions_commentService.getlistAll(map);
		md.addObject("questions", qc);
		md.addObject("qt", ai);
		md.setViewName("/web/questions/questions-info");
		return md;
	}

	/**
	 * 查询全部评论
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questionscomment/ajax/list")
	@ResponseBody
	public ModelAndView  questions_coment(@RequestParam(required=true,defaultValue="0")Integer page,HttpServletRequest re){
		int id=Integer.parseInt(re.getParameter("questionsComment.questionId"));
		PageHelper.startPage(page, 2);
		Map map=new HashMap<>();
		map.put("qid", id);
		ModelAndView  md=new ModelAndView();
		QuestionsWeb ai= questionsService.getById(id);
		List<Questions_Webcomment>ac =ai.getQc();
		PageInfo<Questions_Webcomment>  pageInfo = new PageInfo<Questions_Webcomment>(ac);
		md.addObject("th", pageInfo);
		md.addObject("questionsCommentList", ai);
		md.setViewName("/web/questionscomment/questionscomment-ajax-list");
		return md;
	}	

	/**
	 * 点赞  如果已经点赞则不能再点赞
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/praise/ajax/add")
	@ResponseBody
	public  Result addcount(HttpServletRequest request,HttpSession session){
		Result result=new Result();
		Map map=new HashMap<>();
		int types= Integer.parseInt(request.getParameter("praise.type")); 
		int id =Integer.parseInt(request.getParameter("praise.targetId"));
		Users edu_user=(Users)session.getAttribute("login_success");
		if(types==1){
			map.put("qid", id);
			Qcuid qc=qcuidService.getById(map);
			if (qc==null||qc.equals("")) {
				Qcuid qu=new Qcuid();
				qu.setCid(0);
				qu.setQid(id);
				qu.setType(types);
				qu.setUid(edu_user.getUser_id());
				qcuidService.inQcuid(qu);
				questionsService.addCount(id);
				result.setSuccess(true);
			} else {
				result.setMessage("你已经点过赞了哦");
				result.setSuccess(false);
			}
		}else{
			map.put("cid", id);
			Qcuid qc=qcuidService.getById(map);
			if (qc==null || qc.equals("")) {
				Qcuid qu=new Qcuid();
				qu.setCid(id);
				qu.setQid(0);
				qu.setType(types);
				qu.setUid(edu_user.getUser_id());
				qcuidService.inQcuid(qu);
				questions_commentService.addCount(id);
				result.setSuccess(true);

			}else{
				result.setMessage("你已经点过赞了哦");
				result.setSuccess(false);
			}

		}
		return result;
	}



	/**
	 * 添加问答评论
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questionscomment/ajax/add")
	@ResponseBody
	public  Result addcoment(HttpServletRequest request,HttpSession session){
		int id=Integer.parseInt(request.getParameter("questionsComment.questionId"));
		String coment=request.getParameter("questionsComment.content");
		Users edu_user=(Users)session.getAttribute("login_success");
		Questions_Webcomment qc=new Questions_Webcomment();
		Date date =new Date();
		qc.setComment_id(0);
		qc.setIs_best(0);
		qc.setPraise_count(0);
		qc.setReply_count(0);
		qc.setContent(coment);
		qc.setEdu_user(edu_user);
		qc.setAdd_time(date);
		qc.setQuestion_id(id);
		qc.setComment_id(0);
		questions_commentService.insQc(qc);
		questionsService.upRcount(id);
		Result result =new Result();
		result.setSuccess(true);		
		return result;
	}


	/**
	 * 根据问答评论查询子评论
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questionscomment/ajax/getCommentById/{id}")
	public ModelAndView getBycommentid(@PathVariable("id") int id){
		List<Questions_Webcomment> qc=questions_commentService.getCommentId(id);
		ModelAndView md=new ModelAndView();
		md.addObject("questionsCommentRepList", qc);
		md.setViewName("web/questionscomment/questionscomment-ajax-listreply");
		return md;
	}
	/**
	 * 根据问答评论查询子评论
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questionscomment/ajax/getCommentById2/{id}")
	public ModelAndView getBycommentid2(@PathVariable("id") int id){
		List<Questions_Webcomment> qc=questions_commentService.getCommentId(id);
		ModelAndView md=new ModelAndView();
		md.addObject("questionsCommentRepList", qc);
		md.setViewName("web/questionscomment/questionscomment-ajax-list");
		return md;
	}
	@RequestMapping("/questions/toadd")
	public ModelAndView toadd(){
		ModelAndView md=new ModelAndView();
		List<Questions_Webtag> qt=questions_tagService.getlistAll();
		md.addObject("questionsTagList", qt);
		md.setViewName("web/questions/questions-add");
		return md;		
	}

	/**
	 * 添加问答
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/questions/ajax/add")
	@ResponseBody
	public Result add(HttpServletRequest request,HttpSession session){
		Users edu_user=(Users)session.getAttribute("login_success");
		String title=	request.getParameter("questions.title");
		String content=	request.getParameter("questions.content");
		int type=Integer.parseInt(request.getParameter("questions.type"));
		String  sd[]  =	request.getParameter("questionsTag").split(",");
		int b[] = new int [sd.length];
		for(int i=1;i<sd.length;i++){
			b[i]=Integer.parseInt(sd[i]);	
		}
		QuestionsWeb  qs=new QuestionsWeb();
		Date date=new Date();
		qs.setEdu_user(edu_user);
		qs.setTitle(title);
		qs.setContent(content);
		qs.setType(type);
		qs.setAdd_time(date);
		int a=questionsService.inQuestion(qs);
		int id =questionsService.getselID();
		
		for (int i = 1; i < b.length; i++) {
			Map map = new HashMap<>();
			int tid = b[i];
			map.put("qid",id);
			map.put("tid", tid);
			questions_tagService.inTag(map);
		}
		Result result=new Result();
		result.setSuccess(true);
		result.setEntity(id);
		return result;
	}


	/**
	 * 根据问答评论id添加该评论子评论
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("questionscomment/ajax/addReply")
	@ResponseBody()
	public Result addReply(HttpServletRequest request,HttpSession session){
		Result  result =new Result();
		String  content=request.getParameter("questionsComment.content");	
		int   id=Integer.parseInt(request.getParameter("questionsComment.commentId"));
		int cid=questions_commentService.selQid(id);
	
		Users edu_user=(Users)session.getAttribute("login_success");
		Questions_Webcomment qc=new Questions_Webcomment();
		Date date =new Date();
		qc.setComment_id(0);
		qc.setIs_best(0);
		qc.setPraise_count(0);
		qc.setReply_count(0);
		qc.setContent(content);
		qc.setEdu_user(edu_user);
		qc.setAdd_time(date);
		qc.setQuestion_id(cid);
		qc.setComment_id(id);
		questions_commentService.insQc(qc);
		questions_commentService.upRcount(id);
		result.setSuccess(true);
		return result ;
	}
}