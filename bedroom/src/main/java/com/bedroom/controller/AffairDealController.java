package com.bedroom.controller;

import java.util.List;

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
		affairLateBackService.apply(affairLateBack);
		return AjaxResult.oK();
	}
	
	@RequestMapping(value="getHistoryList",method=RequestMethod.GET)
	@ResponseBody
	public List<AffairChange> getHistoryList(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<AffairChange> affairs = affairService.getHistoryList(user.getUserAccount());
		return affairs;
	}
}
