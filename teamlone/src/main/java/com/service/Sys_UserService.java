package com.service;

import java.util.Set;

import com.bean.Sys_User;

public interface Sys_UserService {
	
	Sys_User getUserByName(String name);
	
	Set<String>getUserByUserName(String name);

}
