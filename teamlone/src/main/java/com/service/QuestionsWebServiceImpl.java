package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.QuestionsWeb;
import com.mapper.QuestionsWebMapper;

@Service
public class QuestionsWebServiceImpl implements QuestionsWebService{

	@Autowired
	private QuestionsWebMapper QuestionsMapper;

	@Override
	public List<QuestionsWeb> getlistAll(Map map) {
		return QuestionsMapper.getlistAll(map);
	}
	@Override
	public QuestionsWeb getById(int id) {
		return QuestionsMapper.getById(id);
	}
	@Override
	public void addCount(int id) {
		QuestionsMapper.addCount(id);
	}
	@Override
	public void upRcount(int id) {
		QuestionsMapper.upRcount(id);
	}
	@Override
	public int inQuestion(QuestionsWeb questionsWeb) {
		int a=QuestionsMapper.inQuestion(questionsWeb);
		return a;
	}
	@Override
	public int getselID() {
		
		return QuestionsMapper.getselID();
	}
	@Override
	public void upBrowse(int id) {
		QuestionsMapper.upBrowse(id);
	}

}
