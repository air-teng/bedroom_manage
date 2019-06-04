package com.bedroom.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedroom.common.pojo.College;
import com.bedroom.common.pojo.User;
import com.bedroom.dao.UserDao;
import com.bedroom.service.UserService;
/**
 * UserService实现类
 * @author Administrator
 */
@Service
public class UserServiceImplement implements UserService {
	@Autowired
	private UserDao userDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User userLoginShowUserInfo(String userName, String user_password) {
		User user=userDao.userLoginShowUserInfo(userName, user_password);
		return user;
	}

	@Override
	public void updateUserInfo(User user) {
		userDao.updateUserInfo(user);
	}

	@Override
	public List<College> showAllCollegeName() {
		return userDao.showAllCollegeName();
	}

	@Override
	public User showUserInfoByUserAccount(String userAccount) {
		return userDao.showUserInfoByUserAccount(userAccount);
	}

}
