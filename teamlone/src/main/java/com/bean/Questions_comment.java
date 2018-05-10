package com.bean;

import java.util.Date;
import java.util.List;

public class Questions_comment {

	private int id;
	private Users edu_user;
	private Questions questions;
	private String content;
	private int is_best;
	private int reply_count;
	private int praise_count;
	private Date add_time;
	private int comment_id;
	private String start;
    private String end;
    private List<Questions_tag> questions_tags;
	public List<Questions_tag> getQuestions_tags() {
		return questions_tags;
	}
	public void setQuestions_tags(List<Questions_tag> questions_tags) {
		this.questions_tags = questions_tags;
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
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
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
	@Override
	public String toString() {
		return "Questions_comment [id=" + id + ", edu_user=" + edu_user + ", questions=" + questions + ", content="
				+ content + ", is_best=" + is_best + ", reply_count=" + reply_count + ", praise_count=" + praise_count
				+ ", add_time=" + add_time + ", comment_id=" + comment_id + ", start=" + start + ", end=" + end
				+ ", questions_tags=" + questions_tags + "]";
	}
	
}
