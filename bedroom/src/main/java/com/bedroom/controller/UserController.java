package com.bedroom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedroom.common.AjaxResult;
import com.bedroom.common.pojo.College;
import com.bedroom.common.pojo.User;
import com.bedroom.service.UserService;
/**
 * 用户管理接口层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录判断;   /user/login
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public AjaxResult userLoginPage(String userName,String userPassword,HttpSession session) {
		try {
			//判断输入的是否为空
			String name=userName.trim();
			String pwd=userPassword.trim();
			if("".equals(name) || "".equals(pwd)) {
				return AjaxResult.error("账户或密码不能为空!");
			}
			//判断输入的账户密码是否存在
			User user=userService.userLoginShowUserInfo(name, pwd);
			if(user==null) {
				return AjaxResult.error("账户或密码错误!");
			};
			//登录成功将用户信息存入session域中
			session.setAttribute("user", user);
			//设置session有效时间
			session.setMaxInactiveInterval(60*60);//1小时
		} catch (Exception e) {
			return AjaxResult.error("登录失败!!!");
		}
		return AjaxResult.oK();
	}
	
	
//	/user/updateUserInfo
	/**
	 * 修改个人信息
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public AjaxResult updateUserInfo(User user,HttpSession session) {
		try {
			//获取所有学院信息
			List<College> list=userService.showAllCollegeName();
			Boolean flag=false;
			for (int i=0;i<list.size();i++) {
				//如果输入学院信息有一致的信息,改变flag标志
				if(list.get(i).getCollegeName().equals(user.getUserCollegeName())) {
					flag=true;
					break;
				}
			}
			if(flag!=true) {
				return AjaxResult.error("输入的学院信息有误");
			}
			//获取用户信息并封装数据给数据库
			User sesUser = (User) session.getAttribute("user");
			user.setUserAccount(sesUser.getUserAccount());
			userService.updateUserInfo(user);
			//重新给session赋值
			User newUser=userService.showUserInfoByUserAccount(user.getUserAccount());
			session.setAttribute("user", newUser);
		} catch (Exception e) {
			return AjaxResult.error();
		}
		return AjaxResult.oK("修改成功!");
	}
	
	
}
