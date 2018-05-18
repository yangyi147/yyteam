package com.mapper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Users;

/**
 * @author lenovo
 *�γ�
 */
public interface Edu_CourseDao {
	
	/**
	 *����Map�����е����ݲ�ѯ�γ�
	 */
	List<Edu_Course>getAllEnd_Course(Map map);
	
	List<Edu_Course>getAllCourse(Map map);

	Edu_Course getCourseByID(int id);
	
	void updateCourse(Edu_Course course);
	void deleteTeacherByID(int id);
	void insertCourse_Thacher(@Param("id")int id,@Param("tid")int tid);
	void insertCourse(Edu_Course course);
    Edu_Course getCourseNameRepeat(String courseName);
	
	List<Edu_Course> getTeaByID(int id);
	
	List<Edu_Course>getAllCourseBySubjectParentid(Map map);
	
	List<Edu_Course> getSunjectNextAllCourse(int id);
	
	List<Users>getCourseNextAllUser(int id);
	
	void deleteCourseByID(int id);

}
