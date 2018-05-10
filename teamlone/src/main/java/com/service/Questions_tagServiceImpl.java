package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Questions_tag;
import com.mapper.Questions_tagMapper;

@Service
public class Questions_tagServiceImpl implements Questions_tagService{

	@Autowired
	private Questions_tagMapper Questions_tagMapper;
	@Override
	public List<Questions_tag> getlistAll() {
		return Questions_tagMapper.getlistAll();
	}
	@Override
	public void save(Questions_tag tag) {
		Questions_tagMapper.insert(tag);
		
	}
	@Override
	public void update(Questions_tag tag) {
		Questions_tagMapper.update(tag);
		
	}
	@Override
	public Questions_tag getById(int id) {
		return Questions_tagMapper.getById(id);
	}
	@Override
	public void updateStatus(int id) {
		Questions_tagMapper.updateStatus(id);
	}

}
