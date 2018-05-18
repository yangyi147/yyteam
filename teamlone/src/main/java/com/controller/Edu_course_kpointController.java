package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Edu_Course;
import com.bean.Edu_Course_Note;
import com.bean.Edu_Teacher;
import com.bean.Edu_course_Kpoint;
import com.bean.Sys_Subject;
import com.bean.Users;
import com.service.Edu_CourseService;
import com.service.Edu_Course_NoteService;
import com.service.Edu_TeacherService;
import com.service.Edu_course_KpointService;
import com.service.Sys_Subjectervice;
import com.util.Result;

@Controller
@RequestMapping("/front/courseKpoint")
public class Edu_course_kpointController {
	
	@Autowired
	Edu_course_KpointService courseKpointService;
	@Autowired
	Edu_CourseService courseService;
	@Autowired
	Edu_TeacherService teacherSevice;
	@Autowired
	Sys_Subjectervice subjectService;
	@Autowired
	Edu_Course_Note courseNote;
	@Autowired
	Edu_Course_NoteService courseNoteService;
	@Autowired
	Result result;
	@RequestMapping("/listCourse")
	public String listCourse(HttpServletRequest request) {
		Map map=init(request);
		List<Edu_Course> allCourse = courseService.getAllCourse(map);//��ѯ���пγ�
		List<Sys_Subject> allSubjict = subjectService.getAllSubjict();//��ѯ����רҵ
		List<Sys_Subject> allSubjectByChild = subjectService.getAllSubjectByChild(map);//��ѯ��רҵ
		List<Edu_Teacher> allTeacherBySubjectId = teacherSevice.getAllTeacherByMap(map);
		request.setAttribute("allSubjectByChild", allSubjectByChild);
		request.setAttribute("allTeacherBySubjectId", allTeacherBySubjectId);
		request.setAttribute("allSubjict", allSubjict);
		request.setAttribute("allCourse", allCourse);
		return "/web/course/courses-list";
	}
	@RequestMapping("/videoDetails/{course_id}")
	public String videoDetails(@PathVariable("course_id")int id,HttpServletRequest request) {
		 List<Edu_course_Kpoint> courseKpoint = courseKpointService.getCourseKpoint(id);
		Edu_Course courseByID = courseService.getCourseByID(id);
		List<Edu_Teacher> teacherById = teacherSevice.getTeacherById(id);
		List<Edu_Teacher> subjectNextAllTeacher = teacherSevice.getSubjectNextAllTeacher(id);
		List<Edu_Course> sunjectNextAllCourse = courseService.getSunjectNextAllCourse(id);
		for (Edu_Course edu_Course : sunjectNextAllCourse) {
			edu_Course.setTeacher(subjectNextAllTeacher);
		}
		List<Edu_course_Kpoint> courseKpointAllVideo = courseKpointService.getCourseKpointAllVideo(id);
		request.setAttribute("sunjectNextAllCourse", sunjectNextAllCourse);
		request.setAttribute("courseKpointAllVideo", courseKpointAllVideo);
		request.setAttribute("teacherById", teacherById);
		request.setAttribute("courseKpoint", courseKpoint);
		request.setAttribute("courseByID", courseByID);
		return "/web/course/course-infor";
	}
	@ResponseBody
	@RequestMapping("/likeCourseName")
	public List<Edu_Course> likeCourseName(HttpServletRequest request) {
		Map map=init(request);
		List<Edu_Course> allCourse = courseService.getAllCourse(map);
		return allCourse;
	}
	@RequestMapping("/chapterTranslation/{id}")
	public String chapterTranslation(@PathVariable("id")int id,HttpServletRequest request,HttpSession session) {
		String parameter = request.getParameter("ckid");
		if (parameter!=null) {
			Edu_course_Kpoint courseKpointNameById = courseKpointService.getCourseKpointNameById(Integer.parseInt(parameter));
			request.setAttribute("name", courseKpointNameById.getName());
			request.setAttribute("kid",Integer.parseInt(parameter));
		}
		 List<Edu_course_Kpoint> courseKpoint = courseKpointService.getCourseKpoint(id);
		 Edu_Course course=this.courseService.getCourseByID(id);
		 List<Edu_course_Kpoint> parentList=new ArrayList<Edu_course_Kpoint>();
		 for(int i=0;i<courseKpoint.size();i++){
			 Edu_course_Kpoint kpoint=courseKpoint.get(i);
			 if(kpoint.getpId()==0){
				 parentList.add(kpoint);
			 }
		 }
		 for(Edu_course_Kpoint pkpoint:parentList){
			 for(Edu_course_Kpoint kpoint:courseKpoint){
				 if(pkpoint.getId()==kpoint.getpId()){
					 pkpoint.getSonList().add(kpoint);
				 }
			 }
		 }
		 List<Edu_Teacher> subjectNextAllTeacher = teacherSevice.getSubjectNextAllTeacher(id);
			List<Edu_Course> sunjectNextAllCourse = courseService.getSunjectNextAllCourse(id);
			for (Edu_Course edu_Course : sunjectNextAllCourse) {
				edu_Course.setTeacher(subjectNextAllTeacher);
			}
			//int courseKpointMinIDByCourseID = courseKpointService.getCourseKpointMinIDByCourseID(id);
//			if (courseKpointMinIDByCourseID!=0) {
//				request.setAttribute("courseKpointMinIDByCourseID", courseKpointMinIDByCourseID);
//			}
			if(parentList.size()>0){
				Edu_course_Kpoint point=parentList.get(0);
				if(point!=null&&point.getSonList().size()>0){
					request.setAttribute("courseKpointMinIDByCourseID", point.getSonList().get(0).getId());
				}
			}
			request.setAttribute("sunjectNextAllCourse", sunjectNextAllCourse);
		request.setAttribute("parentKpointList", courseKpoint);
		request.setAttribute("course",course);
		return "/web/course/player-video";
	}
	@ResponseBody
	@RequestMapping("/getCourseNextAllUser/{cid}")
	public Result getCourseNextAllUser(@PathVariable("cid")int cid) {
		List<Users> courseNextAllUser = courseService.getCourseNextAllUser(cid);
		if (courseNextAllUser.size()>0) {
			result.setSuccess(true);
			result.setEntity(courseNextAllUser);
		}
		return result;
	}
	@RequestMapping("/getPlayerHtml")
	public String getPlayerHtml(HttpServletRequest request,HttpSession session) {
		System.out.println("cid:"+request.getParameter("cid"));
		if (request.getParameter("cid")==null ||request.getParameter("cid").equals("0")) {
			if (request.getParameter("kpointId")!=null) {
				Edu_course_Kpoint courseKponintByKpointId = courseKpointService.getCourseKponintByKpointId(Integer.parseInt(request.getParameter("kpointId")));
				request.setAttribute("courseKponintByKpointId", courseKponintByKpointId);
				session.setAttribute("kid",Integer.parseInt(request.getParameter("kpointId")));
			}
		}else {
			Edu_course_Kpoint courseKpointByCourseId = courseKpointService.getCourseKpointByCourseId(Integer.parseInt(request.getParameter("cid")));
			request.setAttribute("courseKponintByKpointId", courseKpointByCourseId);
		}
		return "/web/course/videocode";
	}
	@ResponseBody
	@RequestMapping("/queryNote")
	public Edu_Course_Note queryNote(HttpServletRequest request) {
		String kpointId = request.getParameter("kpointId");
		String courseId=request.getParameter("courseId");
		Map map=new HashMap();
		map.put("kpointId",kpointId);
		map.put("courseId",courseId);
		System.out.println("map:"+map.get("kpointId")+",,,"+map.get("courseId"));
		Edu_Course_Note allCourseNoteByID = courseNoteService.getAllCourseNoteByID(map);
		if (allCourseNoteByID==null) {
		 	courseNote.setKpoint_id(1);
		 	return courseNote;
		}
		return allCourseNoteByID;
	}
	@ResponseBody
	@RequestMapping("/addnote")
	public int addnote(HttpServletRequest request) {
		int insertCourseNote = courseNoteService.insertCourseNote(request);
		return insertCourseNote;
	}
	@ResponseBody
	@RequestMapping("/updatenote")
	public int updatenote(HttpServletRequest request) {
		System.out.println("=================ds=============================");
		int insertCourseNote = courseNoteService.updateCourseKpoint(request);
		System.out.println(insertCourseNote);
		return insertCourseNote;
	}
	
	private Map init(HttpServletRequest request){
	 Map map=new HashMap<>();
	 String parameter = request.getParameter("sid");
	 if (parameter!=null&&parameter.trim().length()>0) {
		int sid=Integer.parseInt(parameter);
		map.put("sid", sid);
		request.setAttribute("sid", sid);
	}
	 String parameter2 = request.getParameter("sfid");
	 if (parameter2!=null&&parameter2.trim().length()>0) {
		 int sfid=Integer.parseInt(parameter2);
		 map.put("sfid", sfid);
		 request.setAttribute("sfid", sfid);
	 }
	 String parameter3 = request.getParameter("tid");
	 if (parameter3!=null&&parameter3.trim().length()>0) {
		 System.out.println("tid:"+parameter3);
		int tid=Integer.parseInt(parameter3);
		map.put("tid", tid);
		request.setAttribute("tid", tid);
	}
	 String parameter4 = request.getParameter("courseName");
	 if (parameter4!=null&&parameter4.trim().length()>0) {
		map.put("courseName", parameter4);
	}
	 String parameter5 = request.getParameter("size");
	 if (parameter5!=null&&parameter5.trim().length()>0) {
		map.put("size", parameter5);
	}
	return map;
	}

}
