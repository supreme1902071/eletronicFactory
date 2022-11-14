package com.pctc.service;

import com.pctc.dao.FilesDao;
import com.pctc.model.Files;
import com.pctc.vo.FilesVo;

import java.sql.SQLException;
import java.util.List;

public class FilesServiceImpl implements FilesService{
    private FilesDao filesDao;

    public FilesServiceImpl(FilesDao filesDao){
        this.filesDao = filesDao;
    }

    public List<Files> getAllFiles() throws SQLException {
        return filesDao.getAllFiles();
    }


    public Files getFilesId(Integer id) throws SQLException {
        return filesDao.getFilesId(id);
    }

    public Integer addFiles(Files files) throws SQLException {
        return filesDao.addFiles(files);
    }

    public Integer editFiles(Files files) throws SQLException {
        return filesDao.editFiles(files);
    }


    public Integer dropFiles(Integer id) throws SQLException {
        return filesDao.dropFiles(id);
    }


 

    public List<FilesVo> getAllFilesVo() throws SQLException {
        return filesDao.getAllFilesVo();
    }

    public FilesVo getFilesVoId(Integer id) throws SQLException {
        return filesDao.getFilesVoId(id);
    }

	public Integer addFilesVo(FilesVo filesVo) throws SQLException {
		// TODO Auto-generated method stub
		return filesDao.addFilesVo(filesVo);
	}

	public Integer editFilesVo(FilesVo filesVo) throws SQLException {
		// TODO Auto-generated method stub
		return filesDao.editFilesVo(filesVo);
	}

	public Files getFilesTypeVo(Integer filetype_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FilesVo> getFilesPositionVo(String position) throws SQLException {
		// TODO Auto-generated method stub
		return filesDao.getFilesPositionVo(position);
	}


   


}
