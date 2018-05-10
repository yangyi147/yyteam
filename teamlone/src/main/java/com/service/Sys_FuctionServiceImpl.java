package com.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.portable.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Sys_Fuction;
import com.mapper.FunctionDao;
import com.mapper.Sys_FuctionDao;
@Service
public class Sys_FuctionServiceImpl implements Sys_FuctionService {

	@Autowired
	Sys_FuctionDao fuctionDao;
	/* (non-Javadoc)
	 * 查询所有权限信息
	 */
	@Override
	public List<Sys_Fuction> getAllSys_Fuction() {
		// TODO Auto-generated method stub
		return fuctionDao.getAllSys_Fuction();
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_FuctionService#updateSys_Fuction(com.bean.Sys_Fuction)
	 * 修改权限
	 */
	@Override
	public void updateSys_Fuction(Sys_Fuction fuction) {
		// TODO Auto-generated method stub
		fuctionDao.updateSys_Fuction(fuction);
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_FuctionService#getAllFuctionByRoleId(int)
	 * 按照角色id查询该角色下的所有权限
	 */
	@Override
	public Set<String> getAllFuctionByRoleId(int id) {
		List<Sys_Fuction> allFuctionByRoleId = fuctionDao.getAllFuctionByRoleId(id);
		Set<String>str=new HashSet<>();
		for (Sys_Fuction sys_Fuction : allFuctionByRoleId) {
			str.add(sys_Fuction.getFunction_url());
		}
		return str;
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_FuctionService#getAllFuctionByUserID(int)
	 * 按照用户id查询所欲权限
	 */
	@Override
	public List<Sys_Fuction> getAllFuctionByUserID(int id) {
		// TODO Auto-generated method stub
		return fuctionDao.getAllFuctionByUserID(id);
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_FuctionService#insertSys_Function(com.bean.Sys_Fuction)
	 * 添加权限
	 */
	@Override
	public int insertSys_Function(Sys_Fuction fuction) {
		// TODO Auto-generated method stub
		return fuctionDao.insertSys_Function(fuction);
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_FuctionService#daleteSys_Function(int)
	 * 删除权限
	 */
	@Override
	public void daleteSys_Function(int id) {
		fuctionDao.daleteSys_Function(id);
	}
	/* (non-Javadoc)
	 *按照副id查询权限
	 */
	@Override
	public List<Sys_Fuction> getSys_FunctionByPid(int id) {
		List<Sys_Fuction> sys_FunctionByPid = fuctionDao.getSys_FunctionByPid(id);
		if (sys_FunctionByPid.size()>0) {
			return sys_FunctionByPid;
		}else {
			fuctionDao.daleteSys_Function(id);
		}
		return sys_FunctionByPid;
	} 




}
