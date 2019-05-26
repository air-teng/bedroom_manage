package com.bedroom.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairChange;
import com.bedroom.dao.AffairChangeDao;
import com.bedroom.service.AffairChangeService;

@Service
public class AffairChangeServiceImpl implements AffairChangeService{
	
	@Autowired
	private AffairChangeDao affairChangeDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void apply(AffairChange affairChange) {
		affairChangeDao.apply(affairChange);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AffairChange> getHistoryList(String stuAccount) {
		return affairChangeDao.getHistoryList(stuAccount);
	}

}
