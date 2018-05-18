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
import com.bean.Subjects;
import com.bean.Sys_Subject;
import com.bean.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.SubjectsService;
import com.service.Sys_Subjectervice;
import com.service.TeacherService;
import com.util.InfoNode;
import com.util.JsonUtils;
@Controller
@RequestMapping("/admin")
public class TeacherController {
	@Autowired
	private Sys_Subjectervice sys_Subjectervice;
	@Autowired
	private TeacherService teacherService;
	/**
	 * 查询所有teacher
	 *
	 */
	@RequestMapping("/teacher")
    public ModelAndView findall(@RequestParam(name="page",defaultValue="0")int page,HttpServletRequest request) {
		ModelAndView md=new ModelAndView();
		Map map=inerMap(request);
		PageInfo<Teacher> tc=teacherService.getlistAll(map,page);
		md.addObject("tc", tc);
		md.setViewName("/admin/teacher/teacher");
		return md;
	}
	/**
	 * 通过id删除teacher
	 *
	 */
	@RequestMapping("/delTe/{id}")
	public String  delTe(@PathVariable("id")int id){
		teacherService.delTe(id);
		return "redirect:/admin/teacher";
	}
	
	/**
	 * 通过id查询teacher
	 *
	 */
	@RequestMapping("/teacher/getById/{id}")
	public ModelAndView  getById(@PathVariable("id")int id){
		Teacher teacher=teacherService.getById(id);
		ModelAndView md=new ModelAndView();
		md.addObject("te", teacher);
		System.out.println(teacher);
		List<Sys_Subject> su=sys_Subjectervice.getAllSubjict();
		String json=JsonUtils.objectToJson(su);
		md.addObject("su", json);
		md.setViewName("/admin/teacher/upteacher");
		return md;
	}
	
	/**
	 * map
	 * 通过map封装所需要的值
	 *
	 */
	private Map inerMap(HttpServletRequest request){
	 String startdate=request.getParameter("startdate");
	 String  stopdate=request.getParameter("stopdate");
	 Map map=new HashMap<>();
	 String  id=request.getParameter("tid");
	 String pname=request.getParameter("qname");
	 String ptype=request.getParameter("qtype");
	 String  ptname=request.getParameter("th_name");
	 request.setAttribute("qtype", ptype);
		if (id==null) {
			id="-1";
		}
		map.put("id", id);
		map.put("qtype", ptype);
		request.setAttribute("qname", pname);
		request.setAttribute("qtname", ptname);
		map.put("qname", pname);
		map.put("qtname", ptname);
		map.put("startdate", startdate);
		map.put("stopdate", stopdate);
		request.setAttribute("startdate", startdate);
		request.setAttribute("stopdate", stopdate);
		return map;
	}
	
	
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
     public String upload(HttpServletRequest request,
    		 @RequestParam("filename")String filename,Teacher teacher,@RequestParam("sd")int sd) throws Exception {
        	Date day=new Date();   
            Sys_Subject  sub= sys_Subjectervice.getSubjectById(sd).get(0);
            teacher.setPic_path("/images/"+filename);
            teacher.setSubject_id(sub);
            teacher.setCreate_time(day);
            teacher.setUpdate_time(day);
            teacherService.inTer(teacher);
            return "redirect:/admin/teacher";
     }
	 /**
		 *把文件上传到服务器
		 *
		 */
	 @RequestMapping(value="/uploadfind")
	 @ResponseBody
     public InfoNode uploadw(HttpServletRequest request,
    		 @RequestParam("file")MultipartFile  file) throws Exception {
		 System.out.println("=============="+file);
		 InfoNode node=new InfoNode();
		 if(!file.isEmpty()) {
            String path = request.getRealPath("/images/");
            String filename =  file.getOriginalFilename();
            System.out.println("name:"+filename);
            File newfile = new File(path,filename);
            if (!newfile.exists()) { 
            	newfile.createNewFile();
            }
            file.transferTo(newfile);
            System.out.println("123123");
            node.setCode("1");
            node.setUrl(filename);
            return node;
        } else {
            return node;
        }
     }
	 /**
		 * 通过id修改老师的个人信息
		 *
		 */
	@RequestMapping(value="/upTer")
	   public String upTer(Teacher teacher,@RequestParam("sd")int sd) throws Exception {
        	Date day=new Date();    
   		    Sys_Subject sub=sys_Subjectervice.getSubjectById(sd).get(0);
   		    teacher.setPic_path("/images/"+teacher.getPic_path());
            teacher.setSubject_id(sub);
            teacher.setUpdate_time(day);
            teacherService.upTer(teacher);
			return "redirect:/admin/teacher";
	 }
	@RequestMapping("/teacher/delectall/{str}")
	public  String delectall(@PathVariable("str")String checkedId){
		String  sd[]  =	checkedId.split(",");
		int b[] = new int [sd.length];
		for(int i=0;i<sd.length;i++){
			teacherService.delTe(Integer.parseInt(sd[i]));
		}
		return "redirect:/admin/teacher";
	}
}
