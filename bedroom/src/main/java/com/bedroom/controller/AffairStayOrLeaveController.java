package com.bedroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedroom.common.AjaxResult;
import com.bedroom.common.pojo.AffairStayOrLeave;
import com.bedroom.service.AffairStayOrLeaveService;
/**
 * 学生离校或留校申请的数据接口层
 * @author Administrator
 */
@Controller
@RequestMapping("/affairStayOrLeave/")
public class AffairStayOrLeaveController {
	@Autowired
	private AffairStayOrLeaveService affairSLService;
	/**
	 * 学生申请离校;  /affairStayOrLeave/stuApplyLeaveSchool
	 */
	@RequestMapping("stuApplyLeaveSchool")
	@ResponseBody
	public AjaxResult stuApplyLeaveSchool(AffairStayOrLeave affairSL) {
		try {
			affairSLService.stuApplyLeaveSchool(affairSL);
		} catch (Exception e) {
			return AjaxResult.error("申请失败!!!");
		}
		return AjaxResult.oK();
	}
	/**
	 * 学生申请留校;  /affairStayOrLeave/stuApplystaySchool
	 */
	@RequestMapping("stuApplystaySchool")
	@ResponseBody
	public AjaxResult stuApplystaySchool(AffairStayOrLeave affairSL) {
		try {
			affairSLService.stuApplyStaySchool(affairSL);
		} catch (Exception e) {
			return AjaxResult.error("申请失败!!!");
		}
		return AjaxResult.oK();
	}
	
	
	
	
}
