package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.Role_Fuction;

public interface Role_FuctionDao {
	
	List<Role_Fuction> getAllRole_FuctionByID(int id);
	
	void insertRole_function(@Param("id")int id,@Param("fid")int fid);
	
	void deleteRole_FunctionById(int id);

}
