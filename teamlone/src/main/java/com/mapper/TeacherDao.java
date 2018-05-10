package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Teacher;

public interface TeacherDao {
  public List<Teacher> getListAll(Map map);
  public  Teacher getById(int id);
  public void delTe(int id);
  public void inTer(Teacher teacher);
  public void upTer(Teacher teacher);
  
}
