package com.bean;

import java.util.Date;
public class Comment {
	private int comment_id;
	private Users users_id;
	private int p_comment_id;
	private  String  content;
	private Date  addtime;
	private Edu_Course others_id;
	private int praise_count;
	private int reply_count;
	private int type;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Users getUsers_id() {
		return users_id;
	}
	public void setUsers_id(Users users_id) {
		this.users_id = users_id;
	}
	public int getP_comment_id() {
		return p_comment_id;
	}
	public void setP_comment_id(int p_comment_id) {
		this.p_comment_id = p_comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Edu_Course getOthers_id() {
		return others_id;
	}
	public void setOthers_id(Edu_Course others_id) {
		this.others_id = others_id;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", users_id=" + users_id + ", p_comment_id=" + p_comment_id
				+ ", content=" + content + ", addtime=" + addtime + ", others_id=" + others_id + ", praise_count="
				+ praise_count + ", reply_count=" + reply_count + ", type=" + type + "]";
	}
}
