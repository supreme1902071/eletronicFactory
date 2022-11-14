package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.pctc.model.FileType;
import com.pctc.util.DButil;

public class FileTypeDaoImpl implements FileTypeDao {
	PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

	public List<FileType> getAllFileType() throws SQLException {
		List<FileType> list=new ArrayList<FileType>();
		
		Connection con=DButil.getConnection();
		String sql="SELECT * FROM filetype";
		preparedStatement=con.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			FileType fileType=new FileType();
			fileType.setId(resultSet.getInt("id"));
			fileType.setFileType(resultSet.getString("file_type"));
			list.add(fileType);
		}
		return list;
	}

}
