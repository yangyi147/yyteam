package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.util.SavedRequest;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Users;
import com.github.pagehelper.PageInfo;

public interface Edu_CourseService {
	List<Edu_Course> getTeaByID(int id);
	
	PageInfo<Edu_Course>getAllEnd_Course(Map map,int page);
	
	/**
	 * @param id
	 * @return
	 * 
	 */
	Edu_Course getCourseByID(int id);
	
	void editChapter(MultipartFile file, Edu_Course course, String end_times,String ssid, int tid, HttpServletRequest request);
	
	void deleteTeacherByID(int id);
	
	void insertCourse_Thacher(int id,int tid);

	void insertCourse(MultipartFile file,Edu_Course course,String end_times,int tid,String ssid,HttpServletRequest request);
	
	int getCourseNameRepeat(String courseName);
	
	List<Edu_Course>getAllCourse(Map map);
	
	List<Edu_Course>getAllCourseBySubjectParentid(Map  map);
	
	List<Edu_Course> getSunjectNextAllCourse(int id);
	
	List<Users>getCourseNextAllUser(int id);

	void deleteCourseByID(int id);
	
	PageInfo<Edu_Course>getUserCollectionAllVideo(int id,int page);
	
	void deleteCollection(int id,HttpSession session);
	
	void insertCourseCollection(Map map,HttpSession session);
	
	List<String> getCourseStudyhistoryByUserIdCourseId(HttpSession session,int cid);

	
}
