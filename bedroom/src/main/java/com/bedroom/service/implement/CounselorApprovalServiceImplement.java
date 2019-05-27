package com.bedroom.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairStayOrLeave;
import com.bedroom.dao.CounselorApprovalDao;
import com.bedroom.service.CounselorApprovalService;
@Service
public class CounselorApprovalServiceImplement implements CounselorApprovalService {
	@Autowired
	private CounselorApprovalDao  counselorDao;

	@Override
	public List<AffairStayOrLeave> showALlSelfCollegeStudentApplyLeaveSchoolInfo(String userCollegeName) {
		List<AffairStayOrLeave> list = counselorDao.showALlSelfCollegeStudentApplyLeaveSchoolInfo(userCollegeName);
		return  list;
	}

	@Override
	public void counselorAgreeLeaveSchool(Integer affairId) {
		counselorDao.counselorAgreeLeaveSchool(affairId);
		
	}

	@Override
	public void counselorRefuseLeaveSchool(Integer affairId) {
		counselorDao.counselorRefuseLeaveSchool(affairId);
		
	}

	@Override
	public List<AffairStayOrLeave> showApprovalResultLeaveSchool(String userCollegeName) {
		List<AffairStayOrLeave> list=counselorDao.showApprovalResultLeaveSchool(userCollegeName);
		return list;
	}

	@Override
	public List<AffairStayOrLeave> showALlSelfCollegeStudentApplyStaySchoolInfo(String userCollegeName) {
		return counselorDao.showALlSelfCollegeStudentApplyStaySchoolInfo(userCollegeName);
		
	}

	@Override
	public void counselorAgreeStaySchool(Integer affairId) {
		counselorDao.counselorAgreeStaySchool(affairId);
		
	}

	@Override
	public void counselorRefuseStaySchool(Integer affairId) {
		counselorDao.counselorRefuseStaySchool(affairId);
		
	}

	@Override
	public List<AffairStayOrLeave> showApprovalResultStaySchool(String userCollegeName) {
		return  counselorDao.showApprovalResultStaySchool(userCollegeName);
	}
	
	
}
