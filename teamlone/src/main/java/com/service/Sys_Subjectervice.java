package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Sys_Subject;

public interface Sys_Subjectervice {
	
	/**
	 *����id��ѯרҵ����
	 */
	List<Sys_Subject>getSubjectById(int id);
	
	/**
	 *��ѯ���е�רҵ��Ϣ
	 */
	List<Sys_Subject>getAllSubjict();
	
	/**
	 *����רҵ�ĸ�id��ѯ����������
	 */
	List<Sys_Subject>getAllSubjictByparent_Id();
	
	/**
	 * @param subject
	 * ���רҵ
	 */
	void insertSubject(Sys_Subject subject);
	
	List<Sys_Subject>getAllSubjectByChild(Map map);

}
