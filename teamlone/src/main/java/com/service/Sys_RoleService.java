package com.service;

import java.util.List;

import com.bean.Sys_Role;

public interface Sys_RoleService {
	
	List<Sys_Role> getAllSys_Role();
	
	Sys_Role getRoleByID(int id);

}
