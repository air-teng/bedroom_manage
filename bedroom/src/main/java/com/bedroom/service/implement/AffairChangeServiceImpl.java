package com.bedroom.service.implement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.AffairChange;
import com.bedroom.dao.AffairChangeDao;
import com.bedroom.service.AffairChangeService;
import com.bedroom.utils.BedroomUtils;

@Service
public class AffairChangeServiceImpl implements AffairChangeService{
	
	@Autowired
	private AffairChangeDao affairChangeDao;
	@Autowired
	private BedroomUtils bedroomUtils;
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
	public List<Map<String,String>> getHistoryList(String stuAccount) {
		List<AffairChange> historyList = affairChangeDao.getHistoryList(stuAccount);
		
		Map<String,String> nameMap = bedroomUtils.mapBedroomIdToBedroomName();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map<String,String>> resList = new ArrayList<>();
		for (AffairChange affairChange : historyList) {
			Map<String, String> mapOne = new HashMap<String,String>();
			mapOne.put("affairId", affairChange.getAffairId().toString());
			mapOne.put("stuAccount", affairChange.getStuAccount().toString());
			mapOne.put("curBedroomId", affairChange.getCurBedroomId().toString());
			mapOne.put("targetBedroomId", affairChange.getTargetBedroomId().toString());
			mapOne.put("curBedroomName", nameMap.get(affairChange.getCurBedroomId().toString()));
			
			mapOne.put("targetBedroomName", nameMap.get(affairChange.getTargetBedroomId().toString()));
			
			Calendar calendar = Calendar.getInstance();
			//l
			calendar.setTime(affairChange.getApplyTime());
			calendar.add(Calendar.HOUR,0-8);
			affairChange.setApplyTime(calendar.getTime());
			//2
			if(affairChange.getReplyTime()!=null) {
				calendar.setTime(affairChange.getReplyTime());
				calendar.add(Calendar.HOUR,0-8);
				affairChange.setReplyTime(calendar.getTime());
			}
			mapOne.put("applyTime", String.valueOf(simpleDateFormat.format(affairChange.getApplyTime())));
			mapOne.put("replyTime", affairChange.getReplyTime()==null?"":String.valueOf(simpleDateFormat.format(affairChange.getReplyTime())));
			mapOne.put("replyReason", affairChange.getReplyReason()==null?"":affairChange.getReplyReason());
			mapOne.put("affairStatus", affairChange.getAffairStatus().toString());
			resList.add(mapOne);
		}
		return resList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(String affairId) {
		affairChangeDao.delete(affairId);
	}

	@Override
	public List<Map<String, String>> getAllChangeToReply(String userAccount) {
		List<AffairChange> allChangeToReply = affairChangeDao.getAllChangeToReply(userAccount);
		
		Map<String,String> nameMap = bedroomUtils.mapBedroomIdToBedroomName();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map<String,String>> resList = new ArrayList<>();
		for (AffairChange affairChange : allChangeToReply) {
			Map<String, String> mapOne = new HashMap<String,String>();
			mapOne.put("affairId", affairChange.getAffairId().toString());
			mapOne.put("stuName", affairChange.getStuName());
			mapOne.put("stuAccount", affairChange.getStuAccount().toString());
			mapOne.put("curBedroomId", affairChange.getCurBedroomId().toString());
			mapOne.put("targetBedroomId", affairChange.getTargetBedroomId().toString());
			mapOne.put("curBedroomName", nameMap.get(affairChange.getCurBedroomId().toString()));
			mapOne.put("targetBedroomName", nameMap.get(affairChange.getTargetBedroomId().toString()));
			Calendar calendar = Calendar.getInstance();
			//l
			calendar.setTime(affairChange.getApplyTime());
			calendar.add(Calendar.HOUR,0-8);
			affairChange.setApplyTime(calendar.getTime());
			//2
			if(affairChange.getReplyTime()!=null) {
				calendar.setTime(affairChange.getReplyTime());
				calendar.add(Calendar.HOUR,0-8);
				affairChange.setReplyTime(calendar.getTime());
			}
			mapOne.put("applyTime", String.valueOf(simpleDateFormat.format(affairChange.getApplyTime())));
			mapOne.put("replyTime", affairChange.getReplyTime()==null?"":String.valueOf(simpleDateFormat.format(affairChange.getReplyTime())));
			mapOne.put("affairStatus", affairChange.getAffairStatus().toString());
			mapOne.put("applyReason", affairChange.getApplyReason());
			mapOne.put("replyReason", affairChange.getReplyReason());
			resList.add(mapOne);
		}
		return resList;
	}

	@Override
	public void replyChange(Integer affairId, String replyReason, String affairStatus) {
		affairChangeDao.replyChange(affairId,replyReason,affairStatus);
	}

}
