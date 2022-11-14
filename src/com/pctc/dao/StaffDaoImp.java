package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pctc.cons.Constrant;
import com.pctc.model.Staff;

import com.pctc.util.DButil;
import com.pctc.vo.StaffVo;



public class StaffDaoImp implements StaffDao {
	 PreparedStatement preparedStatement=null;
	    ResultSet resultSet=null;


	
	public List<Staff> getAllStaff() throws SQLException {
		  List<Staff> lists=new ArrayList<Staff>();
		  
		  Connection con= DButil.getConnection();
		 
		  preparedStatement=con.prepareStatement("select * from staff");
		  resultSet=preparedStatement.executeQuery();
		 
		  while(resultSet.next()){
			  Staff staff=new Staff();
			  staff.setId(resultSet.getInt("id"));
			  staff.setStaffName(resultSet.getString("staff_name"));
			  staff.setSex(resultSet.getBoolean("sex"));
			  staff.setBirthday(resultSet.getDate("birthday"));
			  staff.setNation(resultSet.getString("nation"));
			  staff.setIdCard(resultSet.getString("id_card"));
			  staff.setDomicile(resultSet.getString("domicile"));
			  staff.setApartmentId(resultSet.getInt("apartment_id"));
			  staff.setFiletypeId(resultSet.getInt("filetype_id"));
			     lists.add(staff);
			  
		  }
		   DButil.closeConnection();

	        return lists;
	}

//	@Override
	public int addStaff(StaffVo staff) throws SQLException {
		// TODO Auto-generated method stub
		
    	
        Connection con=DButil.getConnection();
                                                                                                                                                                    
        preparedStatement = con.prepareStatement("insert into staff (id,staff_name,sex,birthday,nation,id_card,domicile,apartment_id,filetype_id) values(?,?,?,?,?,?,?,(select id from apartment where apartment_name=?),(select id from filetype where file_type=?))");
          
       preparedStatement.setObject(1, staff.getId());
        preparedStatement.setObject(2, staff.getStaffName());
        preparedStatement.setObject(3, staff.getSex());
        preparedStatement.setObject(4, staff.getBirthday());
        preparedStatement.setObject(5, staff.getNation());
        preparedStatement.setObject(6, staff.getIdCard());
        preparedStatement.setObject(7, staff.getDomicile());
//        preparedStatement.setObject(8, staff.getApartmentId());
//        preparedStatement.setObject(9, staff.getFiletypeId());
        preparedStatement.setObject(8, staff.getApartmentName());
        preparedStatement.setObject(9, staff.getFileType());
        
        int count=preparedStatement.executeUpdate();
		   DButil.closeConnection();
		   return count;
	}

	
	public int editStaff(StaffVo staff) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=DButil.getConnection();
		String sql="update staff set staff_name=?,sex=?,birthday=?,nation=?,id_card=?,domicile=?,apartment_id=(select id from apartment where apartment_name=?),filetype_id=(select id from filetype where file_type=?)  where id=?";
			preparedStatement=connection.prepareStatement(sql);
		    preparedStatement.setObject(1, staff.getStaffName());
	        preparedStatement.setObject(2, staff.getSex());
	        preparedStatement.setObject(3, staff.getBirthday());
	        preparedStatement.setObject(4, staff.getNation());
	        preparedStatement.setObject(5, staff.getIdCard());
	        preparedStatement.setObject(6, staff.getDomicile());
//	        preparedStatement.setObject(7, staff.getApartmentId());
//	        preparedStatement.setObject(8, staff.getFiletypeId());
	        preparedStatement.setObject(7, staff.getApartmentName());
	        preparedStatement.setObject(8, staff.getFileType());
	        preparedStatement.setObject(9, staff.getId());
	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();
			   return count;

		}
	
	  public StaffVo getStaffoneid(int id) throws SQLException{

	        if(id<0)
	            throw new SQLException("Êý¾ÝÊäÈë´íÎó£¡£¡£¡£¡");
		  Connection connection=DButil.getConnection();
		  
		  String sql="select a.id,a.staff_name,a.sex,a.birthday,a.nation,a.id_card,a.domicile,b.apartment_name, c.file_type from staff a,apartment b,filetype c where a.apartment_id=b.id and a.filetype_id=c.id  and a.id=?";
		   preparedStatement=connection.prepareStatement(sql);
	       preparedStatement.setObject(1, id);
		   
	       resultSet=preparedStatement.executeQuery();
	      StaffVo staff=new StaffVo();
	      while(resultSet.next()){
	    	  staff.setId(resultSet.getInt("id"));
			  staff.setStaffName(resultSet.getString("staff_name"));
			  staff.setSex(resultSet.getBoolean("sex"));
			  staff.setBirthday(resultSet.getDate("birthday"));
			  staff.setNation(resultSet.getString("nation"));
			  staff.setIdCard(resultSet.getString("id_card"));
			  staff.setDomicile(resultSet.getString("domicile"));
			  staff.setApartmentName(resultSet.getString("apartment_name"));
			  staff.setFileType(resultSet.getString("file_type"));
	    	  
	      }
	      
		return staff;  
	  }
	
	public int dropStaff(int id) throws SQLException{
		Connection connection=DButil.getConnection();
		String sql="delete from staff where id=?";
		preparedStatement=connection.prepareStatement(sql);
		   preparedStatement.setObject(1, id);
		   int count=preparedStatement.executeUpdate();
		   DButil.closeConnection();
		   return count;
		
	}
	
	public List<StaffVo> getStaffbyid(String staffName) throws SQLException{
		 List<StaffVo> lists=new ArrayList<StaffVo>();
		  
		  Connection con= DButil.getConnection();
		  

		  preparedStatement=con.prepareStatement("select a.id,a.staff_name,a.sex,a.birthday,a.nation,a.id_card,a.domicile,b.apartment_name, c.file_type from staff a,apartment b,filetype c where a.apartment_id=b.id and a.filetype_id=c.id  and a.staff_name='"+staffName+"'");

	        resultSet=preparedStatement.executeQuery();
	        while(resultSet.next()){
				  StaffVo staff=new StaffVo();
				  staff.setId(resultSet.getInt("id"));
				  staff.setStaffName(resultSet.getString("staff_name"));
				  staff.setSex(resultSet.getBoolean("sex"));
				  staff.setBirthday(resultSet.getDate("birthday"));
				  staff.setNation(resultSet.getString("nation"));
				  staff.setIdCard(resultSet.getString("id_card"));
				  staff.setDomicile(resultSet.getString("domicile"));
//				  staff.setApartmentId(resultSet.getInt("apartment_id"));
//				  staff.setFiletypeId(resultSet.getInt("filetype_id"));
				  staff.setApartmentName(resultSet.getString("apartment_name"));
				  staff.setFileType(resultSet.getString("file_type"));
				     lists.add(staff);
				  
			  }
	        DButil.closeConnection();

	        return lists;
		  
		 
	}
	
	 public int getTotalPage() throws SQLException{
		 Connection con= DButil.getConnection();
		 String sql="select count(1) from staff";
		 preparedStatement=con.prepareStatement(sql);
	        resultSet=preparedStatement.executeQuery();
	        int total=0;
	        while(resultSet.next()){
	            total=resultSet.getInt(1);
	        }
	        int page=0;
	        if (total % Constrant.PAGE_NUMBER==0){
	            page=total / Constrant.PAGE_NUMBER;
	        }else
	            page=total / Constrant.PAGE_NUMBER+1;
	        DButil.closeConnection();
	        return page;
	 }
	 public List<StaffVo> getPageStaff(int page, int number) throws SQLException{
		 List<StaffVo> lists=new ArrayList<StaffVo>();
		  
		  Connection con= DButil.getConnection();
		  String sql="select a.id,a.staff_name,a.sex,a.birthday,a.nation,a.id_card,a.domicile,b.apartment_name, c.file_type from staff a,apartment b,filetype c where a.apartment_id=b.id and a.filetype_id=c.id  limit ?,?";
		  preparedStatement=con.prepareStatement(sql);
	        preparedStatement.setObject(1,(page-1)*number);
	        preparedStatement.setObject(2,number);
	        resultSet=preparedStatement.executeQuery();
	        while(resultSet.next()){
				  StaffVo staff=new StaffVo();
				  staff.setId(resultSet.getInt("id"));
				  staff.setStaffName(resultSet.getString("staff_name"));
				  staff.setSex(resultSet.getBoolean("sex"));
				  staff.setBirthday(resultSet.getDate("birthday"));
				  staff.setNation(resultSet.getString("nation"));
				  staff.setIdCard(resultSet.getString("id_card"));
				  staff.setDomicile(resultSet.getString("domicile"));
//				  staff.setApartmentId(resultSet.getInt("apartment_id"));
//				  staff.setFiletypeId(resultSet.getInt("filetype_id"));
				  staff.setApartmentName(resultSet.getString("apartment_name"));
				  staff.setFileType(resultSet.getString("file_type"));
				     lists.add(staff);
				  
			  }
	        DButil.closeConnection();

	        return lists;
	 }
	 public List<StaffVo> getAllStaffVo() throws SQLException {
		  List<StaffVo> lists=new ArrayList<StaffVo>();
		  
		  Connection con= DButil.getConnection();
		 
		  preparedStatement=con.prepareStatement("select a.id,a.staff_name,a.sex,a.birthday,a.nation,a.id_card,a.domicile,b.apartment_name, c.file_type from staff a,apartment b,filetype c  where a.apartment_id=b.id and a.filetype_id=c.id");
		  resultSet=preparedStatement.executeQuery();
		 
		  while(resultSet.next()){
			  StaffVo staffVo=new StaffVo();
			  staffVo.setId(resultSet.getInt("id"));
			  staffVo.setStaffName(resultSet.getString("staff_name"));
			  staffVo.setSex(resultSet.getBoolean("sex"));
			  staffVo.setBirthday(resultSet.getDate("birthday"));
			  staffVo.setNation(resultSet.getString("nation"));
			  staffVo.setIdCard(resultSet.getString("id_card"));
			  staffVo.setDomicile(resultSet.getString("domicile"));
			  staffVo.setApartmentName(resultSet.getString("apartment_name"));
			  staffVo.setFileType(resultSet.getString("file_type"));
			     lists.add(staffVo);
			  
		  }
		   DButil.closeConnection();

	        return lists;
	}

	
	
	

}
