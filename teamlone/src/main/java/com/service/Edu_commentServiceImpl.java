package com.service;

import java.util.List;

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

}
