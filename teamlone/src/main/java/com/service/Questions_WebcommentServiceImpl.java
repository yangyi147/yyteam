package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Questions_Webcomment;
import com.mapper.Questions_WebcommentMapper;
@Service
public class Questions_WebcommentServiceImpl implements Questions_WebcommentService{

	@Autowired
	private Questions_WebcommentMapper Questions_commentMapper;
	@Override
	public List<Questions_Webcomment> getlistAll(Map map) {
		return Questions_commentMapper.getlistAll(map);
	}

	

	@Override
	public Questions_Webcomment getById(int id) {
		return Questions_commentMapper.getById(id);
	}

	@Override
	public List<Questions_Webcomment> getById1(int id) {
		return Questions_commentMapper.getById1(id);
	}

	@Override
	public Questions_Webcomment getById2(int id) {
		Questions_commentMapper.getById2(id);
		return Questions_commentMapper.getById2(id);
	}

	@Override
	public List<Questions_Webcomment> getCommentId(int id) {
		// TODO Auto-generated method stub
		return Questions_commentMapper.getCommentId(id);
	}



	@Override
	public void insQc(Questions_Webcomment qc) {
		Questions_commentMapper.insQc(qc);
		
	}



	@Override
	public int selQid(int id) {
		int cid=Questions_commentMapper.selQid(id);
		return cid ;
	}



	@Override
	public void addCount(int id) {
		Questions_commentMapper.addCount(id);
	}

	@Override
	public void upRcount(int id) {
		Questions_commentMapper.upRcount(id);
	}
	
}
