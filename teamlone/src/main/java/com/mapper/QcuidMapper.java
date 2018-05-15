package com.mapper;

import java.util.Map;

import com.bean.Qcuid;

public interface QcuidMapper {
	
	public void inQcuid(Qcuid qcuid);
     public  Qcuid getById(Map map);
}
