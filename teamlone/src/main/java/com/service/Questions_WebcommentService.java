package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Questions_Webcomment;

public interface Questions_WebcommentService {
	public List<Questions_Webcomment> getlistAll(Map map);
	public Questions_Webcomment getById(int id);
	public List<Questions_Webcomment> getById1(int id);
	public Questions_Webcomment getById2(int id);
	public List<Questions_Webcomment> getCommentId(int id);
	public void insQc(Questions_Webcomment qc);
	public int  selQid(int id);
	public void addCount(int id);
	public void upRcount(int id);
}
