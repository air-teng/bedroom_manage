package com.bedroom.common.pojo;

/**
 * 报修实体类
 * @author Administrator
 */
public class ReportRepair {
	private String bedroomCode;// 寝室代码
	private String reportName;//  申请人姓名
	private String reportAccount;// 申请人账号
	private String reportObject;//  报修物件
	private String reportDetail;// 报修情况描述
	public String getBedroomCode() {
		return bedroomCode;
	}
	public void setBedroomCode(String bedroomCode) {
		this.bedroomCode = bedroomCode;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportAccount() {
		return reportAccount;
	}
	public void setReportAccount(String reportAccount) {
		this.reportAccount = reportAccount;
	}
	public String getReportObject() {
		return reportObject;
	}
	public void setReportObject(String reportObject) {
		this.reportObject = reportObject;
	}
	public String getReportDetail() {
		return reportDetail;
	}
	public void setReportDetail(String reportDetail) {
		this.reportDetail = reportDetail;
	}
}
