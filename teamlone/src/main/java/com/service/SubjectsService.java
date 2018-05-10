package com.service;

import java.util.List;

import com.bean.Subjects;
public interface SubjectsService {
	public Subjects getById(int id);
    public  List<Subjects> getListAll();
}
