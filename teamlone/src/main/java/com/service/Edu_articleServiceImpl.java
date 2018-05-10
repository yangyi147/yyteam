package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_article;
import com.mapper.Edu_articleDao;
import com.mapper.Edu_article_contentDao;

@Service
public class Edu_articleServiceImpl implements Edu_articleService{
	
	@Autowired
	private Edu_articleDao edu_articleDao;
	@Autowired
	private Edu_article_contentDao eacdt;
	
	@Override
	public List<Edu_article> getlistAll() {
		return edu_articleDao.getlistAll();
	}

	@Override
	public List<Edu_article> getById(int id) {
		return edu_articleDao.getById(id);
	}

	@Override
	public void deleteArtcle(int artcleId) {
		eacdt.deleteArticleContent(artcleId);
		edu_articleDao.deleteArtcle(artcleId);
	}
	
}
