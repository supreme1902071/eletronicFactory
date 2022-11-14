package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.UserDao;
import com.pctc.model.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	

	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	public User login(String userName, String password) throws SQLException {
		if(userName==null||password==null)
			throw new SQLException("数据不对！！");
		return userDao.login(userName, password);
	}


	public List<String> getUrl(Integer id) throws SQLException {
		if (id==null)
			throw new SQLException("数据不能为空");
		return userDao.getUrl(id);
	}
	
	

}
