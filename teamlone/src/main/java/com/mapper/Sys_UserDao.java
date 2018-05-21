package com.mapper;

import java.util.List;

import com.bean.Sys_Subject;
import com.bean.Sys_User;

public interface Sys_UserDao {
	
	Sys_User getUserByName(String name);
	
	List<Sys_User>getAllUser();
	
	int updateUser(Sys_User user);
	
	Sys_User getUserByID(int id);
	
	void insertUser(Sys_User user);
	
	String checkRepeat(Sys_User user);
	
	void updateStateByID(Sys_User user);
	
	void deleteUser(int id);
	
	void updateSubject(Sys_Subject subject);

}
