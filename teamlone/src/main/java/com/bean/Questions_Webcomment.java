package com.bean;

import java.util.Date;

public class Questions_Webcomment {
	private int id;
	private Users edu_user;
	private String content;
	private int is_best;
	private int reply_count;
	private int praise_count;
	private Date add_time;
	private int comment_id;
	private int question_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIs_best() {
		return is_best;
	}
	public void setIs_best(int is_best) {
		this.is_best = is_best;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
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
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "Questions_Webcomment [id=" + id + ", edu_user=" + edu_user + ", content=" + content + ", is_best="
				+ is_best + ", reply_count=" + reply_count + ", praise_count=" + praise_count + ", add_time=" + add_time
				+ ", comment_id=" + comment_id + ", question_id=" + question_id + "]";
	}

}
