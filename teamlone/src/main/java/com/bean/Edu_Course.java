package com.bean;

import java.util.Date;

public class Edu_Course {
	
	private int course_id; //课程编号
	
	private String course_name; //课程名称
	
	private int is_avaliable;//1正常2删除
	
	private Sys_Subject subject; //课程专业id
	
	private String subject_link;//课程专业链
	
	private Date add_time;//添加时间
	
	private double source_price;//课程原价（只显示）
	
	private double current_price;//课程销售价格（实际支付价格）设置为0则可以免费观看
	
	private String title;//课程简介
	
	private String context;//课程详情
	
	private int lession_num;//总课时
	
	private  String logo;//图片路径
	
	private Date update_time;//最后更新时间
	
	private int page_buycount;//销售数量
	
	private int page_vlewcount;//浏览数量
	
	private Date end_time;//有效的结束时间
	
	private String end_times;
	
	private int losetype;//有效期类型，0：到期时间，1：按天数
	        
	private String lose_time;//有效期商品订单过期时间点
	
	private int sequence;//序列
	
	private double course_gross_income;//该课程总共卖了多少钱
   
	
	public String getSubject_link() {
		return subject_link;
	}

	public void setSubject_link(String subject_link) {
		this.subject_link = subject_link;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getIs_avaliable() {
		return is_avaliable;
	}

	public void setIs_avaliable(int is_avaliable) {
		this.is_avaliable = is_avaliable;
	}


	public Sys_Subject getSubject() {
		return subject;
	}

	public void setSubject(Sys_Subject subject) {
		this.subject = subject;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}


	public double getSource_price() {
		return source_price;
	}

	public void setSource_price(double source_price) {
		this.source_price = source_price;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getLession_num() {
		return lession_num;
	}

	public void setLession_num(int lession_num) {
		this.lession_num = lession_num;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getPage_buycount() {
		return page_buycount;
	}

	public void setPage_buycount(int page_buycount) {
		this.page_buycount = page_buycount;
	}

	public int getPage_vlewcount() {
		return page_vlewcount;
	}

	public void setPage_vlewcount(int page_vlewcount) {
		this.page_vlewcount = page_vlewcount;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getLosetype() {
		return losetype;
	}

	public void setLosetype(int losetype) {
		this.losetype = losetype;
	}

	public String getLose_time() {
		return lose_time;
	}

	public void setLose_time(String lose_time) {
		this.lose_time = lose_time;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public double getCourse_gross_income() {
		return course_gross_income;
	}

	public void setCourse_gross_income(double course_gross_income) {
		this.course_gross_income = course_gross_income;
	}

	public String getEnd_times() {
		return end_times;
	}

	public void setEnd_times(String end_times) {
		this.end_times = end_times;
	}

	@Override
	public String toString() {
		return "Edu_Course [course_id=" + course_id + ", course_name=" + course_name + ", is_avaliable=" + is_avaliable
				+ ", subject=" + subject + ", subject_link=" + subject_link + ", add_time=" + add_time
				+ ", source_price=" + source_price + ", current_price=" + current_price + ", title=" + title
				+ ", context=" + context + ", lession_num=" + lession_num + ", logo=" + logo + ", update_time="
				+ update_time + ", page_buycount=" + page_buycount + ", page_vlewcount=" + page_vlewcount
				+ ", end_time=" + end_time + ", end_times=" + end_times + ", losetype=" + losetype + ", lose_time="
				+ lose_time + ", sequence=" + sequence + ", course_gross_income=" + course_gross_income + "]";
	}






	
	

}
