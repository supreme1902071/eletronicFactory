package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.pctc.model.SecurityLevel;
import com.pctc.util.DButil;

public class SecurityLevelDaoImpl implements SecurityLevelDao {
	PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
	public List<SecurityLevel> getAllSecurityLevel() throws SQLException {
		List<SecurityLevel> list=new ArrayList<SecurityLevel>();
		
		Connection con=DButil.getConnection();
		String sql="SELECT * FROM securitylevel";
		preparedStatement=con.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			SecurityLevel securityLevel=new SecurityLevel();
			securityLevel.setId(resultSet.getInt("id"));
			securityLevel.setSecurityLevel(resultSet.getString("security_level"));
			list.add(securityLevel);
		}
		return list;
	}

}
