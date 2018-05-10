package com.bean;

import java.util.Date;

public class Teacher {
	private int id;
	private String name;
	private String th_name;
	private String th_pw;
	private String education;
	private String career;
	private int is_star;
	private String pic_path;
	private int status;
	private Date create_time;
	private Date update_time;
	private Sys_Subject subject_id;
	private int sort;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTh_name() {
		return th_name;
	}
	public void setTh_name(String th_name) {
		this.th_name = th_name;
	}
	public String getTh_pw() {
		return th_pw;
	}
	public void setTh_pw(String th_pw) {
		this.th_pw = th_pw;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getIs_star() {
		return is_star;
	}
	public void setIs_star(int is_star) {
		this.is_star = is_star;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Sys_Subject getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Sys_Subject subject_id) {
		this.subject_id = subject_id;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", th_name=" + th_name + ", th_pw=" + th_pw + ", education="
				+ education + ", career=" + career + ", is_star=" + is_star + ", pic_path=" + pic_path + ", status="
				+ status + ", create_time=" + create_time + ", update_time=" + update_time + ", subject_id="
				+ subject_id + ", sort=" + sort + "]";
	}
}
