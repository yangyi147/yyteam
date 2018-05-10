package com.mapper;

import java.util.List;

import com.bean.Subjects;
public interface SubjectsDao {
  public Subjects getById(int id);
  public  List<Subjects> getListAll();
}
