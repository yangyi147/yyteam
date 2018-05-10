package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EClass;
import com.bean.Emailsend;
import com.mapper.EmailsendDao;
@Service
public class EmailsendServiceImpl implements EmailsendDao{
	@Autowired
     EmailsendDao emailDao;

	@Override
	public Emailsend getById(int id) {
		// TODO Auto-generated method stub
		Emailsend emailsend = emailDao.getById(id);
		return emailsend;
	}

	@Override
	public List<Emailsend> getlistAll(Map map) {
		// TODO Auto-generated method stub
		List<Emailsend> list = emailDao.getlistAll(map);
		return list;
	}

	@Override
	public void insave(Emailsend emailsend) {
		// TODO Auto-generated method stub
		  emailDao.insave(emailsend);
	}

	@Override
	public List<Emailsend> getlist(Emailsend emailsend) {
		// TODO Auto-generated method stub
		List<Emailsend> lists = emailDao.getlist(emailsend);
		return lists;
	}


}
