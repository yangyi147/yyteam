package com.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;

/**
 * @author lenovo
 *�γ�
 */
public interface Edu_CourseDao {
	
	/**
	 *����Map�����е����ݲ�ѯ�γ�
	 */
	List<Edu_Course>getAllEnd_Course(Map map);
	Edu_Course getCourseByID(int id);
	void updateCourse(Edu_Course course);
	void deleteTeacherByID(int id);
	void insertCourse_Thacher(@Param("id")int id,@Param("tid")int tid);
	void insertCourse(Edu_Course course);
    Edu_Course getCourseNameRepeat(String courseName);
	List<Edu_Course> getTeaByID(int id);

}
