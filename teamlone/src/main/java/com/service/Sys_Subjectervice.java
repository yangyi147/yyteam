package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Sys_Subject;

public interface Sys_Subjectervice {
	
	/**
	 *按照id查询专业内容
	 */
	List<Sys_Subject>getSubjectById(int id);
	
	/**
	 *查询所有的专业信息
	 */
	List<Sys_Subject>getAllSubjict();
	
	/**
	 *按照专业的父id查询所有子属性
	 */
	List<Sys_Subject>getAllSubjictByparent_Id();
	
	/**
	 * @param subject
	 * 添加专业
	 */
	void insertSubject(Sys_Subject subject);
	
	List<Sys_Subject>getAllSubjectByChild(Map map);
	
	int getNameByName(String name);
	
	void updateSubject(Sys_Subject subject);
	
	void deleteSubject(int id);

}
