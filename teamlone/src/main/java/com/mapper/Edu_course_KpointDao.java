package com.mapper;

import java.util.List;

import com.bean.Edu_course_Kpoint;

public interface Edu_course_KpointDao {
	
	List<Edu_course_Kpoint>getAllEdu_course_KpointByCourseID(int id);
	
	void insertCourseKpoint(Edu_course_Kpoint courseKpoint);
	
	Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint); 
	
	void updateCourseKpoint(Edu_course_Kpoint courseKpoint);
	
	List<Edu_course_Kpoint> getCourseKpoint(int id);
	
	List<Edu_course_Kpoint>getCourseKpointAllVideo(int id);
	
	Edu_course_Kpoint getCourseKpointByID(int id);
	
	Edu_course_Kpoint getCourseKponintByKpointId(int id);
	
	Edu_course_Kpoint getCourseKpointNameById(int id);
	
	Edu_course_Kpoint getCourseKpointByCourseId(int id);
	
}
