package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Emailsend;
import com.bean.Users;
import com.email.JavaEmailSender;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EmailsendServiceImpl;
import com.service.UserServiceImpl;
import com.util.MyJob;
import com.util.QuartzManager;

@Controller
@RequestMapping("/admin/email")
public class EmailsendController {
	public static String JOB_NAME = "动态任务调度";  
	  public static String TRIGGER_NAME = "动态任务触发器";  
	  public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
	  public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";
	@Autowired
	EmailsendServiceImpl emailsendServiceImpl;
	@Autowired
	UserServiceImpl   userServiceImpl;
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) throws Exception  {
		//	邮件显示	 
		ModelAndView mv =new ModelAndView();
		Map map = new HashMap<>();
		map=initMap(map, request);
		List<Emailsend> list = emailsendServiceImpl.getlistAll(new HashMap<>(map));
		mv.addObject("list", list);
		mv.setViewName("/common/emailsend");
		return mv;	
	}
	@RequestMapping("/initId/{id}")
	public String  initId(@PathVariable("id")int id,Model model) {
		Emailsend emailsend = emailsendServiceImpl.getById(id);
		model.addAttribute("emailsend", emailsend);
		return "/common/examiner";
	}
	private Map initMap(Map map,HttpServletRequest request) throws Exception {
		//	模糊查询
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		String status = request.getParameter("status"); 
		String start =request.getParameter("start");
		String end =request.getParameter("end");

		if (email!=null&&email.length()>0) {
			map.put("email", email);
			request.setAttribute("email", email);
		}
		if (type!=null&&type.length()>0) {
			map.put("type", Integer.valueOf(type));
			request.setAttribute("type", type);
		}if (status!=null&&status.length()>0) {
			map.put("status", Integer.valueOf(status));
			request.setAttribute("status", status);
		}if (start!=null&&start.length()>0) {
			map.put("start", start);
			request.setAttribute("start", start);
		}
		if (end!=null&&end.length()>0) {
			map.put("end", end);
			request.setAttribute("end", end);
		}

	return map;
	
}
/**
 * 跳转到发送邮件界面
 * @return
 * @throws Exception
 */
@RequestMapping("/toEmailMsg")
public ModelAndView add(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request)throws Exception {
	ModelAndView mv = new ModelAndView();
	Map map = new HashMap<>();
	PageHelper.startPage(page,10); //分页设置每页显示数
	List<Users> lists = (List<Users>) userServiceImpl.getListAlls();
	PageInfo<Users> pageInfo=new PageInfo<>(lists); //分页把数据存放pageinfo
	mv.addObject("lists", lists);
	mv.addObject("page", pageInfo);  //分页界面传参
	mv.setViewName("/common/youjianup");
	return mv;
}


/**
 * 发送邮件
 * @throws Exception 
 */
@RequestMapping(value="/sendEmail",produces="application/json;charset=UTF-8")
public String sendEmail(Model model, HttpServletRequest request,Emailsend e) throws Exception{
	System.out.println(e);
	String email=request.getParameter("email");
	String emailArray[] = email.split(";");
	for (int i = 0; i < emailArray.length; i++) {
		System.out.println(emailArray[i]);
		e.setEmail(emailArray[i]);
		if(e.getType()==1){	
			JavaEmailSender.sendEmail(e); //邮件发送
			e.setSend_time(new Date());

		}else{
			String date=e.getStarttime();
			date=date.replace("T"," ");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			e.setSend_time(sdf.parse(date));
			JobDetail job = JobBuilder.newJob(MyJob.class)
					.withIdentity("myJob", "group1")
					.usingJobData("title",e.getTitle())
					.usingJobData("content",e.getContent())
					.usingJobData("email",e.getEmail())
					.build();
			String[] dates=date.split(" ");
			String[] date_year=dates[0].split("-");
			String[] date_time=dates[1].split(":");//0 51 15 26 4 ? 2016
			String cons="0 "+date_time[1]+" "+date_time[0]+" "+date_year[2]+" "+date_year[1]+" ?"+" "+date_year[0];
			QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, job,cons); 
		}
		e.setCreate_time(new Date());
		emailsendServiceImpl.insave(e);
		model.addAttribute("e", e);
	}
	return "redirect:/admin/email/list";
}
	

}
