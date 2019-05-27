package com.bedroom.common.pojo;

import java.util.Date;

public class AffairChange {
	private Integer affairId;// 事务Id
	private String stuAccount;// 学生账号 
	private String stuName;//学生姓名
	private Integer curBedroomId;// 当前寝室号 
	private Integer targetBedroomId;// 目标寝室号 
	private String applyReason;// 申请原因 
	private String replyReason;// 回复意见 
	private String affairStatus;// 事务状态 
	private Date applyTime;// 申请时间 
	private Date replyTime;// 回复时间
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
	public Integer getCurBedroomId() {
		return curBedroomId;
	}
	public void setCurBedroomId(Integer curBedroomId) {
		this.curBedroomId = curBedroomId;
	}
	public Integer getTargetBedroomId() {
		return targetBedroomId;
	}
	public void setTargetBedroomId(Integer targetBedroomId) {
		this.targetBedroomId = targetBedroomId;
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
}
