package com.bean;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Edu_Course_Note {
	
	private int id;
	
	private Users users;
	
	private int course_id;
	
	private int kpoint_id;
	
	private String content;
	
	private Date update_time;
	
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getKpoint_id() {
		return kpoint_id;
	}

	public void setKpoint_id(int kpoint_id) {
		this.kpoint_id = kpoint_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Edu_Course_Note [id=" + id + ", users=" + users + ", course_id=" + course_id + ", kpoint_id="
				+ kpoint_id + ", content=" + content + ", update_time=" + update_time + ", status=" + status + "]";
	}
	
	


}
