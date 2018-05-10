package com.bean;

import java.util.Date;

public class Edu_article {
	//文章ID
	private int article_id;
	//文章标题
	private String title;
	//文章摘要
	private String summary;
	//文章关键字
	private String key_word;
	//文章图片URL
	private String image_url;
	//文章来源
	private String source;
	//文章作者
	private String author;
	//文章创建时间
	private Date create_time;
	//文章发布时间
	private Date publish_time;
	//文章访问链接
	private String link;
	//文章类型 2文章
	private int article_type;
	//文章点击量
	private int click_num;
	//点赞数量
	private int praise_count;
	//评论数
	private int comment_num;
	//排序值
	private int sort;
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getArticle_type() {
		return article_type;
	}
	public void setArticle_type(int article_type) {
		this.article_type = article_type;
	}
	public int getClick_num() {
		return click_num;
	}
	public void setClick_num(int click_num) {
		this.click_num = click_num;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "Edu_article [article_id=" + article_id + ", title=" + title + ", summary=" + summary + ", key_word="
				+ key_word + ", image_url=" + image_url + ", source=" + source + ", author=" + author + ", create_time="
				+ create_time + ", publish_time=" + publish_time + ", link=" + link + ", article_type=" + article_type
				+ ", click_num=" + click_num + ", praise_count=" + praise_count + ", comment_num=" + comment_num
				+ ", sort=" + sort + "]";
	}
	
	
}
