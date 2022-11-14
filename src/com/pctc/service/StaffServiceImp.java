package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.StaffDao;

import com.pctc.model.Staff;
import com.pctc.vo.StaffVo;

public class StaffServiceImp implements StaffService {
	private StaffDao staffDao;
	public StaffServiceImp(StaffDao staffDao){
		this.staffDao=staffDao;
	}

	
	public List<Staff> getAllStaff() throws SQLException {
		return staffDao.getAllStaff(); 
		
	}

	
	public int addStaff(StaffVo staff) throws SQLException {
		// TODO Auto-generated method stub
		
		if(staff==null)
			throw new RuntimeException("数据不能为空");
	
		return staffDao.addStaff(staff);
	}

	
	public int editStaff(StaffVo staff) throws SQLException {
		// TODO Auto-generated method stub
		if(staff==null)
			throw new RuntimeException("数据不能为空");
		int count=staffDao.editStaff(staff);
		return count;
	}

	 public int dropStaff(int id) throws SQLException{
		 return staffDao.dropStaff(id);
	 }
	 
	   public List<StaffVo> getStaffbyid(String staffName) throws SQLException{
		   return staffDao.getStaffbyid(staffName);
	   }
	    public StaffVo getStaffoneid(int id) throws SQLException{
	    	return staffDao.getStaffoneid(id);
	    }

	   
	   public int getTotalPage() throws SQLException{
		   return staffDao.getTotalPage();
	   }
	   public List<StaffVo> getPageStaff(int page, int number) throws SQLException{
		   return staffDao.getPageStaff(page, number);
	   }
	   
	   public List<StaffVo> getAllStaffVo() throws SQLException{
		   return staffDao.getAllStaffVo();
	   }
}
