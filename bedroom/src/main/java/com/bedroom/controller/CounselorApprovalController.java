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
import com.bedroom.service.CounselorApprovalService;

/**
 * 辅导员审批自己带的这一届学院学生申请的申请
 * @author Administrator
 */
@Controller
@RequestMapping("/counselor/")
public class CounselorApprovalController {
	@Autowired
	private CounselorApprovalService counselorService;
	
	//=========================离校===========================
	/**
	 * 展示所有辅导员可以审批的学生离校申请;    /counselor/showApprovalLeaveInfo
	 * @param session
	 * @return
	 */
	@RequestMapping("showApprovalLeaveInfo")
	@ResponseBody
	public List<AffairStayOrLeave> showApprovalLeaveInfo(HttpSession session){
		//获取登录用户的学院信息
		User user = (User) session.getAttribute("user");
		String userCollegeName=user.getUserCollegeName();
		List<AffairStayOrLeave> list= counselorService.showALlSelfCollegeStudentApplyLeaveSchoolInfo(userCollegeName);
		return list;
	}
	
	/**
	 * 辅导员审批学生离校申请,操作为同意;     /counselor/counselorAgreeLeaveSchool
	 * @param affairId
	 * @return
	 */
	@RequestMapping("counselorAgreeLeaveSchool")
	@ResponseBody
	public  AjaxResult counselorAgreeLeaveSchool(Integer affairId) {
		try {
			counselorService.counselorAgreeLeaveSchool(affairId);
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
		return  AjaxResult.oK();
	}
	
	/**
	 * 辅导员审批学生离校申请,操作为拒绝;     /counselor/counselorRefuseLeaveSchool
	 * @param affairId
	 * @return
	 */
	@RequestMapping("counselorRefuseLeaveSchool")
	@ResponseBody
	public  AjaxResult counselorRefuseLeaveSchool(Integer affairId) {
		try {
			counselorService.counselorRefuseLeaveSchool(affairId);
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
		return  AjaxResult.oK();
	}
	
	/**
	 * 展示所有辅导员进行过的审批结果;所有离校审批结果     /counselor/showApprovalResultLeaveSchool
	 * @param session
	 * @return
	 */
	@RequestMapping("showApprovalResultLeaveSchool")
	@ResponseBody
	public List<AffairStayOrLeave> showApprovalResultLeaveSchool(HttpSession session){
		//获取登录教师所属学院
		User user = (User) session.getAttribute("user");
		String userCollegeName=user.getUserCollegeName();
		//查询结果
		List<AffairStayOrLeave>  list=counselorService.showApprovalResultLeaveSchool(userCollegeName);
		return list;
	}
	
	/*
	public  AjaxResult counselorAgreeLeaveSchool(Integer affairId) {
		try {
			
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
		return  AjaxResult.oK();
	}
	*/
	
	
	//=========================留校===========================
	/**
	 * 展示所有辅导员可以审批的学生留校申请;    /counselor/showApprovalStayInfo
	 * @param session
	 * @return
	 */
	@RequestMapping("showApprovalStayInfo")
	@ResponseBody
	public List<AffairStayOrLeave> showApprovalApplyStayInfo(HttpSession session){
		//获取登录用户的学院信息
		User user = (User) session.getAttribute("user");
		String userCollegeName=user.getUserCollegeName();
		List<AffairStayOrLeave> list= counselorService.showALlSelfCollegeStudentApplyStaySchoolInfo(userCollegeName);
		return list;
	}
	
	/**
	 * 辅导员审批学生留校申请,操作为同意;     /counselor/counselorAgreeStaySchool
	 * @param affairId
	 * @return
	 */
	@RequestMapping("counselorAgreeStaySchool")
	@ResponseBody
	public  AjaxResult agreeStaySchool(Integer affairId) {
		try {
			counselorService.counselorAgreeStaySchool(affairId);
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
		return  AjaxResult.oK();
	}
	
	/**
	 * 辅导员审批学生留校申请,操作为拒绝;     /counselor/counselorRefuseStaySchool
	 * @param affairId
	 * @return
	 */
	@RequestMapping("counselorRefuseStaySchool")
	@ResponseBody
	public  AjaxResult refuseStaySchool(Integer affairId) {
		try {
			counselorService.counselorRefuseStaySchool(affairId);
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
		return  AjaxResult.oK();
	}
	
	/**
	 * 展示所有辅导员进行过的审批结果;所有留校审批结果     /counselor/showApprovalResultStaySchool
	 * @param session
	 * @return
	 */
	@RequestMapping("showApprovalResultStaySchool")
	@ResponseBody
	public List<AffairStayOrLeave> showApprovalResultStaySchool(HttpSession session){
		//获取登录教师所属学院
		User user = (User) session.getAttribute("user");
		String userCollegeName=user.getUserCollegeName();
		//查询结果
		List<AffairStayOrLeave>  list=counselorService.showApprovalResultStaySchool(userCollegeName);
		return list;
	}
	
	
	
}
