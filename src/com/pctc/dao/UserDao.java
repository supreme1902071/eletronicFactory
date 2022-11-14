package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.User;

public interface UserDao {

	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User login(String userName,String password) throws SQLException;
	

	/**
	 * 根据用户id获取URL资源
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<String> getUrl(Integer id) throws SQLException;
}
