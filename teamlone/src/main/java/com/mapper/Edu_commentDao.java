package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Comment;

public interface Edu_commentDao {
	public List<Comment> getcomment(int otherId);
	public void insertComment(Map map);
	
	public List<Comment> getcommentpcomm(Map map);
}
