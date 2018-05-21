package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Edu_course_Kpoint;

public interface Edu_course_KpointService {
	
	List<Edu_course_Kpoint>getAllEdu_course_KpointByCourseID(int id);
	
	void insertCourseKpoint(Edu_course_Kpoint courseKpoint,int tid);
	
	Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint);
	
	void storageUrl(HttpServletRequest request,Edu_course_Kpoint courseKpoint);
	
	String storeVideo(MultipartFile multiFile,HttpServletRequest request);
	
	List<Edu_course_Kpoint> getCourseKpoint(int id);
	
	List<Edu_course_Kpoint>getCourseKpointAllVideo(int id);
	
	Edu_course_Kpoint getCourseKpointByID(int id);
	
	Edu_course_Kpoint getCourseKponintByKpointId(int id);
	
	Edu_course_Kpoint getCourseKpointNameById(int id);
	
	Edu_course_Kpoint getCourseKpointByCourseId(int id);
	
	int getCourseKpointMinIDByCourseID(int id);
	
	Edu_course_Kpoint getVideoByID(int id);

}
