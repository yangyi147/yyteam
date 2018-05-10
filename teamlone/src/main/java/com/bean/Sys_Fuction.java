package com.bean;

import java.util.Date;

public class Sys_Fuction {
	
	private int id;
	
	private int pId;
	
	private String name;
	
	private String function_url;
	
	private int function_type;
	
	private Date create_time;
	
	private int sort;
	
	private String checked;
	
	

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction_url() {
		return function_url;
	}

	public void setFunction_url(String function_url) {
		this.function_url = function_url;
	}

	public int getFunction_type() {
		return function_type;
	}

	public void setFunction_type(int function_type) {
		this.function_type = function_type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Sys_Fuction [id=" + id + ", pId=" + pId + ", name=" + name + ", function_url=" + function_url
				+ ", function_type=" + function_type + ", create_time=" + create_time + ", sort=" + sort + ", checked="
				+ checked + "]";
	}


	

}
