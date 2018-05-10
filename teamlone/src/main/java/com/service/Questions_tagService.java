package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Questions_tag;

public interface Questions_tagService {

	public List<Questions_tag> getlistAll();
	public void save(Questions_tag tag);
	public void update(Questions_tag tag);
	public Questions_tag getById(int id);
	public void updateStatus(int id);
}
