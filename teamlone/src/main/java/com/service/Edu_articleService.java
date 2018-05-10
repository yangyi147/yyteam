package com.service;

import java.util.List;

import com.bean.Edu_article;

public interface Edu_articleService {
	public List<Edu_article> getlistAll();
	public List<Edu_article> getById(int id);
	
	
	public void deleteArtcle(int artcleId);
}
