package com.service;

import java.util.List;
import java.util.Set;

import com.bean.Sys_Fuction;

public interface Sys_FuctionService {
	
	List<Sys_Fuction> getAllSys_Fuction();
	
	void updateSys_Fuction(Sys_Fuction fuction);
	
	Set<String> getAllFuctionByRoleId(int id);
	
	List<Sys_Fuction>getAllFuctionByUserID(int id);
	
	int insertSys_Function(Sys_Fuction fuction);
	
	void daleteSys_Function(int id);
	
	List<Sys_Fuction>getSys_FunctionByPid(int id);

}
