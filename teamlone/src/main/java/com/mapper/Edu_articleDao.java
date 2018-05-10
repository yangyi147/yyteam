package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_article;
import com.bean.Edu_article_content;

public interface Edu_articleDao {
		public List<Edu_article> getlistAll();
		public List<Edu_article> getById(int id);
		
		public void deleteArtcle(int artcleId);
		
}
