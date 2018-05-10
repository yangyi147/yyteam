package com.mapper;

import java.util.List;

import com.bean.Comment;

public interface Edu_commentDao {
	public List<Comment> getcomment(int otherId);
}
