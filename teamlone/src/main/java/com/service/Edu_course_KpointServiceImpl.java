package com.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Teacher;
import com.bean.Edu_course_Kpoint;
import com.mapper.Edu_course_KpointDao;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
@Service
public class Edu_course_KpointServiceImpl implements Edu_course_KpointService {

	
	@Autowired
	Edu_course_KpointDao course_KpintDao;
	@Autowired
	Edu_Teacher teacher;
	/* (zh)
	 * ���տγ�id��ѯ�γ̽ڵ�
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
		Edu_course_Kpoint videoByID = course_KpintDao.getVideoByID(courseKpoint.getId());
		String path=request.getRealPath("/");
		File file=new File(path+videoByID.getVideo_url());
		file.delete();
		
		courseKpoint.setVideo_url("/video/"+courseKpoint.getVideo_url());
		String readVideoTime = ReadVideoTime(new File(path+courseKpoint.getVideo_url()));
		courseKpoint.setPlay_time(readVideoTime);
		course_KpintDao.updateCourseKpoint(courseKpoint);
		
		
		         // course_KpintDao.updateCourseKpoint(courseKpoint);;
	}
	private String ReadVideoTime(File source) {
		Encoder encoder = new Encoder();
		String length = "";
		try {
		MultimediaInfo m = encoder.getInfo(source);
		long ls = m.getDuration()/1000;
		System.out.println("ls:"+ls);
		int hour = (int) (ls/3600);
		int minute = (int) (ls%3600)/60;
		int second = (int) (ls-hour*3600-minute*60);
	    if (hour!=0) {
	    	length = hour+"."+minute+"."+second;
		}
	    if (hour==0&&minute!=0) {
	    	length = minute+"."+second;
		}
	    if (hour==0&&minute==0&&second!=0) {
	    	length = second+"";
			
		}

		} catch (Exception e) {
		e.printStackTrace();
		}
		return length;
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
	@Override
	public int getCourseKpointMinIDByCourseID(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getCourseKpointMinIDByCourseID(id);
	}
	@Override
	public Edu_course_Kpoint getVideoByID(int id) {
		// TODO Auto-generated method stub
		return course_KpintDao.getVideoByID(id);
	}


}
