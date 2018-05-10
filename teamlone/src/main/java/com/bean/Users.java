package com.bean;

import java.util.Date;

public class Users {
      private int user_id;
      private String  mobile;
      private String email;
      private EClass id;
      private String  password;
      private String user_name;
      private String  show_name;
      private int sex;
      private int age;
      private Date create_time;
      private int is_avalible;
      private String pic_img;
      private  String banner_url;
      private int  msg_num;
      private int  sys_msg_num;
      private Date last_system_time;
      private String end;
      private String start;
      
      
	  public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EClass getId() {
		return id;
	}
	public void setId(EClass id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getIs_avalible() {
		return is_avalible;
	}
	public void setIs_avalible(int is_avalible) {
		this.is_avalible = is_avalible;
	}

	public String getBanner_url() {
		return banner_url;
	}
	public void setBanner_url(String banner_url) {
		this.banner_url = banner_url;
	}
	public int getMsg_num() {
		return msg_num;
	}
	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}
	public int getSys_msg_num() {
		return sys_msg_num;
	}
	public void setSys_msg_num(int sys_msg_num) {
		this.sys_msg_num = sys_msg_num;
	}
	public Date getLast_system_time() {
		return last_system_time;
	}
	public void setLast_system_time(Date last_system_time) {
		this.last_system_time = last_system_time;
	}
	public String getPic_img() {
		return pic_img;
	}
	public void setPic_img(String pic_img) {
		this.pic_img = pic_img;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", mobile=" + mobile + ", email=" + email + ", id=" + id + ", password="
				+ password + ", user_name=" + user_name + ", show_name=" + show_name + ", sex=" + sex + ", age=" + age
				+ ", create_time=" + create_time + ", is_avalible=" + is_avalible + ", pic_img=" + pic_img
				+ ", banner_url=" + banner_url + ", msg_num=" + msg_num + ", sys_msg_num=" + sys_msg_num
				+ ", last_system_time=" + last_system_time + "]";
	}
}
