package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.UploadDao;
import com.pctc.model.Upload;

public class UploadServiceImpl implements UploadService{
	private UploadDao uploadDao;
	public UploadServiceImpl(UploadDao uploadDao){
		this.uploadDao=uploadDao;
	}
	
	public List<Upload> GetAllUpload() throws SQLException {
		// TODO Auto-generated method stub
		return uploadDao.GetAllUpload();
	}

	public int addUpload(Upload upload) throws SQLException {
		// TODO Auto-generated method stub
		return uploadDao.addUpload(upload);
	}

	public int dropUpload(int id) throws SQLException {
		// TODO Auto-generated method stub
		return uploadDao.dropUpload(id);
	}

}
