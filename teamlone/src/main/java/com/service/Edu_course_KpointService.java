package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import com.bean.Edu_course_Kpoint;

public interface Edu_course_KpointService {
	
	List<Edu_course_Kpoint>getAllEdu_course_KpointByCourseID(int id);
	
	void insertCourseKpoint(Edu_course_Kpoint courseKpoint,int tid);
	
	Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint);
	
	String readSchedule(MultipartFile file,HttpServletRequest request);
	
	String storeVideo(MultipartFile multiFile,HttpServletRequest request);

}
