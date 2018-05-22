package com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.bean.Sys_Role;
import com.bean.Sys_User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface Sys_UserService {
	
	Sys_User getUserByName(String name);
	
	Set<String>getUserByUserName(String name);
	
	PageInfo<Sys_User>getAllUser(Map map,int page );
	
	String getMD5(Sys_User user);
	
	int updateUser(Sys_User user,Sys_Role role);
	
	Sys_User getUserByID(int id);
	
	void insertUser(Sys_User user,Sys_Role role);
	
	boolean checkRepeat(String name);
	
	void updateStateByID(int id,int status);
	
	void deleteUser(int id);
	
	void updateUserIpTime(Sys_User user);


}
