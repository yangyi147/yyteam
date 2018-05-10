package com.bean;

import java.util.Date;
import java.util.List;

public class Questions {

	private int id;
	private Users edu_user;
	private String title;
	private String content;
	private int type;
	private int status;
    private int reply_count;
    private int browse_count;
    private int praise_count;
    private Date add_time;
    private String start;
    private String end;
    private List<Questions_comment> qc;
	public List<Questions_comment> getQc() {
		return qc;
	}
	public void setQc(List<Questions_comment> qc) {
		this.qc = qc;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Users getEdu_user() {
		return edu_user;
	}
	public void setEdu_user(Users edu_user) {
		this.edu_user = edu_user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getBrowse_count() {
		return browse_count;
	}
	public void setBrowse_count(int browse_count) {
		this.browse_count = browse_count;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", edu_user=" + edu_user + ", title=" + title + ", content=" + content
				+ ", type=" + type + ", status=" + status + ", reply_count=" + reply_count + ", browse_count="
				+ browse_count + ", praise_count=" + praise_count + ", add_time=" + add_time + ", start=" + start
				+ ", end=" + end + ", qc=" + qc + "]";
	}
	
}
