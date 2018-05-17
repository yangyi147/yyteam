package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Users;



public interface UserDao {
	  void insave(Users users);
      List<Users> getlistAll(Map map);
      void update(Users users);
      Users getById(int id);
      void updateid(Users users);
      int getCount(Map map);
      List<Users> getListAlls();
  	  Users getPwd(String userName);
	  void addUser(Users user);
	  void updateAll(Users users);
}
