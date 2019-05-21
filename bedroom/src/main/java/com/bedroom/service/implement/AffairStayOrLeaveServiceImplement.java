package com.bedroom.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairStayOrLeave;
import com.bedroom.dao.AffairStayOrLeaveDao;
import com.bedroom.service.AffairStayOrLeaveService;

@Service
public class AffairStayOrLeaveServiceImplement implements AffairStayOrLeaveService {
	@Autowired
	private AffairStayOrLeaveDao dao;
	
	@Override
	public void stuApplyLeaveSchool(AffairStayOrLeave affairSL) {
		dao.stuApplyLeaveSchool(affairSL);
	}

	@Override
	public void stuApplyStaySchool(AffairStayOrLeave affairSL) {
		dao.stuApplyStaySchool(affairSL);
		
	}
	
}
