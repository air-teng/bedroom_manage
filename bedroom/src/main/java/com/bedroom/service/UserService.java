package com.bedroom.service;


import java.util.List;

import com.bedroom.common.pojo.College;
import com.bedroom.common.pojo.User;

public interface UserService {
	/**根据输入的账户和密码判断用户是否存在*/
	User userLoginShowUserInfo(String  userName, String user_password);
	
	/**#修改用户个人信息*/
	void updateUserInfo(User user);
	/**根据用户id值查询用户信息 */
	User showUserInfoByUserAccount(String userAccount);
	//-------------
	/**查询所有学院信息 */
	List<College> showAllCollegeName();
	
}
