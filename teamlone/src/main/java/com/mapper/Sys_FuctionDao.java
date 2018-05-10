package com.mapper;

import java.util.List;

import com.bean.Sys_Fuction;

/**
 * @author lenovo
 *È¨ÏÞ±í
 */
public interface Sys_FuctionDao {
	

	List<Sys_Fuction> getAllSys_Fuction();
	
	void updateSys_Fuction(Sys_Fuction fuction);

	List<Sys_Fuction> getAllFuctionByRoleId(int id);
	
	List<Sys_Fuction>getAllFuctionByUserID(int id);
	
	int insertSys_Function(Sys_Fuction fuction);

	void daleteSys_Function(int id);
	
	List<Sys_Fuction>getSys_FunctionByPid(int id);
	
}
