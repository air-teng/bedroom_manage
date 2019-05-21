package com.bedroom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bedroom.common.AjaxResult;
import com.bedroom.service.BedroomService;

/**
 * 寝室Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/bedroom/")
public class BedroomController {
	@Autowired
	private BedroomService bedroomService;
	
	@RequestMapping("getBedroomId")
	public AjaxResult getBedroomId(String buildingCodeTarget,String unitTarget,String bedroomCodeTarget) {
		Integer bedroomId = bedroomService.getBedroomId(buildingCodeTarget,unitTarget,bedroomCodeTarget);
		return AjaxResult.oK(bedroomId);
	}
	
	@RequestMapping("getCurBedroom")
	public AjaxResult getCurBedroom(String stuAccount) {
		Map<String,String>  bedroomMap = bedroomService.getCurBedroom(stuAccount);
		return AjaxResult.oK(bedroomMap);
	}
	
	@RequestMapping("getAllBedroom")
	public AjaxResult getAllBedroom(String buildingCode,String unit,Integer type) {
		if(type == 0) {
			List<String>  buildingCodeList = bedroomService.getBuildingCodeList();
			return AjaxResult.oK(buildingCodeList);
		}else if(type == 1) {
			List<String>  unitMap = bedroomService.getUnitList(buildingCode);
			return AjaxResult.oK(unitMap);
		}else if(type == 2) {
			List<String>  bedroomCodeMap = bedroomService.getBedroomCodeList(buildingCode,unit);
			return AjaxResult.oK(bedroomCodeMap);
		}else {
			return AjaxResult.error();
		}
	}
}
