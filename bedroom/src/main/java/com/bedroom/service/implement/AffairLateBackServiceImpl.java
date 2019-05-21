package com.bedroom.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairLateBack;
import com.bedroom.dao.AffairLateBackDao;
import com.bedroom.service.AffairLateBackService;

@Service
public class AffairLateBackServiceImpl implements AffairLateBackService{
	
	@Autowired
	private AffairLateBackDao affairLateBackDao;
	@Override
	public void apply(AffairLateBack affairLateBack) {
		affairLateBackDao.apply(affairLateBack);
	}

}
