package com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.Sys_User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface Sys_UserService {
	
	Sys_User getUserByName(String name);
	
	Set<String>getUserByUserName(String name);
	
	PageInfo<Sys_User>getAllUser(Map map,int page);

}
