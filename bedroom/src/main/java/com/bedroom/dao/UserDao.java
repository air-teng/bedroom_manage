package com.bedroom.dao;

import org.apache.ibatis.annotations.Param;

import com.bedroom.common.pojo.User;

public interface UserDao {
	/**根据输入的账户和密码判断用户是否存在*/
	User userLoginShowUserInfo(@Param("userName") String  userName,@Param("user_password") String user_password);

}
