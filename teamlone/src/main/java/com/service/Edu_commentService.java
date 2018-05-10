package com.service;

import java.util.List;

import com.bean.Comment;

public interface Edu_commentService {
	public List<Comment> getcomment(int otherId);
}
