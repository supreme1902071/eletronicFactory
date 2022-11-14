package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pctc.model.FileType;
import com.pctc.model.Keeper;
import com.pctc.util.DButil;

public class KeeperDaoImpl implements KeeperDao {
	PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
	public List<Keeper> getAllKeeper() throws SQLException {
		List<Keeper> list=new ArrayList<Keeper>();
		
		Connection con=DButil.getConnection();
		String sql="SELECT * FROM keeper";
		preparedStatement=con.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			Keeper keeper=new Keeper();
			keeper.setId(resultSet.getInt("id"));
			keeper.setKeeperName(resultSet.getString("keeper_name"));
			list.add(keeper);
		}
		return list;
	}

}
