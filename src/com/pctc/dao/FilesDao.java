package com.pctc.dao;

import com.pctc.model.Files;
import com.pctc.vo.FilesVo;

import java.sql.SQLException;
import java.util.List;

public interface FilesDao {
    /**
     * �����ݿ��ȡ���е�����Ϣ
     * @return
     * @throws SQLException
     */
    public List<Files> getAllFiles() throws SQLException;


    /**
     * ����id���ҵ���
     * @param id
     * @return ���ҵ�����
     * @throws SQLException
     */
    public Files getFilesId(Integer id) throws SQLException;


    /**
     * ��ӵ���
     * @param files
     * @return ��ӵ�����
     * @throws SQLException
     */
    public Integer addFiles(Files files) throws SQLException;

    /**
     * �޸ĵ���
     * @param files
     * @return �޸ĵ�����
     * @throws SQLException
     */
    public Integer editFiles(Files files) throws SQLException;


    /**
     * ɾ������
     * @param id
     * @return ɾ��������
     * @throws SQLException
     */
    public Integer dropFiles(Integer id) throws SQLException;

    
    
    
    
    
    
    
    /**
     * �����ݿ��ȡ���е�����Ϣ,,���
     * @return
     * @throws SQLException
     */
    public List<FilesVo> getAllFilesVo() throws SQLException;

    /**
     * ����id���ҵ���,,���
     * @param id
     * @return ���ҵ�����
     * @throws SQLException
     */
    public FilesVo getFilesVoId(Integer id) throws SQLException;

    /**
     * ��ҳ��ѯ������
     * @param page
     * @param num
     * @return ͳ�Ƶ�����
     * @throws SQLException
     */
    public List<FilesVo> getPageFilesVo(int page,int num) throws SQLException;


    /**
     * �õ���ҳ��
     * @return ͳ�Ƶ�����
     * @throws SQLException
     */
    public int getTotalPage() throws SQLException;
  

    /**
     * ��ӵ���
     * @param files
     * @return ��ӵ�����
     * @throws SQLException
     */
    public Integer addFilesVo(FilesVo filesVo) throws SQLException;

    /**
     * �޸ĵ���
     * @param files
     * @return �޸ĵ�����
     * @throws SQLException
     */
    public Integer editFilesVo(FilesVo filesVo) throws SQLException;


   

    /**
     * ���ݵ������λ�ò��ҵ���
     * @param position
     * @return ���ҵ�����
     * @throws SQLException
     */
    public List<FilesVo> getFilesPositionVo(String position) throws SQLException;

    

}
