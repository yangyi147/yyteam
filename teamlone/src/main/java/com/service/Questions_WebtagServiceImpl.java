package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Questions_Webtag;
import com.mapper.Questions_WebtagMapper;

@Service
public class Questions_WebtagServiceImpl implements Questions_WebtagService{
	@Autowired
	private Questions_WebtagMapper Questions_tagMapper;
	@Override
	public List<Questions_Webtag> getlistAll() {
		return Questions_tagMapper.getlistAll();
	}
	@Override
	public Questions_Webtag getById(int id) {
		return Questions_tagMapper.getById(id);
	}
	@Override
	public void inTag(Map map) {
		Questions_tagMapper.inTag(map);
	}


}
