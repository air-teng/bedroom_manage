package com.bedroom.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedroom.service.BedroomService;

@Component
public class BedroomUtils {
	@Autowired
	private BedroomService bedroomService;
	/**
	 * 得到bedroomid到bedroomName的转换
	 * @param bedroomNameMap
	 * @return
	 */
	public Map<String,String>  mapBedroomIdToBedroomName() {
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
		return nameMap;
	}
}
