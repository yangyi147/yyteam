package com.bean;

import java.util.Date;

/**
 * @author lenovo
 *知识点的基本信息
 */
public class Edu_course_Kpoint {
	

	private int id; //课程id
	
	private String name;//节点名称
	
	private int pId;//父级
	
	private Date add_time;//添加时间
	
	private int sort;//排序
	
	private int play_count;//播放次数
	
	private int is_free;//是否可以试听 1免费 2 收费
	
	private String video_url;//视频地址
	
	private Edu_Teacher  teacher;//讲师id
	
	private String play_time;//播放时间
	
	private int kpoint_type;//节点类型 0是文件目录 1视频
	
	private String file_type;//video 视频 audio 音频 file文档 txt 文本  atlas图片集
	
	private String content;//文本

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

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getPlay_count() {
		return play_count;
	}

	public void setPlay_count(int play_count) {
		this.play_count = play_count;
	}

	public int getIs_free() {
		return is_free;
	}

	public void setIs_free(int is_free) {
		this.is_free = is_free;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public Edu_Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Edu_Teacher teacher) {
		this.teacher = teacher;
	}

	public String getPlay_time() {
		return play_time;
	}

	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}

	public int getKpoint_type() {
		return kpoint_type;
	}

	public void setKpoint_type(int kpoint_type) {
		this.kpoint_type = kpoint_type;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Edu_course_Kpoint [id=" + id + ", name=" + name + ", pId=" + pId + ", add_time=" + add_time + ", sort="
				+ sort + ", play_count=" + play_count + ", is_free=" + is_free + ", video_url=" + video_url
				+ ", teacher=" + teacher + ", play_time=" + play_time + ", kpoint_type=" + kpoint_type + ", file_type="
				+ file_type + ", content=" + content + "]";
	}
	
	

}
