package com.bedroom.common.pojo;

import java.util.Date;

public class AffairLateBack {
	private Integer affairId;//晚归ID 
	private String stuAccount;//学生账号 
	private String stuName;//学生姓名
	private Date backTime;//晚归时间 
	private String applyReason;//申请原因 
	private String replyReason;//回复意见 
	private String affairStatus;//事务状态 
	private Date applyTime;//申请时间 
	private Date replyTime;//回复时间 
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public String getStuAccount() {
		return stuAccount;
	}
	public void setStuAccount(String stuAccount) {
		this.stuAccount = stuAccount;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getReplyReason() {
		return replyReason;
	}
	public void setReplyReason(String replyReason) {
		this.replyReason = replyReason;
	}
	public String getAffairStatus() {
		return affairStatus;
	}
	public void setAffairStatus(String affairStatus) {
		this.affairStatus = affairStatus;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Override
	public String toString() {
		return "AffairLateBack [affairId=" + affairId + ", stuAccount=" + stuAccount + ", backTime=" + backTime
				+ ", applyReason=" + applyReason + ", replyReason=" + replyReason + ", affairStatus=" + affairStatus
				+ ", applyTime=" + applyTime + ", replyTime=" + replyTime + "]";
	}
}
