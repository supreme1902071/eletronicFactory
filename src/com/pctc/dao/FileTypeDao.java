package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.FileType;

public interface FileTypeDao {
	
	public List<FileType> getAllFileType() throws SQLException;

}
