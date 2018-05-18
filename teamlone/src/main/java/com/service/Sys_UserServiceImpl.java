package com.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Sys_Role;
import com.bean.Sys_User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.Sys_UserDao;
@Service
public class Sys_UserServiceImpl implements Sys_UserService {

	@Autowired
	Sys_UserDao userDao;
	@Autowired
	Sys_UserService userService;
	private int pagesize=2;
	/* (zh)
	 * 按照name查询用户
	 */
	@Override
	public Sys_User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}
	/* (zh)
	 *按照name查询用户
	 */
	@Override
	public Set<String> getUserByUserName(String name) {
		Sys_User userByName = userService.getUserByName(name);
		Set<String> str=new HashSet<>();
		str.add(userByName.getLogin_name());
		return str;
	}
	@Override
	public PageInfo<Sys_User> getAllUser(Map map,int page) {
		
		PageHelper.startPage(page,pagesize);
		List<Sys_User> allUser = userDao.getAllUser();
	
		PageInfo<Sys_User>user=new PageInfo<Sys_User>(allUser);
		return  user;
	}
	@Override
	public int updateUser(Sys_User user,Sys_Role role) {
		user.setRoel(role);
		String md5 = getMD5(user);
		user.setLogin_pwd(md5);
		System.out.println("user:"+user);
		return userDao.updateUser(user);
	}
	@Override
	public String getMD5(Sys_User user) {
		String hashAlgorithName="MD5";
		String pass=user.getLogin_pwd();
		Object salt=ByteSource.Util.bytes(user.getLogin_name());
		int count=1024;
		ByteSource slat=new ByteSource.Util().bytes(user.getLogin_name());
		Object result=new SimpleHash(hashAlgorithName, pass,salt,count);
		String pwd=result+"";
		System.out.println("result:"+pwd);
		return pwd;
	}
	@Override
	public Sys_User getUserByID(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserByID(id);
	}
	@Override
	public void insertUser(Sys_User user,Sys_Role role) {
		String md5 = getMD5(user);
		user.setLogin_pwd(md5);
		user.setRoel(role);
		user.setCreate_time(new Date());
		 userDao.insertUser(user);
	}

}
