package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Subjects;
import com.mapper.SubjectsDao;

@Service
public class SubjectsServiceImpl implements SubjectsService {

	
	@Autowired
	private SubjectsDao subectsDao;
	
	@Override
	public Subjects getById( int id) {
		// TODO Auto-generated method stub
		return subectsDao.getById( id);
	}

	@Override
	public List<Subjects> getListAll() {
		// TODO Auto-generated method stub
		return subectsDao.getListAll();
	}

	

}
