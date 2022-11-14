package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pctc.model.Upload;
import com.pctc.util.DButil;

public class UploadDaoImpl implements UploadDao{
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	
	
	public List<Upload> GetAllUpload() throws SQLException {
		
		List<Upload> list=new ArrayList<Upload>();
		Connection con=DButil.getConnection();
	    String sql="SELECT * from upload";
	    preparedStatement=con.prepareStatement(sql);
	    resultSet=preparedStatement.executeQuery();
	    
	    while(resultSet.next()){
	    	Upload upload=new Upload();
	    	upload.setId(resultSet.getInt("id"));
	    	upload.setFilename(resultSet.getString("document_name"));
	    	upload.setUsername(resultSet.getString("user_name"));
	    	upload.setUploadtime(resultSet.getTimestamp("upload_time"));
	    	
	    	list.add(upload);
	    }
	    DButil.closeConnection();
        return list;
		
	}

	public int addUpload(Upload upload) throws SQLException{
		Connection con=DButil.getConnection();
		String sql="insert into upload(id,document_name,user_name,upload_time) values (?,?,?,?)";
		preparedStatement=con.prepareStatement(sql);
		
		preparedStatement.setObject(1,upload.getId());
		preparedStatement.setObject(2, upload.getFilename());
		preparedStatement.setObject(3, upload.getUsername());
		preparedStatement.setObject(4, upload.getUploadtime());
		
		int count=preparedStatement.executeUpdate();
		return count;
	}

	public int dropUpload(int id) throws SQLException{
		 Connection con=DButil.getConnection();
	        String sql="delete from upload where id=? ";
	        preparedStatement=con.prepareStatement(sql);
	        preparedStatement.setObject(1,id);
	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
		
	}
}
