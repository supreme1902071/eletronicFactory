package com.pctc.dao;

import com.pctc.cons.Constrant;
import com.pctc.model.Files;
import com.pctc.util.DButil;
import com.pctc.vo.FilesVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilesDaoImpl implements FilesDao{
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;



    public List<Files> getAllFiles() throws SQLException {
        List<Files> list = new ArrayList<Files>();
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select *from files");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Files files = new Files();
            files.setId(resultSet.getInt("id"));
            files.setYear(resultSet.getInt("year"));
            files.setNumber(resultSet.getString("number"));
            files.setFileName(resultSet.getString("file_name"));
            files.setRegister(resultSet.getString("register"));
            files.setPosition(resultSet.getString("position"));
            files.setApartmentId(resultSet.getInt("apartment_id"));
            files.setFiletypeId(resultSet.getInt("filetype_id"));
            files.setSecuritylevelId(resultSet.getInt("securitylevel_id"));
            files.setKeeperId(resultSet.getInt("keeper_id"));
            list.add(files);
        }
        DButil.getConnection();
        return list;
    }


    public Files getFilesId(Integer id) throws SQLException {
        if(id<0){
            throw new SQLException("数据错误！");
        }
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select *from files where id = ? ");
        preparedStatement.setObject(1, id);
        resultSet = preparedStatement.executeQuery();

        Files files = null;
        if (resultSet.next()) {
            files = new Files();
            files.setId(resultSet.getInt("id"));
            files.setYear(resultSet.getInt("year"));
            files.setNumber(resultSet.getString("number"));
            files.setFileName(resultSet.getString("file_name"));
            files.setRegister(resultSet.getString("register"));
            files.setPosition(resultSet.getString("position"));
            files.setApartmentId(resultSet.getInt("apartment_id"));
            files.setFiletypeId(resultSet.getInt("filetype_id"));
            files.setSecuritylevelId(resultSet.getInt("securitylevel_id"));
            files.setKeeperId(resultSet.getInt("keeper_id"));
        } else {
            throw new SQLException("档案表中没有这条数据");
        }
        DButil.closeConnection();
        return files;
    }


    public Integer addFiles(Files files) throws SQLException {
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("insert into files(year,number,file_name,register,position,apartment_id,filetype_id,securitylevel_id,keeper_id)values(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setObject(1, files.getYear());
        preparedStatement.setObject(2, files.getNumber());
        preparedStatement.setObject(3, files.getFileName());
        preparedStatement.setObject(4, files.getRegister());
        preparedStatement.setObject(5, files.getPosition());
        preparedStatement.setObject(6, files.getApartmentId());
        preparedStatement.setObject(7, files.getFiletypeId());
        preparedStatement.setObject(8, files.getSecuritylevelId());
        preparedStatement.setObject(9, files.getKeeperId());
        int count = preparedStatement.executeUpdate();
        DButil.closeConnection();
        return count;
    }


    public Integer editFiles(Files files) throws SQLException {
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("update files set year=?,number=?,file_name=?,register=?,position=?,apartment_id=?,filetype_id=?,securitylevel_id=?,keeper_id=? where id=?");
        preparedStatement.setObject(1, files.getYear());
        preparedStatement.setObject(2, files.getNumber());
        preparedStatement.setObject(3, files.getFileName());
        preparedStatement.setObject(4, files.getRegister());
        preparedStatement.setObject(5, files.getPosition());
        preparedStatement.setObject(6, files.getApartmentId());
        preparedStatement.setObject(7, files.getFiletypeId());
        preparedStatement.setObject(8, files.getSecuritylevelId());
        preparedStatement.setObject(9, files.getKeeperId());
        preparedStatement.setObject(10,files.getId());
        int count = preparedStatement.executeUpdate();
        DButil.closeConnection();
        return count;
    }


    public Integer dropFiles(Integer id) throws SQLException {
        if(id<0){
            throw new SQLException("数据错误！");
        }
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("delete from files where id = ?");
        preparedStatement.setObject(1, id);
        int count = preparedStatement.executeUpdate();
        DButil.closeConnection();
        return count;
    }


    public Files getFilesTypeVo(Integer filetype_id) throws SQLException {
        if(filetype_id<0){
            throw new SQLException("数据错误！");
        }
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select *from files where filetype_id = ? ");
        preparedStatement.setObject(1, filetype_id);
        resultSet = preparedStatement.executeQuery();

        Files files = null;
        if (resultSet.next()) {
            files = new Files();
            files.setId(resultSet.getInt("id"));
            files.setYear(resultSet.getInt("year"));
            files.setNumber(resultSet.getString("number"));
            files.setFileName(resultSet.getString("file_name"));
            files.setRegister(resultSet.getString("register"));
            files.setPosition(resultSet.getString("position"));
            files.setApartmentId(resultSet.getInt("apartment_id"));
            files.setFiletypeId(resultSet.getInt("filetype_id"));
            files.setSecuritylevelId(resultSet.getInt("securitylevel_id"));
            files.setKeeperId(resultSet.getInt("keeper_id"));
        } else {
            throw new SQLException("档案表中没有这条数据");
        }
        DButil.closeConnection();
        return files;
    }



    public List<FilesVo> getFilesPositionVo(String position) throws SQLException {
        if(position==null){
            throw new SQLException("数据错误！");
        }
        Connection connection = DButil.getConnection();
        List<FilesVo> list = new ArrayList<FilesVo>();
        preparedStatement = connection.prepareStatement("select a.id,year,apartment_name,file_type,number,file_name,security_level,register,position,keeper_name from files a,apartment b,filetype c,securitylevel d,keeper e where a.apartment_id=b.id and a.filetype_id=c.id and a.securitylevel_id=d.id and a.keeper_id=e.id and a.position=? ");
        preparedStatement.setObject(1, position);
        resultSet = preparedStatement.executeQuery();

        FilesVo files  = null;
        while(resultSet.next()) {
            files = new FilesVo();
            files.setId(resultSet.getInt("id"));
            files.setYear(resultSet.getInt("year"));
            files.setNumber(resultSet.getString("number"));
            files.setFileName(resultSet.getString("file_name"));
            files.setRegister(resultSet.getString("register"));
            files.setPosition(resultSet.getString("position"));
            files.setApartmentName(resultSet.getString("apartment_name"));
            files.setFiletypeName(resultSet.getString("file_type"));
            files.setSecuritylevelName(resultSet.getString("security_level"));
            files.setKeeperName(resultSet.getString("keeper_name"));
            list.add(files);
        }
        DButil.closeConnection();
        return list;
    }


    public List<FilesVo> getAllFilesVo() throws SQLException {
        List<FilesVo> list = new ArrayList<FilesVo>();
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select a.id,year,apartment_name,file_type,number,file_name,security_level,register,position,keeper_name from files a,apartment b,filetype c,securitylevel d,keeper e where a.apartment_id=b.id and a.filetype_id=c.id and a.securitylevel_id=d.id and a.keeper_id=e.id");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            FilesVo filesVo = new FilesVo();
            filesVo.setId(resultSet.getInt("id"));
            filesVo.setYear(resultSet.getInt("year"));
            filesVo.setNumber(resultSet.getString("number"));
            filesVo.setFileName(resultSet.getString("file_name"));
            filesVo.setRegister(resultSet.getString("register"));
            filesVo.setPosition(resultSet.getString("position"));
            filesVo.setApartmentName(resultSet.getString("apartment_name"));
            filesVo.setFiletypeName(resultSet.getString("file_type"));
            filesVo.setSecuritylevelName(resultSet.getString("security_level"));
            filesVo.setKeeperName(resultSet.getString("keeper_name"));
            list.add(filesVo);
        }
        DButil.getConnection();
        return list;
    }


    public FilesVo getFilesVoId(Integer id) throws SQLException {
        if(id<0){
            throw new SQLException("数据错误！");
        }
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select a.id,year,apartment_name,file_type,number,file_name,security_level,register,position,keeper_name from files a,apartment b,filetype c,securitylevel d,keeper e where a.apartment_id=b.id and a.filetype_id=c.id and a.securitylevel_id=d.id and a.keeper_id=e.id  and a.id = ? ");
        preparedStatement.setObject(1, id);
        resultSet = preparedStatement.executeQuery();

        FilesVo filesVo = null;
        if (resultSet.next()) {
            filesVo = new FilesVo();
            filesVo.setId(resultSet.getInt("id"));
            filesVo.setYear(resultSet.getInt("year"));
            filesVo.setNumber(resultSet.getString("number"));
            filesVo.setFileName(resultSet.getString("file_name"));
            filesVo.setRegister(resultSet.getString("register"));
            filesVo.setPosition(resultSet.getString("position"));
            filesVo.setApartmentName(resultSet.getString("apartment_name"));
            filesVo.setFiletypeName(resultSet.getString("file_type"));
            filesVo.setSecuritylevelName(resultSet.getString("security_level"));
            filesVo.setKeeperName(resultSet.getString("keeper_name"));
        } else {
            throw new SQLException("档案表中没有这条数据");
        }
        DButil.closeConnection();
        return filesVo;
    }


    public List<FilesVo> getPageFilesVo(int page, int num) throws SQLException {
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement(" select a.id,year,apartment_name,file_type,number,file_name,security_level,register,position,keeper_name from files a,apartment b,filetype c,securitylevel d,keeper e where a.apartment_id=b.id and a.filetype_id=c.id and a.securitylevel_id=d.id and a.keeper_id=e.id order by a.id ASC  limit ?,? ");
        preparedStatement.setObject(1,(page-1)*num);
        preparedStatement.setObject(2,num);
        resultSet = preparedStatement.executeQuery();

        List<FilesVo> lists = new ArrayList<FilesVo>();
        while(resultSet.next()){
            FilesVo filesVo = new FilesVo();
            filesVo.setId(resultSet.getInt("id"));
            filesVo.setYear(resultSet.getInt("year"));
            filesVo.setNumber(resultSet.getString("number"));
            filesVo.setFileName(resultSet.getString("file_name"));
            filesVo.setRegister(resultSet.getString("register"));
            filesVo.setPosition(resultSet.getString("position"));
            filesVo.setApartmentName(resultSet.getString("apartment_name"));
            filesVo.setFiletypeName(resultSet.getString("file_type"));
            filesVo.setSecuritylevelName(resultSet.getString("security_level"));
            filesVo.setKeeperName(resultSet.getString("keeper_name"));
            lists.add(filesVo);
        }
        DButil.closeConnection();
        return lists;
    }

    public int getTotalPage() throws SQLException {
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select count(1) from files");
        resultSet = preparedStatement.executeQuery();

        int total=0;
        if (resultSet.next()){
            total=resultSet.getInt(1);
        }
        int page=0;
        if (total % Constrant.PAGE_NUMBER==0){
            page=total / Constrant.PAGE_NUMBER;
        }else
            page=total / Constrant.PAGE_NUMBER+1;

        return page;
    }


	public Integer addFilesVo(FilesVo filesVo) throws SQLException {
		  Connection connection = DButil.getConnection();
	        preparedStatement = connection.prepareStatement("insert into files(year,number,file_name,register,position,apartment_id,filetype_id,securitylevel_id,keeper_id)values(?,?,?,?,?,(select id from apartment where apartment_name=?),(select id from filetype  where file_type=?),(select id from securitylevel  where security_level=?),(select id from keeper where keeper_name=?))");
	        preparedStatement.setObject(1, filesVo.getYear());
	        preparedStatement.setObject(2, filesVo.getNumber());
	        preparedStatement.setObject(3, filesVo.getFileName());
	        preparedStatement.setObject(4, filesVo.getRegister());
	        preparedStatement.setObject(5, filesVo.getPosition());
	        preparedStatement.setObject(6, filesVo.getApartmentName());
	        preparedStatement.setObject(7, filesVo.getFiletypeName());
	        preparedStatement.setObject(8, filesVo.getSecuritylevelName());
	        preparedStatement.setObject(9, filesVo.getKeeperName());
	        int count = preparedStatement.executeUpdate();
	        DButil.closeConnection();
	        return count;
	}


	public Integer editFilesVo(FilesVo filesVo) throws SQLException {
		// TODO Auto-generated method stub
		 Connection connection = DButil.getConnection();
	        preparedStatement = connection.prepareStatement("update files set year=?,number=?,file_name=?,register=?,position=?,apartment_id=(select id from apartment where apartment_name=?),filetype_id=(select id from filetype where file_type=?),securitylevel_id=(select id from securitylevel where security_level=?),keeper_id=(select id from keeper where keeper_name=?) where id=?");
	        preparedStatement.setObject(1, filesVo.getYear());
	        preparedStatement.setObject(2, filesVo.getNumber());
	        preparedStatement.setObject(3, filesVo.getFileName());
	        preparedStatement.setObject(4, filesVo.getRegister());
	        preparedStatement.setObject(5, filesVo.getPosition());
	        preparedStatement.setObject(6, filesVo.getApartmentName());
	        preparedStatement.setObject(7, filesVo.getFiletypeName());
	        preparedStatement.setObject(8, filesVo.getSecuritylevelName());
	        preparedStatement.setObject(9, filesVo.getKeeperName());
	        preparedStatement.setObject(10,filesVo.getId());
	        int count = preparedStatement.executeUpdate();
	        DButil.closeConnection();
	        return count;
	}
}
