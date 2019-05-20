package com.bedroom.service;


import com.bedroom.common.pojo.User;

public interface UserService {
	/**根据输入的账户和密码判断用户是否存在*/
	User userLoginShowUserInfo(String  userName, String user_password);
	
	
}
