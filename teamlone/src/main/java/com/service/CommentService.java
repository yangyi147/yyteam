package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService {
    public PageInfo<Comment> getListAll(Map map,int page);
	public void delCo(int id);
	public void inCom(Comment comment);
}
