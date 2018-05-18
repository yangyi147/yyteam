package com.mapper;

import java.util.Map;

import com.bean.Edu_likes;

public interface Edu_likesDao {
	public Edu_likes getLikes(Map map);
	public void saveLikes(Map map);
}
