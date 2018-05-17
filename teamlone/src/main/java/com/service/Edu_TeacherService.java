package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Teacher;

public interface Edu_TeacherService {
	
	List<Edu_Teacher>getAllTeacherBySubjectId();

	List<Edu_Teacher>getAllTeacherByMap(Map map);
	
	List<Edu_Teacher> getTeacherById(int id);
	
	List<Edu_Teacher>getSubjectNextAllTeacher(int id);
	
	
}
