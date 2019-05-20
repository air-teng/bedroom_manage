package com.bedroom.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.User;
import com.bedroom.dao.UserDao;
import com.bedroom.service.UserService;
@Service
public class UserServiceImplement implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User userLoginShowUserInfo(String userName, String user_password) {
		User user=userDao.userLoginShowUserInfo(userName, user_password);
		return user;
	}

}
