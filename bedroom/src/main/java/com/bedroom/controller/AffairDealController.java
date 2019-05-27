package com.bedroom.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bedroom.common.AjaxResult;
import com.bedroom.common.pojo.AffairChange;
import com.bedroom.common.pojo.AffairLateBack;
import com.bedroom.common.pojo.User;
import com.bedroom.service.AffairChangeService;
import com.bedroom.service.AffairLateBackService;

/**
 * 事务处理Controller
 * @author Administrator
 */
@RestController
@RequestMapping("/affair/")
public class AffairDealController {
	@Autowired
	private AffairChangeService affairService;
	@Autowired
	private AffairLateBackService affairLateBackService;
	
	@RequestMapping(value="changeApply",method=RequestMethod.POST)
	public AjaxResult applyChangeBedroom(AffairChange affairChange) {
		affairService.apply(affairChange);
		return AjaxResult.oK();
	}
	@RequestMapping(value="lateBackApply",method=RequestMethod.POST)
	public AjaxResult applyLageBack(AffairLateBack affairLateBack) {
		Calendar calendar = Calendar.getInstance();
		//l
		calendar.setTime(affairLateBack.getBackTime());
		calendar.add(Calendar.HOUR,8);
		affairLateBack.setBackTime(calendar.getTime());
		affairLateBackService.apply(affairLateBack);
		return AjaxResult.oK();
	}
	
	@RequestMapping(value="getHistoryList",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> getHistoryList(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Map<String,String>> affairs = affairService.getHistoryList(user.getUserAccount());
		return affairs;
	}
	
	@RequestMapping(value="getLateBackHistoryApply",method=RequestMethod.GET)
	@ResponseBody
	public List<AffairLateBack> getLateBackHistoryApply(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<AffairLateBack> affairLateBacks = affairLateBackService.getHistoryList(user.getUserAccount());
		return affairLateBacks;
	}
	
	@RequestMapping(value="deleteChangeAffair",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteChangeAffair(String affairId) {
		affairService.delete(affairId);
		return AjaxResult.oK();
	}
	
	@RequestMapping(value="deleteLateBack",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteLateBack(String affairId) {
		affairLateBackService.delete(affairId);
		return AjaxResult.oK();
	}
}
