package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Questions;

public interface QuestionsService {

	public void save(Questions questions);
	public void update(Questions questions);
	public List<Questions> listAll(Map map);
	public void delete(int id);
	public Questions getById(int id);
	public List<Questions> getByQaT(int id);
}
