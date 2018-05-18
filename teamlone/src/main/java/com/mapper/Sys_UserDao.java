package com.mapper;

import java.util.List;

import com.bean.Sys_User;

public interface Sys_UserDao {
	
	Sys_User getUserByName(String name);
	
	List<Sys_User>getAllUser();

}
