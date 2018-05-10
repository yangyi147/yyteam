package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EClass;
import com.bean.Users;
import com.mapper.Edu_ClassDao;

@Service
public class EclassServiceImpl implements EclassService{
	@Autowired
     Edu_ClassDao classdao;

	@Override
	public List<EClass> getlistAll() {
		// TODO Auto-generated method stub
		List<EClass> list = classdao.getlistAll();
		return list;
	}

	@Override
	public EClass getById(int id) {
		// TODO Auto-generated method stub
		EClass eClass = classdao.getById(id);
		return eClass;
	}

    
}
