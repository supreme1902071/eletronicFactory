package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.FileTypeDao;
import com.pctc.model.FileType;

public class FileTypeServiceImpl implements FileTypeService {
	private FileTypeDao fileTypeDao;
	public FileTypeServiceImpl(FileTypeDao fileTypeDao){
		this.fileTypeDao =fileTypeDao;
		}

	public List<FileType> getAllFileType() throws SQLException {
		// TODO Auto-generated method stub
		return fileTypeDao.getAllFileType();
	}

}
