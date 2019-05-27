package com.bedroom.service.implement;

import java.util.List;

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
	@Override
	public List<AffairLateBack> getHistoryList(String userAccount) {
		return affairLateBackDao.getHistoryList(userAccount);
	}
	@Override
	public void delete(String affairId) {
		affairLateBackDao.delete(affairId);
	}
	@Override
	public List<AffairLateBack> getAllBackLateToReply(String userAccount) {
		return affairLateBackDao.getAllBackLateToReply(userAccount);
	}
	@Override
	public void replyBackLate(Integer affairId, String replyReason, String affairStatus) {
		affairLateBackDao.replyBackLate(affairId,replyReason,affairStatus);
	}
}
