package com.bean;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Edu_Teacher {
	
	private int id; //��ʦid
	
	private String name;//��ʦ����
	
	private String th_name;// ��ʦ�˺�
	
	private String th_pw;//��ʦ����
	
	private String education;// ��ʦ����
	
	private String career;//��ʦ����
	
	private int is_star;//ͷ�� 1�߼���ʦ 2��ϯ��ʦ
	
	private String pic_path;//ͼƬ·��
	
	private int  status;//״̬ 0���� 1ɾ��
	
	private Date create_time;//����ʱ��
	
	private Date update_time;//����ʱ��
	
	private Sys_Subject subject;//רҵid
	
	private int sort;//����

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

	public Sys_Subject getSubject() {
		return subject;
	}

	public void setSubject(Sys_Subject subject) {
		this.subject = subject;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Edu_Teacher [id=" + id + ", name=" + name + ", th_name=" + th_name + ", th_pw=" + th_pw + ", education="
				+ education + ", career=" + career + ", is_star=" + is_star + ", pic_path=" + pic_path + ", status="
				+ status + ", create_time=" + create_time + ", update_time=" + update_time + ", subject=" + subject
				+ ", sort=" + sort + "]";
	}
	
	

}
