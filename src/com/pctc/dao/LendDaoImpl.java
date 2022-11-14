package com.pctc.dao;

import com.pctc.cons.Constrant;
import com.pctc.model.Lend;
import com.pctc.util.DButil;
import com.pctc.vo.LendVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LendDaoImpl implements LendDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     *
     * @return
     * @throws SQLException
     */

    public List<Lend> getAllLend() throws SQLException {
        //保存数据库中拿过来的借阅对象
        List<Lend> lists = new ArrayList<Lend>();
        // 连接
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select * from lend");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            // 把学生表中的记录转换成内存中Student对象
            Lend lend = new Lend();
            lend.setId(resultSet.getInt("id"));
            lend.setNumber(resultSet.getString("number"));
            lend.setYear(resultSet.getInt("year"));
            lend.setFileName(resultSet.getString("file_name"));
            lend.setLendTime(resultSet.getTimestamp("lend_time"));
            lend.setReturnTime(resultSet.getTimestamp("return_time"));
            lend.setFlag(resultSet.getBoolean("flag"));
            lend.setApartmentId(resultSet.getInt("apartment_id"));
            lend.setLender(resultSet.getString("lender"));

            lists.add(lend);

        }

        DButil.closeConnection();
        return lists;
    }

    public int addLend(Lend lend) throws SQLException {
            if(lend==null)
                throw new SQLException("数据输入错误！！！！");
            // 连接
            Connection connection = DButil.getConnection();

            //发送sql语句
            preparedStatement = connection.prepareStatement("insert into lend (number,year,file_name,lend_time,return_time,flag,apartment_id,lender) values(?,?,?,?,?,?,?,?) ");

            //给？赋值
            preparedStatement.setObject(1,lend.getNumber());
            preparedStatement.setObject(2,lend.getYear());
            preparedStatement.setObject(3,lend.getFileName());
            preparedStatement.setObject(4,lend.getLendTime());
            preparedStatement.setObject(5,lend.getReturnTime());
            preparedStatement.setObject(6,lend.getFlag());
            preparedStatement.setObject(7,lend.getApartmentId());
            preparedStatement.setObject(8,lend.getLender());

            //外键字段值


            //执行的条数,如果是0失败，大于0成功
            int count=preparedStatement.executeUpdate();

            DButil.closeConnection();

            return count;


    }

    public int editLend(Lend lend) throws SQLException {
        if(lend==null)
            throw new SQLException("数据输入错误！！！！");
        // 连接
        Connection connection = DButil.getConnection();

        //发送sql语句
        preparedStatement = connection.prepareStatement("update lend set number=?,year=?,file_name=?,lend_time=?,return_time=?,flag=?,apartment_id=?,lender=? where id=? ");

        //给？赋值
        preparedStatement.setObject(1,lend.getNumber());
        preparedStatement.setObject(2,lend.getYear());
        preparedStatement.setObject(3,lend.getFileName());
        preparedStatement.setObject(4,lend.getLendTime());
        preparedStatement.setObject(5,lend.getReturnTime());
        preparedStatement.setObject(6,lend.getFlag());
        preparedStatement.setObject(7,lend.getApartmentId());
        preparedStatement.setObject(8,lend.getLender());
        preparedStatement.setObject(9,lend.getId());

        //外键字段值


        //执行的条数,如果是0失败，大于0成功
        int count=preparedStatement.executeUpdate();

        DButil.closeConnection();

        return count;

    }

    public int dropLend(Integer id) throws SQLException {
        if(id<=0)
            throw new SQLException("数据输入错误！！！！");

        // 连接
        Connection connection = DButil.getConnection();

        //发送sql语句
        preparedStatement = connection.prepareStatement("delete from lend where id=?");

        //给？赋值
        preparedStatement.setObject(1,id);

        //执行的条数,如果是0失败，大于0成功
        int count=preparedStatement.executeUpdate();

        DButil.closeConnection();

        return count;
    }

    public List<Lend> getAllPageLend(int page, int num) throws SQLException {

        //保存数据库中拿过来的学生对象
        List<Lend> lists = new ArrayList<Lend>();

        // 连接
        Connection connection = DButil.getConnection();

        //发送sql命令
        preparedStatement = connection.prepareStatement("select * from lend limit ?,?");
        preparedStatement.setObject(1, (page - 1) * num);
        preparedStatement.setObject(2, num);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            // 把学生表中的记录转换成内存中Student对象
            Lend lend = new Lend();

            //把数据表中的某个字段的值装载到学生类的某个属性上
            lend.setId(resultSet.getInt("id"));
            lend.setNumber(resultSet.getString("number"));
            lend.setYear(resultSet.getInt("year"));
            lend.setFileName(resultSet.getString("file_name"));
            lend.setLendTime(resultSet.getTimestamp("lend_time"));
            lend.setReturnTime(resultSet.getTimestamp("return_time"));
            lend.setFlag(resultSet.getBoolean("flag"));
            lend.setApartmentId(resultSet.getInt("apartment_id"));
            lend.setLender(resultSet.getString("lender"));

            lists.add(lend);
        }
            DButil.closeConnection();
            return lists;

    }

    public List<Lend> getAllLendIdYear(Integer apartmentId, Integer year) throws SQLException {
        return null;
    }

    public int getTotalPage() throws SQLException {
            Connection connection = DButil.getConnection();

            //发送sql命令
            preparedStatement = connection.prepareStatement("select count(1) from lend");
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

    public List<LendVo> getAllLendVo() throws SQLException {
        //保存数据库中拿过来的借阅对象
        List<LendVo> lists = new ArrayList<LendVo>();
        // 连接
        Connection connection = DButil.getConnection();
        preparedStatement = connection.prepareStatement("select a.id,a.number,a.year,a.file_name,a.lend_time,a.return_time,a.flag,apartment_name,a.lender from lend a,apartment b where a.apartment_id=b.id");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            // 把学生表中的记录转换成内存中Student对象
            LendVo lendVo = new LendVo();
            lendVo.setId(resultSet.getInt("id"));
            lendVo.setNumber(resultSet.getString("number"));
            lendVo.setYear(resultSet.getInt("year"));
            lendVo.setFileName(resultSet.getString("file_name"));
            lendVo.setLendTime(resultSet.getTimestamp("lend_time"));
            lendVo.setReturnTime(resultSet.getTimestamp("return_time"));
            lendVo.setFlag(resultSet.getBoolean("flag"));
            lendVo.setApartmentName(resultSet.getString("apartment_name"));
            lendVo.setLender(resultSet.getString("lender"));

            lists.add(lendVo);

        }

        DButil.closeConnection();
        return lists;
    }

    public int addLendVo(LendVo lendVo) throws SQLException {
        if(lendVo==null)
            throw new SQLException("数据输入错误！！！！");
        // 连接
        Connection connection = DButil.getConnection();

        //发送sql语句
        preparedStatement = connection.prepareStatement("insert into lend (number,year,file_name,lend_time,return_time,flag,apartment_id,lender) values(?,?,?,?,?,?,(select id from apartment where apartment_name=?),?) ");

        //给？赋值
        preparedStatement.setObject(1,lendVo.getNumber());
        preparedStatement.setObject(2,lendVo.getYear());
        preparedStatement.setObject(3,lendVo.getFileName());
        preparedStatement.setObject(4,lendVo.getLendTime());
        preparedStatement.setObject(5,lendVo.getReturnTime());
        preparedStatement.setObject(6,lendVo.getFlag());
        preparedStatement.setObject(7,lendVo.getApartmentName());
        preparedStatement.setObject(8,lendVo.getLender());

        //外键字段值


        //执行的条数,如果是0失败，大于0成功
        int count=preparedStatement.executeUpdate();

        DButil.closeConnection();

        return count;

    }

    public int editLendVo(LendVo lendVo) throws SQLException {
        if(lendVo==null)
            throw new SQLException("数据输入错误！！！！");
        // 连接
        Connection connection = DButil.getConnection();

        //发送sql语句
        preparedStatement = connection.prepareStatement("update lend set number=?,year=?,file_name=?,return_time=?,flag=?,apartment_id=(select id from apartment where apartment_name=?),lender=? where id=? ");

        //给？赋值
        preparedStatement.setObject(1,lendVo.getNumber());
        preparedStatement.setObject(2,lendVo.getYear());
        preparedStatement.setObject(3,lendVo.getFileName());
       // preparedStatement.setObject(4,lendVo.getLendTime());
        preparedStatement.setObject(4,lendVo.getReturnTime());
        preparedStatement.setObject(5,lendVo.getFlag());
        preparedStatement.setObject(6,lendVo.getApartmentName());
        preparedStatement.setObject(7,lendVo.getLender());
        preparedStatement.setObject(8,lendVo.getId());

        //外键字段值


        //执行的条数,如果是0失败，大于0成功
        int count=preparedStatement.executeUpdate();

        DButil.closeConnection();

        return count;

    }

    public int dropLendVo(Integer id) throws SQLException {
        if(id<=0)
            throw new SQLException("数据输入错误！！！！");

        // 连接
        Connection connection = DButil.getConnection();

        //发送sql语句
        preparedStatement = connection.prepareStatement("delete from lend where id=?");

        //给？赋值
        preparedStatement.setObject(1,id);

        //执行的条数,如果是0失败，大于0成功
        int count=preparedStatement.executeUpdate();

        DButil.closeConnection();

        return count;
    }


    public List<LendVo> getAllLendIdYearVo(String apartmentName, Integer year) throws SQLException {
        List<LendVo> lists = new ArrayList<LendVo>();

        // 连接
        Connection connection = DButil.getConnection();

        //发送sql命令
        preparedStatement = connection.prepareStatement("select a.id,a.number,a.year,a.file_name,a.lend_time,a.return_time,a.flag,b.apartment_name,a.lender from lend a,apartment b where a.apartment_id=b.id and b.apartment_name=? and a.year=?");
        preparedStatement.setObject(1,apartmentName);
        preparedStatement.setObject(2,year);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            // 把表中的记录转换成内存中借阅档案对象
            LendVo lendVo = new LendVo();

            //把数据表中的某个字段的值装载到学生类的某个属性上
            lendVo.setId(resultSet.getInt("id"));
            lendVo.setNumber(resultSet.getString("number"));
            lendVo.setYear(resultSet.getInt("year"));
            lendVo.setFileName(resultSet.getString("file_name"));
            lendVo.setLendTime(resultSet.getTimestamp("lend_time"));
            lendVo.setReturnTime(resultSet.getTimestamp("return_time"));
            lendVo.setFlag(resultSet.getBoolean("flag"));
            lendVo.setApartmentName(resultSet.getString("apartment_name"));
            lendVo.setLender(resultSet.getString("lender"));

            lists.add(lendVo);
        }
        DButil.closeConnection();
        return lists;

    }

    public List<LendVo> getAllPageLendVo(int page, int num) throws SQLException {

        //保存数据库中拿过来的学生对象
        List<LendVo> lists = new ArrayList<LendVo>();

        // 连接
        Connection connection = DButil.getConnection();

        //发送sql命令
        preparedStatement = connection.prepareStatement("select a.id,a.number,a.year,a.file_name,a.lend_time,a.return_time,a.flag,b.apartment_name,a.lender from lend a,apartment b where a.apartment_id=b.id limit ?,?");
        preparedStatement.setObject(1, (page - 1) * num);
        preparedStatement.setObject(2, num);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            // 把学生表中的记录转换成内存中Student对象
            LendVo lend = new LendVo();

            //把数据表中的某个字段的值装载到学生类的某个属性上
            lend.setId(resultSet.getInt("id"));
            lend.setNumber(resultSet.getString("number"));
            lend.setYear(resultSet.getInt("year"));
            lend.setFileName(resultSet.getString("file_name"));
            lend.setLendTime(resultSet.getTimestamp("lend_time"));
            lend.setReturnTime(resultSet.getTimestamp("return_time"));
            lend.setFlag(resultSet.getBoolean("flag"));
            lend.setApartmentName(resultSet.getString("apartment_name"));
            lend.setLender(resultSet.getString("lender"));

            lists.add(lend);
        }
        DButil.closeConnection();
        return lists;

    }

    public int getTotalPageVo() throws SQLException {
        Connection connection = DButil.getConnection();

        //发送sql命令
        preparedStatement = connection.prepareStatement("select count(1) from lend");
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

    public LendVo getLendVo(Integer id) throws SQLException {
		  
	        Connection connection = DButil.getConnection();
	        preparedStatement = connection.prepareStatement("select a.id,a.number,a.year,a.file_name,a.lend_time,a.return_time,a.flag,b.apartment_name,a.lender from lend a,apartment b where a.apartment_id=b.id and a.id=?");
	        preparedStatement.setObject(1,id);
	        resultSet = preparedStatement.executeQuery();
	        LendVo lendVo =null;
	        if(resultSet.next()) {

	            // 把学生表中的记录转换成内存中Student对象
	           lendVo = new LendVo();
	            lendVo.setId(resultSet.getInt("id"));
	            lendVo.setNumber(resultSet.getString("number"));
	            lendVo.setYear(resultSet.getInt("year"));
	            lendVo.setFileName(resultSet.getString("file_name"));
	            lendVo.setLendTime(resultSet.getTimestamp("lend_time"));
	            lendVo.setReturnTime(resultSet.getTimestamp("return_time"));
	            lendVo.setFlag(resultSet.getBoolean("flag"));
	            lendVo.setApartmentName(resultSet.getString("apartment_name"));
	            lendVo.setLender(resultSet.getString("lender"));

	    

	        }else
	        	 throw new SQLException("表中没有这条数据！！");

	        DButil.closeConnection();
			return lendVo;
	        
	}

	

	

	
}
