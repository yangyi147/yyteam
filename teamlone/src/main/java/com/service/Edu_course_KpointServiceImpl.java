package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Edu_Teacher;
import com.bean.Edu_course_Kpoint;
import com.mapper.Edu_course_KpointDao;
import com.util.JsonUtils;
@Service
public class Edu_course_KpointServiceImpl implements Edu_course_KpointService {

	
	@Autowired
	Edu_course_KpointDao course_KpintDao;
	@Autowired
	Edu_Teacher teacher;
	/* (zh)
	 * 按照课程id查询课程节点
	 */
	@Override
	public List<Edu_course_Kpoint> getAllEdu_course_KpointByCourseID(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getAllEdu_course_KpointByCourseID(id);
	}
	@Override
	public void insertCourseKpoint(Edu_course_Kpoint courseKpoint,int tid) {
		teacher.setId(tid);
		courseKpoint.setTeacher(teacher);
		courseKpoint.setAdd_time(new Date());
		course_KpintDao.insertCourseKpoint(courseKpoint);
	}
	@Override
	public Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint) {
		// TODO Auto-generated method stub
		return course_KpintDao.getEdu_course_Kpoint(courseKpoint);
	}
	@Override
	public void storageUrl(HttpServletRequest request,Edu_course_Kpoint courseKpoint) {
		courseKpoint.setVideo_url("/video/"+courseKpoint.getVideo_url());
		course_KpintDao.updateCourseKpoint(courseKpoint);
		
		
		         // course_KpintDao.updateCourseKpoint(courseKpoint);;
	}
	@Override
	public String storeVideo(MultipartFile file,HttpServletRequest request) {
		
		return "";
	}
	@Override
	public List<Edu_course_Kpoint> getCourseKpoint(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpoint(id);
	}
	@Override
	public List<Edu_course_Kpoint> getCourseKpointAllVideo(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpointAllVideo(id);
	}
	@Override
	public Edu_course_Kpoint getCourseKpointByID(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpointByID(id);
	}
	@Override
	public Edu_course_Kpoint getCourseKponintByKpointId(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKponintByKpointId(id);
	}
	@Override
	public Edu_course_Kpoint getCourseKpointNameById(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpointNameById(id);
	}
	@Override
	public Edu_course_Kpoint getCourseKpointByCourseId(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpointByCourseId(id);
	}


}
