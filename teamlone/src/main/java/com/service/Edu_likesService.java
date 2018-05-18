package com.service;

import java.util.Map;

import com.bean.Edu_likes;

public interface Edu_likesService {
	public Edu_likes getLikes(Map map);
	public void saveLikes(Map map);
}
