package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Sys_Subject;

public interface Sys_SubjectDao {
	
	List<Sys_Subject>getSubjectById(int id);
	
	List<Sys_Subject>getAllSubjict();
	
	List<Sys_Subject>getAllSubjictByparent_Id();
	
	void insertSubject(Sys_Subject subject);
	
	List<Sys_Subject>getAllSubjectByChild(Map map);
	
	String getNameByName(String name);

	void updateSubject(Sys_Subject subject);
	
	void deleteSubject(int id);

}
