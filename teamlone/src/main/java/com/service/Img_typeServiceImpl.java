package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Imges_type;
import com.mapper.ImagesDao;
import com.mapper.Img_typeDao;

@Service
public class Img_typeServiceImpl implements Img_typeService{
	
	@Autowired
	private Img_typeDao img_typeDao;
	@Override
	public List<Imges_type> getlistAll() {
		// TODO Auto-generated method stub
		return img_typeDao.getlistAll();
	}

}
