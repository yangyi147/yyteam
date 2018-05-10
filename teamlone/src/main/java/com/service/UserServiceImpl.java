package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    UserDao userdao;
//	private int pagesize=5;
	@Override
	public void insave(Users users) {
		// TODO Auto-generated method stub
		 userdao.insave(users);
	}

	@Override
	public List<Users> getlistAll(Map map) {
		// TODO Auto-generated method stub
//		PageHelper.offsetPage(page, pagesize);
		
//		PageInfo<Users> ph=new PageInfo<Users>(map);
		return  userdao.getlistAll(map);
		
	}

	@Override
	public void update(Users users) {
		// TODO Auto-generated method stub
		userdao.update(users);
		
	}

	@Override
	public Users getById(int id) {
		// TODO Auto-generated method stub
		Users users = userdao.getById(id);
		return users;
	}

	@Override
	public void updateid(Users users) {
		// TODO Auto-generated method stub
		userdao.updateid(users);;
	}

	@Override
	public int getCount(Map map) {
		// TODO Auto-generated method stub
		return userdao.getCount(map);
	}

	@Override
	public List<Users> getListAlls() {
		// TODO Auto-generated method stub
		return userdao.getListAlls();
	}

	@Override
	public Users getPwd(String userName) {
		// TODO Auto-generated method stub
		return userdao.getPwd(userName);
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}









}
