package com.mapper;

import java.util.List;

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

}
