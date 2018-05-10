package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_questions;
import com.mapper.Edu_questionsDao;

@Service
public class Edu_questionsServiceImpl implements Edu_questionsService {
	
	@Autowired
	private Edu_questionsDao edu_questionsDao;

	@Override
	public List<Edu_questions> getListAll(Math map) {
		// TODO Auto-generated method stub
		return edu_questionsDao.getListAll(map);
	}

	@Override
	public Edu_questions getById(int id) {
		// TODO Auto-generated method stub
		return edu_questionsDao.getById(id);
	}

	@Override
	public void delQues(int id) {
		// TODO Auto-generated method stub
		edu_questionsDao.delQues(id);
	}
	@Override
	public void inQues(Edu_questions edu_questions) {
		// TODO Auto-generated method stub
		edu_questionsDao.inQues(edu_questions);
	}
	@Override
	public void upQues(Edu_questions edu_questions) {
		// TODO Auto-generated method stub
		upQues(edu_questions);
	}
}
