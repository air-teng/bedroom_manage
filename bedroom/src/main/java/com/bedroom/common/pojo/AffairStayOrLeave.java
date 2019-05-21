package com.bedroom.common.pojo;
/**
 * 留校或离校的实体类
	affair_id	int(11)
	stu_account	varchar(11)
	start_time	datetime
	end_time	datetime
	apply_reason	varchar(255)
	reply_reason	varchar(255)
	affair_status	char(4)
	apply_time	datetime
	reply_time	datetime
 *
 */

import java.io.Serializable;
import java.util.Date;

public class AffairStayOrLeave implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer affairId;//事务主键
	private String  stuAccount;//学生id
	private Date  startTime;//起止时间
	private Date  endTime;//终止时间
	private String  applyReason;//申请原因
	private String  replyReason;//审核意见
	private String  affairStatus;//('0'-待审核,'1'-审核通过,'2'-审核拒绝)
	private Date  applyTime;//申请时间
	private Date  replyTime;//回复时间
	//set  and  get 
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//
	@Override
	public String toString() {
		return "AffairStayOrLeave [affairId=" + affairId + ", stuAccount=" + stuAccount + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", applyReason=" + applyReason + ", replyReason=" + replyReason
				+ ", affairStatus=" + affairStatus + ", applyTime=" + applyTime + ", replyTime=" + replyTime + "]";
	}
	
	
	
}
