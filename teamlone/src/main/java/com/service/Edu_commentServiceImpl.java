package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Comment;
import com.mapper.Edu_commentDao;
@Service
public class Edu_commentServiceImpl implements Edu_commentService{

	@Autowired
	private Edu_commentDao edu_comment;
	
	@Override
	public List<Comment> getcomment(int otherId) {
		return edu_comment.getcomment(otherId);
	}

	@Override
	public void insertComment(Map map) {
		edu_comment.insertComment(map);
	}

	@Override
	public List<Comment> getcommentpcomm(Map map) {
		return edu_comment.getcommentpcomm(map);
	}

	@Override
	public void savelikess(int targetId) {
		edu_comment.savelikess(targetId);
	}

	@Override
	public void saveconut(int targetId) {
		// TODO Auto-generated method stub
		edu_comment.saveconut(targetId);
	}

}
