package com.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_likes;
import com.mapper.Edu_likesDao;
@Service
public class Edu_likesServicelmpl implements Edu_likesService{

	@Autowired
	private Edu_likesDao el;
	
	@Override
	public Edu_likes getLikes(Map map) {
		return el.getLikes(map);
	}

	@Override
	public void saveLikes(Map map) {
		el.saveLikes(map);
	}

}
