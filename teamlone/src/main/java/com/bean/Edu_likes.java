package com.bean;

public class Edu_likes {
	//����ID
	private int likes_ID;
	//��������
	private int type;
	//�����û�ID
	private Users uid;
	//��ص���
	private int targetId;
	public int getLikes_ID() {
		return likes_ID;
	}
	public void setLikes_ID(int likes_ID) {
		this.likes_ID = likes_ID;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Users getUid() {
		return uid;
	}
	public void setUid(Users uid) {
		this.uid = uid;
	}
	public int getLikes_eid() {
		return targetId;
	}
	public void setLikes_eid(int targetId) {
		this.targetId = targetId;
	}
	@Override
	public String toString() {
		return "Edu_likes [likes_ID=" + likes_ID + ", type=" + type + ", uid=" + uid + ", targetId=" + targetId + "]";
	}
	
	
}
