package com.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Course;
import com.bean.Sys_Subject;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.Edu_CourseDao;

import net.sf.ehcache.search.expression.And;

@Service
public class Edu_CourseServiceImpl implements Edu_CourseService {

	@Autowired
	Edu_CourseDao courseDao;
	@Autowired
	Sys_Subject subject;
	//	@Value("${zh.pagesize}")
	private int pagesize=4;
	@Override

	/**
	 * @param map
	 * @param page
	 * @return
	 * 按条件分页分页
	 */public PageInfo<Edu_Course> getAllEnd_Course(Map map,int page) {
		 PageHelper.startPage(page,pagesize);
		 List<Edu_Course> allEnd_Course = courseDao.getAllEnd_Course(map);
		 PageInfo<Edu_Course> p=new PageInfo<Edu_Course>(allEnd_Course);
		 return p;
	 }
	 @Override
	 /**
	  *按照id查询课程
	  */
	 public Edu_Course getCourseByID(int id) {
		 return courseDao.getCourseByID(id);
	 }
	 @Override
	 public void editChapter(MultipartFile file, Edu_Course course, String end_times,String ssid, int tid,
			 HttpServletRequest request) {
		 String pathRoot = request.getSession().getServletContext().getRealPath("images"); 
		 String path="";  
		 if(!file.isEmpty()){  
			 //生成uuid作为文件名称  
			 String uuid = UUID.randomUUID().toString().replaceAll("-","");  
			 //获得文件类型（可以判断如果不是图片，禁止上传）  
			 String contentType=file.getContentType();  
			 //获得文件后缀名称  
			 String imageName=contentType.substring(contentType.indexOf("/")+1);  
			 path="/upload/article/zhanghao/"+uuid+"."+imageName;  
			 try {
				 file.transferTo(new File(pathRoot+path));
			 } catch (Exception e) {
				 e.printStackTrace();
			 } 
			 course.setLogo("/images"+path);
		 }  
		 System.out.println(pathRoot+path);  
		 
		 if (ssid!=null&&ssid.trim().length()>0) {
			 String sid=ssid.replace(" ", "");
			 subject.setId(Integer.parseInt(sid));
		 }
		 course.setSubject(subject);
		 courseDao.updateCourse(course);  
		 deleteTeacherByID(course.getCourse_id());
		 insertCourse_Thacher(course.getCourse_id(),tid);
	 }
	 @Override
	 public void deleteTeacherByID(int id) {
		 courseDao.deleteTeacherByID(id);

	 }
	 @Override
	 public void insertCourse_Thacher(int id, int tid) {
		 courseDao.insertCourse_Thacher(id, tid);

	 }
	@Override
	public void insertCourse(MultipartFile file, Edu_Course course, String end_times, int tid, String ssid,
			HttpServletRequest request) {
		 String pathRoot = request.getSession().getServletContext().getRealPath("images"); 
		 String path="";  
		 if(!file.isEmpty()){  
			 //生成uuid作为文件名称  
			 String uuid = UUID.randomUUID().toString().replaceAll("-","");  
			 //获得文件类型（可以判断如果不是图片，禁止上传）  
			 String contentType=file.getContentType();  
			 //获得文件后缀名称  
			 String imageName=contentType.substring(contentType.indexOf("/")+1);  
			 path="/upload/article/zhanghao/"+uuid+"."+imageName;  
			 try {
				 file.transferTo(new File(pathRoot+path));
			 } catch (Exception e) {
				 e.printStackTrace();
			 }  
		 }  
		 
		 course.setLogo("/images"+path);
		 if (ssid!=null&&ssid.trim().length()>0) {
			 String sid=ssid.replace(" ", "");
			 subject.setId(Integer.parseInt(ssid));
		 }
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         try {
			course.setAdd_time(new Date());
			if(end_times!=null&&end_times.trim().length()>0){
				course.setEnd_time(formatter.parse(end_times));
			}
			course.setUpdate_time(new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
	
         System.out.println("course:"+course);
		courseDao.insertCourse(course);
	    courseDao.insertCourse_Thacher(course.getCourse_id(), tid);
		System.out.println("id:"+course.getCourse_id());
	}
	@Override
	public int getCourseNameRepeat(String courseName) {
		Edu_Course courseNameRepeat = courseDao.getCourseNameRepeat(courseName);
		if (courseNameRepeat==null) {
			return 1;
		}
		return 2;
	}
	@Override
	public List<Edu_Course> getTeaByID(int id) {
		// TODO Auto-generated method stub
		return courseDao.getTeaByID(id);
	}
	@Override
	public List<Edu_Course> getAllCourse(Map map) {
		if (map.get("sid")!=null&&map.get("sfid")==null) {
		 return	getAllCourseBySubjectParentid(map);
		}else {
			return courseDao.getAllCourse(map);
		}
	}
	@Override
	public List<Edu_Course> getAllCourseBySubjectParentid(Map map) {
		// TODO Auto-generated method stub
		return courseDao.getAllCourseBySubjectParentid(map);
	}
	@Override
	public List<Edu_Course> getSunjectNextAllCourse(int id) {
		// TODO Auto-generated method stub
		return courseDao.getSunjectNextAllCourse(id);
	}
	@Override
	public List<Users> getCourseNextAllUser(int id) {
		// TODO Auto-generated method stub
		return courseDao.getCourseNextAllUser(id);
	}
	@Override
	public void deleteCourseByID(int id) {
		// TODO Auto-generated method stub
		courseDao.deleteCourseByID(id);
	}



}
