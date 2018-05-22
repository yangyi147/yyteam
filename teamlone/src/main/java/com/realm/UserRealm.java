package com.realm;

import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bean.Sys_User;
import com.service.Sys_FuctionService;
import com.service.Sys_UserService;



public class UserRealm extends AuthorizingRealm{

	@Autowired
	Sys_UserService userService;
	@Autowired
	Sys_FuctionService fuctionService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String name=(String)principals.getPrimaryPrincipal();
		Sys_User users=userService.getUserByName(name);
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		//��װ��ɫ����
		authorizationInfo.setRoles(userService.getUserByUserName(name));
		//��װ��ɫ��Ӧ��Ȩ�޼���
		System.out.println("doGetAuthorizationInfo:"+fuctionService.getAllFuctionByRoleId(users.getUser_id()));
		authorizationInfo.setStringPermissions(fuctionService.getAllFuctionByRoleId(users.getUser_id()));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String uname=(String)token.getPrincipal();
		System.out.println("uname:"+uname);
	    Sys_User user=new Sys_User();
		user.setLogin_name(uname);
		System.out.println("user.uanme:"+user.getLogin_name());
		Sys_User uSerById = userService.getUserByName(uname);
		System.out.println("uSerById:"+uSerById);
		if (uSerById==null) {
            return null;			
		}
		System.out.println(1246454);
		ByteSource slat=new ByteSource.Util().bytes(uname);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(uname,uSerById.getLogin_pwd(),slat,getName());
		System.out.println("===============================================");
		System.out.println("info:"+info);
		return info;
	}



}
