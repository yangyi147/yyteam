package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Sys_Role;
import com.mapper.Sys_RoleDao;
import com.service.Sys_RoleService;
@Service
public class Sys_RoleServiceImpl implements Sys_RoleService {

	@Autowired
	Sys_RoleDao roleDao;
	@Override
	public List<Sys_Role> getAllSys_Role() {
		// TODO Auto-generated method stub
		return roleDao.getAllSys_Role();
	}
	@Override
	public Sys_Role getRoleByID(int id) {
		// TODO Auto-generated method stub
		return roleDao.getRoleByID(id);
	}

}
