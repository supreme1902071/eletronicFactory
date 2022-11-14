package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Upload;

public interface UploadService {
	/**
	 * ��ѯ����
	 * @return
	 * @throws SQLException
	 */
	public List<Upload> GetAllUpload() throws SQLException;
	
	
	/**
	 * ����
	 * @param upload
	 * @return
	 * @throws SQLException
	 */
	public int addUpload(Upload upload)throws SQLException;
	public int dropUpload(int id) throws SQLException;
}

