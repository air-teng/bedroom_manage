package com.bedroom.common.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 	user_id	int(11)
	user_name	varchar(255)
	user_password	varchar(255)
	user_nickname	varchar(255)
	user_sex	varchar(255)
	user_age	int(11)
	user_phone	varchar(255)
	user_college	varchar(255)
	user_foundtime	datetime 
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	//
	private Integer  userId;//主键,自增长
	private String  userName;//用户账号
	private String  userPassword;//用户t密码
	private String  userNickname;//用户昵称
	private String  userSex;//用户性别
	private Integer  userAge;//用户年龄
	private String  userPhone;//电话
	private String  userCollege;//学院
	private Date  userFoundtime;//创建时间
	//set and get
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getUserCollege() {
		return userCollege;
	}
	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}
	public Date getUserFoundtime() {
		return userFoundtime;
	}
	public void setUserFoundtime(Date userFoundtime) {
		this.userFoundtime = userFoundtime;
	}
	//
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userNickname=" + userNickname + ", userSex=" + userSex + ", userAge=" + userAge + ", userPhone="
				+ userPhone + ", userCollege=" + userCollege + ", userFoundtime=" + userFoundtime + "]";
	}
	
	
	
	
}
