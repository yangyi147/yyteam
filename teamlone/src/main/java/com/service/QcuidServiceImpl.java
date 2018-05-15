package com.service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Qcuid;
import com.mapper.QcuidMapper;
@Service
public class QcuidServiceImpl  implements QcuidService{

	@Autowired
	private QcuidMapper qcuidMapper;
	
	@Override
	public void inQcuid(Qcuid qcuid) {
		qcuidMapper.inQcuid(qcuid);
		
	}

	@Override
	public Qcuid getById(Map map) {
		return qcuidMapper.getById(map);
	}
}
