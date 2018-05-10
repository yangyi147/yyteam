package com.mapper;

import java.util.List;
import java.util.Map;
import com.bean.Comment;
import com.github.pagehelper.PageInfo;
public interface CommentDao {
	public  List<Comment> getListAll(Map map);
	public void delCo(int id);
	public void inCom(Comment comment);
}
