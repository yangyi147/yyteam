package com.mapper;

import java.util.List;

import com.bean.Questions_tag;

public interface Questions_tagMapper {
    public List<Questions_tag> getBylistId(int id);
	public List<Questions_tag> getlistAll();
	public void insert(Questions_tag tag);
	public void update(Questions_tag tag);
	public Questions_tag getById(int id);
	public void updateStatus(int id);
}
