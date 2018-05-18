package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Edu_article;

public interface Edu_articleService {
	public List<Edu_article> getlistAll();
	public List<Edu_article> getlistAlls();
	public List<Edu_article> getById(int id);
	public void updatepubl(Map map);
	public void updatenopubl(Map map);
	
	public void deleteArtcle(int artcleId);
}
