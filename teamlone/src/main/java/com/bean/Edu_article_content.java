package com.bean;

public class Edu_article_content {
	
	//����ID
	private Edu_article edu_article;
	//��������
	private String content;
	public Edu_article getEdu_article() {
		return edu_article;
	}
	public void setEdu_article(Edu_article edu_article) {
		this.edu_article = edu_article;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Edu_article_content [edu_article=" + edu_article + ", content=" + content + "]";
	}

	
}
