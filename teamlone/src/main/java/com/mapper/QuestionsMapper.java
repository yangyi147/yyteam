package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Questions;

public interface QuestionsMapper {
	public void insert(Questions questions);
	public void update(Questions questions);
	public List<Questions> getlistAll(Map map);
	public void delete(int id);
	public Questions getById(int id);
}
