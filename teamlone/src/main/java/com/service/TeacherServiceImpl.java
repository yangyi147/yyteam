package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bean.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.TeacherDao;
@Service
public class TeacherServiceImpl  implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	@Value("${pagesize}")
	private int pagesize;
	@Override
	public PageInfo<Teacher> getlistAll(Map map,int page) {
		PageHelper.startPage(page,pagesize);
		List<Teacher> tc=teacherDao.getListAll(map);
		PageInfo<Teacher> info=new PageInfo<Teacher>(tc);
		return info;
	}
	@Override
	public void inTer(Teacher teacher) {
		teacherDao.inTer(teacher);
	}
	@Override
	public void delTe(int id) {
		teacherDao.delTe(id);
	}
	@Override
	public Teacher getById(int id) {
		// TODO Auto-generated method stub
		return teacherDao.getById(id);
	}

	@Override
	public void upTer(Teacher teacher) {
		teacherDao.upTer(teacher);
	}
}
