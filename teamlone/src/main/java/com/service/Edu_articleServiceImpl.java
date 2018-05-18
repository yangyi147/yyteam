package com.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<Edu_article> getlistAlls() {
		return edu_articleDao.getlistAlls();
	}

	@Override
	public void updatepubl(Map map) {
		edu_articleDao.updatepubl(map);
	}

	@Override
	public void updatenopubl(Map map) {
		edu_articleDao.updatenopubl(map);
	}
	
}
