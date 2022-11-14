package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.FileType;

public interface FileTypeService {
	public List<FileType> getAllFileType() throws SQLException;
}
