package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pctc.model.User;
import com.pctc.util.DButil;

public class UserDaoImpl implements UserDao {
	
	private PreparedStatement preparedStatement;
    private ResultSet resultSet;

	public User login(String userName, String password) throws SQLException {
		 Connection connection = DButil.getConnection();
		 preparedStatement = connection.prepareStatement("select * from user where user_name=? and password=?");
	     preparedStatement.setObject(1, userName);
	     preparedStatement.setObject(2, password);
	     resultSet = preparedStatement.executeQuery();
	     User user=null;
	     if (resultSet.next()) {
	    	 user=new User();
	    	 user.setId(resultSet.getInt("id"));
	    	 user.setUserName(resultSet.getString("user_name"));
	    	 user.setPassword(resultSet.getString("password"));
	    	 
	     }
	     return user;

   }

	public List<String> getUrl(Integer id) throws SQLException {
		Connection con=DButil.getConnection();
		
		String sql="SELECT * from menu where id IN (SELECT b.menu_id from role a,role_menu b WHERE a.id=b.role_id AND b.role_id IN (SELECT b.role_id FROM user a,user_role b WHERE a.id=b.user_id and a.id=?))";
		preparedStatement=con.prepareStatement(sql);
		preparedStatement.setObject(1, id);
		
		resultSet=preparedStatement.executeQuery();
		List<String> list=new ArrayList<String>();
		while(resultSet.next()){
			String s=resultSet.getString("url");
			list.add(s);
		}
		
		return list;
	}
}
