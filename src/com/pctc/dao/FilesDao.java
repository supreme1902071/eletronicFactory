package com.pctc.dao;

import com.pctc.model.Files;
import com.pctc.vo.FilesVo;

import java.sql.SQLException;
import java.util.List;

public interface FilesDao {
    /**
     * 从数据库获取所有档案信息
     * @return
     * @throws SQLException
     */
    public List<Files> getAllFiles() throws SQLException;


    /**
     * 根据id查找档案
     * @param id
     * @return 查找的条数
     * @throws SQLException
     */
    public Files getFilesId(Integer id) throws SQLException;


    /**
     * 添加档案
     * @param files
     * @return 添加的条数
     * @throws SQLException
     */
    public Integer addFiles(Files files) throws SQLException;

    /**
     * 修改档案
     * @param files
     * @return 修改的条数
     * @throws SQLException
     */
    public Integer editFiles(Files files) throws SQLException;


    /**
     * 删除档案
     * @param id
     * @return 删除的条数
     * @throws SQLException
     */
    public Integer dropFiles(Integer id) throws SQLException;

    
    
    
    
    
    
    
    /**
     * 从数据库获取所有档案信息,,多表
     * @return
     * @throws SQLException
     */
    public List<FilesVo> getAllFilesVo() throws SQLException;

    /**
     * 根据id查找档案,,多表
     * @param id
     * @return 查找的条数
     * @throws SQLException
     */
    public FilesVo getFilesVoId(Integer id) throws SQLException;

    /**
     * 分页查询档案表
     * @param page
     * @param num
     * @return 统计的条数
     * @throws SQLException
     */
    public List<FilesVo> getPageFilesVo(int page,int num) throws SQLException;


    /**
     * 得到总页数
     * @return 统计的条数
     * @throws SQLException
     */
    public int getTotalPage() throws SQLException;
  

    /**
     * 添加档案
     * @param files
     * @return 添加的条数
     * @throws SQLException
     */
    public Integer addFilesVo(FilesVo filesVo) throws SQLException;

    /**
     * 修改档案
     * @param files
     * @return 修改的条数
     * @throws SQLException
     */
    public Integer editFilesVo(FilesVo filesVo) throws SQLException;


   

    /**
     * 根据档案存放位置查找档案
     * @param position
     * @return 查找的条数
     * @throws SQLException
     */
    public List<FilesVo> getFilesPositionVo(String position) throws SQLException;

    

}
