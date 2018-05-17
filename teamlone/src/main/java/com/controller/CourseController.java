package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Edu_Teacher;
import com.bean.Edu_course_Kpoint;
import com.bean.Sys_Subject;
import com.github.pagehelper.PageInfo;
import com.mapper.Edu_TeacherDao;
import com.service.Edu_CourseService;
import com.service.Edu_TeacherService;
import com.service.Edu_course_KpointService;
import com.service.Sys_Subjectervice;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/course")
public class CourseController {
	@Autowired
	Edu_CourseService courseService;
	@Autowired
	Sys_Subjectervice subjectService;
	@Autowired
	Edu_course_KpointService course_KpointService;
	@Autowired
	Edu_TeacherService teacherService;

	@RequestMapping("/list")
	public String list(@RequestParam(name="page",defaultValue="0")int page,HttpServletRequest request) {
		Map map=init(request);
		PageInfo<Edu_Course> allEnd_Course = courseService.getAllEnd_Course(map, page);
		List<Sys_Subject> allSubjict = subjectService.getAllSubjict();
		request.setAttribute("allSubjict", allSubjict);
		request.setAttribute("allEnd_Course", allEnd_Course);
		request.setAttribute("map", map);
		return "/admin/CourseManagement";
	}
	@RequestMapping("/chapter/{id}/{aid}/{cid}")
	public String chapter(@PathVariable("id")int id,@PathVariable("aid")int aid,@PathVariable("cid")int cid,HttpServletRequest request) {
		System.out.println("id:"+id+",aid:"+aid+",cid:"+cid);
		List<Sys_Subject> allSubjictByparent_Id = subjectService.getAllSubjictByparent_Id();
		List<Sys_Subject> allSubjict = subjectService.getAllSubjictByparent_Id();
		for (int i = 0; i < allSubjict.size(); i++) {
			if (allSubjict.get(i).getId()==id) {
				allSubjict.get(i).setChecked(true);
				request.setAttribute("sname", allSubjict.get(i).getName());
			}
		}
		Edu_Course courseByID = courseService.getCourseByID(cid);
		List<Edu_Teacher> allTeacher = teacherService.getAllTeacherBySubjectId();
		System.out.println("allTeacher:"+allTeacher);
		String json=JsonUtils.objectToJson(allSubjict);
		request.setAttribute("allTeacher", allTeacher);
        request.setAttribute("courseByID", courseByID); 		
		request.setAttribute("allSubjictByparent_Id", allSubjictByparent_Id);
		request.setAttribute("allSubjict", json);
		request.setAttribute("aid",aid);
		request.setAttribute("id",id);
		return "/admin/Chapter";
	}
	@RequestMapping("/editChapter")
	public String editChapter(MultipartFile file,Edu_Course course,String end_times,int tid,String ssid,HttpServletRequest request) {
		courseService.editChapter(file, course, end_times, ssid, tid, request);
		return "redirect:/admin/course/list";
	}
	@RequestMapping("/chapte/{id}")
	public String chapte(@PathVariable("id")int id,HttpServletRequest request) {
		List<Edu_course_Kpoint> allEdu_course_KpointByCourseID = course_KpointService.getAllEdu_course_KpointByCourseID(id);
		List<Edu_Teacher> allTeacherBySubjectId = teacherService.getAllTeacherBySubjectId();
		System.out.println("allEdu_course_KpointByCourseID:"+allEdu_course_KpointByCourseID);
		String json= JsonUtils.objectToJson(allEdu_course_KpointByCourseID);
		request.setAttribute("allTeacherBySubjectId", allTeacherBySubjectId);
		request.setAttribute("allEdu_course_KpointByCourseID", json);
		request.setAttribute("id", id);
		return "/admin/chapte";
	}

	@RequestMapping("/addCourse")
	public String addCourse(HttpServletRequest request) {
		List<Sys_Subject> allSubjict = subjectService.getAllSubjictByparent_Id();
		List<Edu_Teacher> allTeacher = teacherService.getAllTeacherBySubjectId();
		String json=JsonUtils.objectToJson(allSubjict);
		request.setAttribute("allSubjict", json);
		request.setAttribute("allTeacher", allTeacher);
		return "/admin/addCourse";
	}
	@RequestMapping("/addCourseTo")
	public String addCourseTo(MultipartFile file,Edu_Course course,String end_times,int tid,String ssid,HttpServletRequest request) {
		courseService.insertCourse(file, course, end_times, tid, ssid, request);
		return "redirect:/admin/course/list";
	}
	@RequestMapping("/getCourseNameRepeat")
	@ResponseBody
	public int getCourseNameRepeat(String course_name) {
		int courseNameRepeat = courseService.getCourseNameRepeat(course_name);
		return courseNameRepeat;
	}
	@RequestMapping("/addVideo")
	public String addVideo(Edu_course_Kpoint courseKpoint,HttpServletRequest request,int tid) {
		course_KpointService.insertCourseKpoint(courseKpoint, tid);
		return "redirect:/admin/course/chapte/"+courseKpoint.getId();
	}
	@RequestMapping("/storageUrl")
	public String storageUrl(HttpServletRequest request,Edu_course_Kpoint courseKpoint,int courseid) {
		course_KpointService.storageUrl(request,courseKpoint);
		
		return "redirect:/admin/course/chapte/"+courseid;
	}
	
	/**
	 * @param file
	 * @param request
	 * @return
	 * 上传视频
	 */
	@ResponseBody
	@RequestMapping("/storeVideo")
	public String storeVideo(@RequestParam("uploadfile")MultipartFile file,HttpServletRequest request) {
		String pathRoot = request.getSession().getServletContext().getRealPath("video"); 
		 String filename=file.getOriginalFilename();  
		 if(!file.isEmpty()){  
			 //生成uuid作为文件名称  
			 String uuid = UUID.randomUUID().toString().replaceAll("-","");  
			 filename=uuid+filename.substring(filename.lastIndexOf("."));
			 System.out.println("filename:"+filename);
			 File newfile=new File(pathRoot,filename);
			 try {
				 if(!newfile.exists()){
					 newfile.createNewFile();
				 }
				 file.transferTo(newfile);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }  
		 }  
		return filename;
	}
	@ResponseBody
	@RequestMapping("/uploadVideo")
    public String uploadVideo(MultipartFile file ) {
		
		return "";
	}
	
	@SuppressWarnings("deprecation")
	private Map init(HttpServletRequest request){
		Map map =new HashMap<>();
		String name =  request.getParameter("name");
		if (name!=null&&name.trim().length()!=0) {
			map.put("name",name);
		}
		String zid = request.getParameter("ztid");
		System.out.println("zid:"+zid);
		if (zid!=null&&zid.trim().length()>0) {
			int ztid= Integer.parseInt(zid);
			map.put("ztid",ztid);
		}
		String zyids = request.getParameter("zyid");
		if (zyids!=null&&zyids.trim().length()!=0) {
			int zyid=Integer.parseInt(zyids);
			map.put("zyid",zyid);
		}
		String parameter = request.getParameter("stattime");
		if (parameter!=null&&parameter.trim().length()!=0) {
			map.put("stattim", parameter);
		}
		String endtime = request.getParameter("endtime");
		if (endtime!=null&&endtime.trim().length()!=0) {
			map.put("endtime", endtime);
		}
		return map;
	}

}
