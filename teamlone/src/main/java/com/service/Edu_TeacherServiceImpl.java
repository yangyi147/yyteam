package com.service;

import java.util.List;

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

}
