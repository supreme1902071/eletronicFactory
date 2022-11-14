package com.pctc.dao;
import com.pctc.model.Lend;
import com.pctc.vo.LendVo;

import java.sql.SQLException;
import java.util.List;

/**
 * ����Dao�ӿ�
 */
public interface LendDao {
    /**
     * �����ݿ��ȡ��������
     * @return
     * @throws SQLException
     */
    public List<Lend> getAllLend() throws SQLException;

    /**
     * ���ѧ��
     * @param lend
     * @return  ��ӵ�����
     * @throws SQLException
     */
    public int addLend(Lend lend)throws SQLException;


    /**
     * �޸Ľ��ĵ���
     * @param lend��ע�⵵�����Ķ����idҪ�����ݿ��д���
     * @return  �޸ĵ�����
     * @throws SQLException
     */
    public int editLend(Lend lend)throws SQLException;


    /**
     * ɾ�����ĵ���
     * @param id   ע��ѧ�������idҪ�����ݿ��д���
     * @return  ɾ��������
     * @throws SQLException
     */

    public int dropLend(Integer id)throws SQLException;

    /**
     * ��ҳ
     * @return
     * @throws SQLException
     */


    public List<Lend> getAllPageLend(int page,int num) throws SQLException;

    public List<Lend> getAllLendIdYear(Integer apartmentId, Integer year) throws SQLException ;
    /**
     * ��ҳ��
     * @return
     * @throws SQLException
     */
    public int getTotalPage() throws SQLException;




    //��ҳ
    /**
     * �����ݿ��ȡ��������
     * @return
     * @throws SQLException
     */
    public List<LendVo> getAllLendVo() throws SQLException;

    /**
     * �����ݿ��ȡһ������
     * @return  һ��ѧ������
     * @throws SQLException
     */
    public LendVo getLendVo(Integer id) throws SQLException;

    /**
     * ���ѧ��
     * @param lend
     * @return  ��ӵ�����
     * @throws SQLException
     */
    public int addLendVo(LendVo lendVo)throws SQLException;


    /**
     * �޸Ľ��ĵ���
     * @param lend��ע�⵵�����Ķ����idҪ�����ݿ��д���
     * @return  �޸ĵ�����
     * @throws SQLException
     */
    public int editLendVo(LendVo lendVo)throws SQLException;


    /**
     * ɾ�����ĵ���
     * @param id   ע��ѧ�������idҪ�����ݿ��д���
     * @return  ɾ��������
     * @throws SQLException
     */
    public int dropLendVo(Integer id)throws SQLException;
    /**
     * ��������Լ����Ĳ��Ų���ĵ���
     * @param apartmentName  year
     * @return  ɾ��������
     * @throws SQLException
     */

    public List<LendVo> getAllLendIdYearVo(String apartmentName, Integer year) throws SQLException ;

    /**
     * ��ҳ
     * @return
     * @throws SQLException
     */
    public List<LendVo> getAllPageLendVo(int page,int num) throws SQLException;


    /**
     * ��ҳ��
     * @return
     * @throws SQLException
     */
    public int getTotalPageVo() throws SQLException;

}
