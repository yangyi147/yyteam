package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_article;
import com.bean.Edu_article_content;

public interface Edu_article_contentService {
	public Edu_article_content getByid(int id);
	public List<Edu_article_content> getlisted(Map map);
	
	public void addarticle(Edu_article_content edu_article_content);
	public void artcleAdd(Edu_article edu_article);
	
	public void deleteArticleContent(int artcleId);
	
	public void updateArticleContent(Edu_article_content edu_article_content);
	public void updateArticle(Edu_article edu_article);
	
	public void savelikes(int targetId);
	public void savenum(int targetId);
}
