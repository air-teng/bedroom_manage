package com.bedroom.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairChange;
import com.bedroom.dao.AffairChangeDao;
import com.bedroom.service.AffairChangeService;

@Service
public class AffairChangeServiceImpl implements AffairChangeService{
	
	@Autowired
	private AffairChangeDao affairChangeDao;
	@Override
	public void apply(AffairChange affairChange) {
		affairChangeDao.apply(affairChange);
	}

}
