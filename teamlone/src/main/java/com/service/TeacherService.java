package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Teacher;
import com.github.pagehelper.PageInfo;

public interface TeacherService {
	  public PageInfo<Teacher> getlistAll(Map map,int page);
	  public void inTer(Teacher teacher);
	  public void delTe(int id);
	  public  Teacher getById(int id);
	  public void upTer(Teacher teacher);

}
