package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.QuestionsWeb;

public interface QuestionsWebMapper {
	public List<QuestionsWeb> getlistAll(Map map);
	public QuestionsWeb getById(int id);
	public QuestionsWeb getByIdtwo(int id);
	public void addCount(int id);
	public void upRcount(int id);
	public int  inQuestion(QuestionsWeb questionsWeb);
	public int getselID();
}
