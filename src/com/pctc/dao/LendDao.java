package com.pctc.dao;
import com.pctc.model.Lend;
import com.pctc.vo.LendVo;

import java.sql.SQLException;
import java.util.List;

/**
 * 档案Dao接口
 */
public interface LendDao {
    /**
     * 从数据库获取所有数据
     * @return
     * @throws SQLException
     */
    public List<Lend> getAllLend() throws SQLException;

    /**
     * 添加学生
     * @param lend
     * @return  添加的条数
     * @throws SQLException
     */
    public int addLend(Lend lend)throws SQLException;


    /**
     * 修改借阅档案
     * @param lend，注意档案借阅对象的id要在数据库中存在
     * @return  修改的条数
     * @throws SQLException
     */
    public int editLend(Lend lend)throws SQLException;


    /**
     * 删除借阅档案
     * @param id   注意学生对象的id要在数据库中存在
     * @return  删除的条数
     * @throws SQLException
     */

    public int dropLend(Integer id)throws SQLException;

    /**
     * 分页
     * @return
     * @throws SQLException
     */


    public List<Lend> getAllPageLend(int page,int num) throws SQLException;

    public List<Lend> getAllLendIdYear(Integer apartmentId, Integer year) throws SQLException ;
    /**
     * 总页数
     * @return
     * @throws SQLException
     */
    public int getTotalPage() throws SQLException;




    //分页
    /**
     * 从数据库获取所有数据
     * @return
     * @throws SQLException
     */
    public List<LendVo> getAllLendVo() throws SQLException;

    /**
     * 从数据库获取一个对象
     * @return  一个学生对象
     * @throws SQLException
     */
    public LendVo getLendVo(Integer id) throws SQLException;

    /**
     * 添加学生
     * @param lend
     * @return  添加的条数
     * @throws SQLException
     */
    public int addLendVo(LendVo lendVo)throws SQLException;


    /**
     * 修改借阅档案
     * @param lend，注意档案借阅对象的id要在数据库中存在
     * @return  修改的条数
     * @throws SQLException
     */
    public int editLendVo(LendVo lendVo)throws SQLException;


    /**
     * 删除借阅档案
     * @param id   注意学生对象的id要在数据库中存在
     * @return  删除的条数
     * @throws SQLException
     */
    public int dropLendVo(Integer id)throws SQLException;
    /**
     * 根据年份以及借阅部门查借阅档案
     * @param apartmentName  year
     * @return  删除的条数
     * @throws SQLException
     */

    public List<LendVo> getAllLendIdYearVo(String apartmentName, Integer year) throws SQLException ;

    /**
     * 分页
     * @return
     * @throws SQLException
     */
    public List<LendVo> getAllPageLendVo(int page,int num) throws SQLException;


    /**
     * 总页数
     * @return
     * @throws SQLException
     */
    public int getTotalPageVo() throws SQLException;

}
