package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Questions_Webtag;

public interface Questions_WebtagService {
	public List<Questions_Webtag> getlistAll();
	public Questions_Webtag getById(int id);
	public void inTag(Map map);
}
