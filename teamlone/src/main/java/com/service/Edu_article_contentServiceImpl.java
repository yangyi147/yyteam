package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_article;
import com.bean.Edu_article_content;
import com.mapper.Edu_article_contentDao;
@Service
public class Edu_article_contentServiceImpl implements Edu_article_contentService{

	@Autowired
	private Edu_article_contentDao eac;
	
	@Override
	public Edu_article_content getByid(int id) {
		return eac.getByid(id);
		
		
	}

	@Override
	public List<Edu_article_content> getlisted(Map map) {
		return eac.getlisted(map);
	}

	@Override
	public void addarticle(Edu_article_content edu_article_content) {
		eac.addarticle(edu_article_content);
	}

	@Override
	public void artcleAdd(Edu_article edu_article) {
		eac.artcleAdd(edu_article);
	}

	@Override
	public void deleteArticleContent(int artcleId) {
		eac.deleteArticleContent(artcleId);
	}
}
