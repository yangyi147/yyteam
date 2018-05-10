package com.mapper;

import java.util.List;

import com.bean.Imges_type;

public interface Img_typeDao {
	public Imges_type getById(int id);
	public List<Imges_type>  getlistAll();
}
