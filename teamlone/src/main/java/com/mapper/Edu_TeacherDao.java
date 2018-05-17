package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Teacher;

/**
 * @author lenovo
 *��ʦ
 */
public interface Edu_TeacherDao {
	
	/**
	 * @return
	 * ����רҵid��ѯ���н�ʦ
	 */
	List<Edu_Teacher>getAllTeacherBySubjectId();
	
	List<Edu_Teacher>getAllTeacherByMap(Map map);
	
	List<Edu_Teacher> getTeacherById(int id);
	
	List<Edu_Teacher>getSubjectNextAllTeacher(int id);


}
