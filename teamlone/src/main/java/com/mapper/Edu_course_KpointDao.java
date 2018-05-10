package com.mapper;

import java.util.List;

import com.bean.Edu_course_Kpoint;

public interface Edu_course_KpointDao {
	
	List<Edu_course_Kpoint>getAllEdu_course_KpointByCourseID(int id);
	
	void insertCourseKpoint(Edu_course_Kpoint courseKpoint);
	
	Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint); 

}
