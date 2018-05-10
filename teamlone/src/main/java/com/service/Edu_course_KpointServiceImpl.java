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
import org.springframework.web.multipart.MultipartFile;

import com.bean.Edu_Teacher;
import com.bean.Edu_course_Kpoint;
import com.mapper.Edu_course_KpointDao;
import com.util.JsonUtils;
@Service
public class Edu_course_KpointServiceImpl implements Edu_course_KpointService {

	
	@Autowired
	Edu_course_KpointDao course_KpintService;
	@Autowired
	Edu_Teacher teacher;
	/* (zh)
	 * ���տγ�id��ѯ�γ̽ڵ�
	 */
	@Override
	public List<Edu_course_Kpoint> getAllEdu_course_KpointByCourseID(int id) {
		// TODO Auto-generated method stub
		return course_KpintService.getAllEdu_course_KpointByCourseID(id);
	}
	@Override
	public void insertCourseKpoint(Edu_course_Kpoint courseKpoint,int tid) {
		teacher.setId(tid);
		courseKpoint.setTeacher(teacher);
		courseKpoint.setAdd_time(new Date());
		course_KpintService.insertCourseKpoint(courseKpoint);
	}
	@Override
	public Edu_course_Kpoint getEdu_course_Kpoint(Edu_course_Kpoint courseKpoint) {
		// TODO Auto-generated method stub
		return course_KpintService.getEdu_course_Kpoint(courseKpoint);
	}
	@Override
	public String readSchedule(MultipartFile files,HttpServletRequest request) {
		 Hashtable ProgressSingleton=new Hashtable<>();
		// DiskFileItemFactory factory = new DiskFileItemFactory();
		          int sizeThreshold=4*1024;
		          
		          ServletFileUpload upload = new ServletFileUpload();
		          
		          List<FileItem> fileItems;
		          try {
		              fileItems = upload.parseRequest(new ServletRequestContext(request));
		              //��ȡ�ļ���
		              FileItem fileItem = fileItems.get(0);
		              //ʹ��sessionid + �ļ��������ļ���
		              String id = request.getSession().getId() + fileItem.getName();
		              //������ϣ��д���ļ����Ⱥͳ�ʼ����
		              ProgressSingleton.put(id + "Size", fileItem.getSize());
		              //�ļ����ȳ���
		              long progress = 0;
		              //�����ķ�ʽ��ȡ�ļ����Ա����ʵʱ�Ļ�ȡ����
		              InputStream in = fileItem.getInputStream();
		              File file = new File("G:/git/TeamOnle/teamlone/src/main/webapp/video");
		              file.createNewFile();
		              FileOutputStream out = new FileOutputStream(file);
		              byte[] buffer = new byte[1024];
		              int readNumber = 0;
		              while((readNumber = in.read(buffer)) != -1){
		                  //ÿ��ȡһ�Σ�����һ�ν��ȴ�С
		                  progress = progress + readNumber;
		                 //������ϣ��д�����
		                  ProgressSingleton.put(id + "Progress", progress);
		                  out.write(buffer);
		              }
		              //���ļ��ϴ����֮�󣬴ӵ������Ƴ��˴��ϴ���״̬��Ϣ
		              ProgressSingleton.remove(id + "Size");
		              ProgressSingleton.remove(id + "Progress");
		              in.close();
		              out.close();
		         } catch (Exception e) {
		              e.printStackTrace();
		          }
		          
		         return "done";
		
		
	}
	@Override
	public String storeVideo(MultipartFile file,HttpServletRequest request) {
		
		return "";
	}

}
