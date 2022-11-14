package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;


import com.pctc.model.Upload;

public interface UploadDao {
	/**
	 * 查询所有
	 * @return
	 * @throws SQLException
	 */
	public List<Upload> GetAllUpload() throws SQLException;
	
	
	/**
	 * 添加
	 * @param upload
	 * @return
	 * @throws SQLException
	 */
	public int addUpload(Upload upload)throws SQLException;
	

	public int dropUpload(int id) throws SQLException;
}
