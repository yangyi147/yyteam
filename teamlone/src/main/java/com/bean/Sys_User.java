package com.bean;

import java.util.Date;

public class Sys_User {
	
	private int  user_id;

	private String login_name;
	
	private String login_pwd;
	
	private String user_name;
	
	private  int  status;
	
	private Date last_login_time;
	
	private String last_login_ip;
	
	private Date rcreat_time;
	
	private String email;
	
	private String tel;
	
	private Sys_Role roel;


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public Date getRcreat_time() {
		return rcreat_time;
	}

	public void setRcreat_time(Date rcreat_time) {
		this.rcreat_time = rcreat_time;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Sys_Role getRoel() {
		return roel;
	}

	public void setRoel(Sys_Role roel) {
		this.roel = roel;
	}

	@Override
	public String toString() {
		return "Sys_User [user_id=" + user_id + ", login_name=" + login_name + ", login_pwd=" + login_pwd
				+ ", user_name=" + user_name + ", status=" + status + ", last_login_time=" + last_login_time
				+ ", last_login_ip=" + last_login_ip + ", rcreat_time=" + rcreat_time + ", email=" + email + ", tel="
				+ tel + ", roel=" + roel + "]";
	}


	
	
	
}
