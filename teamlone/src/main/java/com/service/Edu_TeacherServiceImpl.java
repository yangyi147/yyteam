package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Teacher;
import com.mapper.Edu_TeacherDao;
@Service
public class Edu_TeacherServiceImpl implements Edu_TeacherService {

	@Autowired
	 Edu_TeacherDao teacherDao;
	@Override
	
	/**
	 *�������н�ʦ
	 *c
	 */
	public List<Edu_Teacher> getAllTeacherBySubjectId() {
		// TODO Auto-generated method stub
		return teacherDao.getAllTeacherBySubjectId();
	}
	@Override
	public List<Edu_Teacher> getAllTeacherByMap(Map map) {
		
		return teacherDao.getAllTeacherByMap(map);
	}
	@Override
	public List<Edu_Teacher> getTeacherById(int id) {
			return teacherDao.getTeacherById(id);
	}
	@Override
	public List<Edu_Teacher> getSubjectNextAllTeacher(int id) {
		// TODO Auto-generated method stub
		return teacherDao.getSubjectNextAllTeacher(id);
	}
	

}
