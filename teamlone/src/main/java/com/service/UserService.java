package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Users;
import com.github.pagehelper.PageInfo;



public interface UserService {
	 void insave(Users users);
     void update(Users users);
     Users getById(int id);
     void updateid(Users users);
     public int getCount(Map map);
	List<Users> getlistAll(Map map);
	List<Users> getListAlls();
    Users getPwd(String userName);
	 void addUser(Users user);
	 void updateAll(Users users);
}
