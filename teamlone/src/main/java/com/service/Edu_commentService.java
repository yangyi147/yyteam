package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Comment;

public interface Edu_commentService {
	public List<Comment> getcomment(int otherId);
	public void insertComment(Map map);
	
	public List<Comment> getcommentpcomm(Map map);
	public void savelikess(int targetId);
	public void saveconut(int targetId);
}
