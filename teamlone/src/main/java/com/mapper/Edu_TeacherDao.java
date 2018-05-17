package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Teacher;

/**
 * @author lenovo
 *教师
 */
public interface Edu_TeacherDao {
	
	/**
	 * @return
	 * 按照专业id查询所有教师
	 */
	List<Edu_Teacher>getAllTeacherBySubjectId();
	
	List<Edu_Teacher>getAllTeacherByMap(Map map);
	
	List<Edu_Teacher> getTeacherById(int id);
	
	List<Edu_Teacher>getSubjectNextAllTeacher(int id);


}
