package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Function;
import com.mapper.FunctionDao;

@Service
public class FunctionServiceImpl implements FunctionService {
	
	@Autowired
	FunctionDao functionDao;
	@Override
	public List<Function> getListAll() {
		// TODO Auto-generated method stub
		return functionDao.getListAll();
	}

}
