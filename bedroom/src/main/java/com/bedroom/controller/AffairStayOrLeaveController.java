package com.bedroom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedroom.common.AjaxResult;
import com.bedroom.common.pojo.AffairStayOrLeave;
import com.bedroom.common.pojo.User;
import com.bedroom.service.AffairStayOrLeaveService;
/**
 * 学生离校或留校申请的数据接口层
 * @author Administrator
 */
@Controller
@RequestMapping("/affair/")
public class AffairStayOrLeaveController {
	@Autowired
	private AffairStayOrLeaveService affairSLService;
	/**
	 * 学生申请离校;  /affair/stuApplyLeaveSchool
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
	 * 学生申请留校;  /affair/stuApplystaySchool
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
	/**查看自己申请的离校信息;   /affair/showApplyLeaveInfo
	 * 
	 */
	@RequestMapping("showApplyLeaveInfo")
	@ResponseBody
	public List<AffairStayOrLeave>  showApplyLeaveInfo(HttpSession session){
		User user=(User) session.getAttribute("user");
		String stuAccount=user.getUserAccount();
		List<AffairStayOrLeave> list=affairSLService.showApplyLeaveInfo(stuAccount);
		return list;
	}
	
	/***
	 *	删除写的离校申请;  根据affirId删除记录	
	 *     /affair/removeApplyLeaveSchool
	 *  删除留校申请信息,同样是此方法    
	 * @param affairId
	 * @return
	 */
	@RequestMapping("removeApplyLeaveSchool")
	@ResponseBody
	public AjaxResult removeApplyLeaveSchool(Integer affairId) {
		try {
			affairSLService.removeApplyLeaveSchool(affairId);
		} catch (Exception e) {
			return AjaxResult.error("删除失败!!1");
		}
		return AjaxResult.oK();
	}
	
	
	/**查看自己申请的留校信息;   /affair/showApplyStayInfo
	 * 
	 */
	@RequestMapping("showApplyStayInfo")
	@ResponseBody
	public List<AffairStayOrLeave>  showApplyStayInfo(HttpSession session){
		User user=(User) session.getAttribute("user");
		String stuAccount=user.getUserAccount();
		List<AffairStayOrLeave> list=affairSLService.showApplyStayInfo(stuAccount);
		return list;
	}
	
	
	
}
