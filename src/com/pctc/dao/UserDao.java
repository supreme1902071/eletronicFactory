package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.User;

public interface UserDao {

	
	/**
	 * ��¼
	 * @param userName
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User login(String userName,String password) throws SQLException;
	

	/**
	 * �����û�id��ȡURL��Դ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<String> getUrl(Integer id) throws SQLException;
}
