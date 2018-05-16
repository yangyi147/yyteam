package com.service;

import java.util.List;
import java.util.Map;

import com.bean.QuestionsWeb;

public interface QuestionsWebService {
	public List<QuestionsWeb> getlistAll(Map map);
	public QuestionsWeb getById(int id);
	public void addCount(int id);
	public void upRcount(int id);
	public int  inQuestion(QuestionsWeb questionsWeb);
	public int getselID();
	public void upBrowse(int id);
}
