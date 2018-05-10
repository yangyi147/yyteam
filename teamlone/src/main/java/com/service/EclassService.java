package com.service;

import java.util.List;

import com.bean.EClass;
import com.bean.Users;

public interface EclassService {
	 List<EClass> getlistAll();
     EClass getById(int id);
}
