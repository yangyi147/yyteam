 package com.bean;

import java.util.Date;

import javax.xml.crypto.Data;

public class Subjects {
	private int id;
	private String name;
	private int status;
	private Date create_time;
	private int pId;
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
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", status=" + status + ", create_time=" + create_time
				+ ", pId=" + pId + ", sort=" + sort + "]";
	}
}
