package com.mapper;

import java.util.List;

import com.bean.EClass;


public interface Edu_ClassDao {
      List<EClass> getlistAll();
      EClass getById(int id);
      
}
