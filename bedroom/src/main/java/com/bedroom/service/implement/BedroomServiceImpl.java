package com.bedroom.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.dao.BedroomDao;
import com.bedroom.service.BedroomService;

@Service
public class BedroomServiceImpl implements BedroomService{
	
	@Autowired
	private BedroomDao bedroomDao;
	@Override
	public Integer getBedroomId(String buildingCodeTarget, String unitTarget, String bedroomCodeTarget) {
		return bedroomDao.getBedroomId(buildingCodeTarget,unitTarget,bedroomCodeTarget);
	}
	@Override
	public Map<String, String> getCurBedroom(String stuAccount) {
		return bedroomDao.getCurBedroom(stuAccount);
	}
	@Override
	public List<String> getUnitList(String buildingCode) {
		String[] splitRes = bedroomDao.getUnitList(buildingCode).split(",");
		List<String> res =  new ArrayList<String>();
		for (String unit : splitRes) {
			res.add(unit);
		}
		return res;
	}
	@Override
	public List<String> getBedroomCodeList(String buildingCode, String unit) {
		return bedroomDao.getBedroomCodeList(buildingCode, unit);
	}
	@Override
	public List<String> getBuildingCodeList() {
		return bedroomDao.getBuildingCodeList();
	}
	@Override
	public List<Map<String,Object>> getBedroomName() {
		return bedroomDao.getBedroomName();
	}

}
