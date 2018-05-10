package com.bean;

import java.util.Date;

public class EClass {
      private int id;
      private String cname;
      private String cyear;
      private Date update_time;
      private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCyear() {
		return cyear;
	}
	public void setCyear(String cyear) {
		this.cyear = cyear;
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
		return "Edu_Class [id=" + id + ", cname=" + cname + ", cyear=" + cyear + ", update_time=" + update_time
				+ ", status=" + status + "]";
	}
      
}
