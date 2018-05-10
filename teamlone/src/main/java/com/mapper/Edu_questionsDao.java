package com.mapper;

import java.util.List;

import com.bean.Edu_questions;
public interface Edu_questionsDao {
public List<Edu_questions>  getListAll(Math map);
public Edu_questions getById(int id);
public void  delQues(int id);
public void inQues(Edu_questions edu_questions);
public void upQues(Edu_questions edu_questions);	

}
