package com.bedroom.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 	user_account	varchar(11)
	user_name	varchar(128)
	user_password	varchar(30)
	user_nickname	varchar(128)
	user_sex	varchar(10)
	user_age	int(11)
	user_phone	varchar(15)
	user_college_name	varchar(64)
	grade_level	varchar(4)
	user_foundtime	datetime
	bedroom_id	int(11)
	user_level	char(0)
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	//
	private String  userAccount;//主键,自增长
	private String  userName;//用户账号
	private String  userPassword;//用户t密码
	private String  userNickname;//用户昵称
	private String  userSex;//用户性别
	private Integer  userAge;//用户年龄
	private String  userPhone;//电话
	private String  userCollegeName;//学院
	private String gradeLevel;//年级,哪一届
	private Date  userFoundtime;//创建时间
	private Integer bedroomId;//宿舍id
	private String userLevel;//身份('0'-学生,'1'-教师,'2'-管理员)
	//set and get
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserCollegeName() {
		return userCollegeName;
	}
	public void setUserCollegeName(String userCollegeName) {
		this.userCollegeName = userCollegeName;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public Date getUserFoundtime() {
		return userFoundtime;
	}
	public void setUserFoundtime(Date userFoundtime) {
		this.userFoundtime = userFoundtime;
	}
	public Integer getBedroomId() {
		return bedroomId;
	}
	public void setBedroomId(Integer bedroomId) {
		this.bedroomId = bedroomId;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//
	@Override
	public String toString() {
		return "User [userAccount=" + userAccount + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userNickname=" + userNickname + ", userSex=" + userSex + ", userAge=" + userAge + ", userPhone="
				+ userPhone + ", userCollegeName=" + userCollegeName + ", gradeLevel=" + gradeLevel + ", userFoundtime="
				+ userFoundtime + ", bedroomId=" + bedroomId + ", userLevel=" + userLevel + "]";
	}
	
	
	
	
}
