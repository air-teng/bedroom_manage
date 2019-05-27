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
import com.bedroom.service.BedroomService;

@Service
public class AffairChangeServiceImpl implements AffairChangeService{
	
	@Autowired
	private AffairChangeDao affairChangeDao;
	@Autowired
	private BedroomService bedroomService;
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
		List<Map<String,Object>> bedroomNameMap = bedroomService.getBedroomName();
		Map<String,String> nameMap = new HashMap<>();
		for(int i=0;i<bedroomNameMap.size();i++) {
			if(bedroomNameMap.get(i) == null) {
				continue;
			}
			Map<String,Object> tempMap = bedroomNameMap.get(i);
			String newKey="",newValue="";
			for(Map.Entry<String,Object> entry : tempMap.entrySet()) {
				if("bedroom_id".equals(entry.getKey())) {
					newKey = String.valueOf(entry.getValue());
				}else if("bedroom_name".equals(entry.getKey())) {
					newValue= String.valueOf(entry.getValue());
				}
			}	
			nameMap.put(newKey, newValue);
		}
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

}
