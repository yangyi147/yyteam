package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Role_Fuction;
import com.mapper.Role_FuctionDao;
@Service
public class Role_FuctionServiceImpl implements Role_FuctionService {

	@Autowired
	Role_FuctionDao role_FuctionDao;
	/* (non-Javadoc)
	 *按照角色id查询所有权限
	 */
	@Override
	public List<Role_Fuction> getAllRole_FuctionByID(int id) {
		// TODO Auto-generated method stub
		return role_FuctionDao.getAllRole_FuctionByID(id);
	}
	/* (non-Javadoc)
	 * @see com.service.Role_FuctionService#insertRole_function(int, java.lang.String)
	 * 添加角色权限
	 * 
	 */
	@Override
	public void insertRole_function(int id, String str) {
		role_FuctionDao.deleteRole_FunctionById(id);
		String[] split = str.split(",");
		int [] ids=new int[split.length];
		for (int i = 0; i < split.length; i++) {
			int pid=Integer.parseInt(split[i]);
			role_FuctionDao.insertRole_function(id, pid);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.service.Role_FuctionService#deleteRole_FunctionById(int)
	 * 按照角色id删除权限
	 */
	@Override
	public void deleteRole_FunctionById(int id) {
		// TODO Auto-generated method stub
		role_FuctionDao.deleteRole_FunctionById(id);
	}

}
