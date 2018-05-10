package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bean.Comment;
import com.bean.Images;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CommentDao;

@Service
class CommentServiceImpl implements  CommentService {
	@Value("${pagesize}")
	private int pagesize;
	@Autowired 
	private  CommentDao commentDao;
	@Override
	public PageInfo<Comment> getListAll(Map map, int page) {
		PageHelper.startPage(page,pagesize);
		List<Comment> ct=commentDao.getListAll(map);
		System.out.println(ct);
		 PageInfo<Comment> info= new PageInfo<>(ct, page);
		return info;
	}
	@Override
	public void delCo(int id) {
           commentDao.delCo(id);		
	}
	@Override
	public void inCom(Comment comment) {
		commentDao.inCom(comment);
	}
}
