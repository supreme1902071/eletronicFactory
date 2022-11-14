package com.pctc.test;

import java.sql.SQLException;

import com.pctc.dao.UserDao;
import com.pctc.dao.UserDaoImpl;
import com.pctc.service.UserService;
import com.pctc.service.UserServiceImpl;
import com.pctc.util.MD5Util;



public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		try {
			System.out.println(userService.login("zhangsan", "e10adc3949ba59abbe56e057f20f883e"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String password="123456";
		System.out.print(MD5Util.encryptMD5(password));

	}

}
