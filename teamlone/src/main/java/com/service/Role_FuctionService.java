package com.service;

import java.util.List;

import com.bean.Role_Fuction;

public interface Role_FuctionService {
	
	List<Role_Fuction> getAllRole_FuctionByID(int id);
	
	void insertRole_function(int id,String str);
	
	void deleteRole_FunctionById(int id);

}
