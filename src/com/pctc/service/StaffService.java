package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Staff;
import com.pctc.vo.StaffVo;

public interface StaffService {
	    public List<Staff> getAllStaff() throws SQLException;


	    public int addStaff(StaffVo staff) throws SQLException;

	    
	    public int editStaff(StaffVo staff) throws SQLException;
	    
	    public int dropStaff(int id) throws SQLException; 
	    
	    public List<StaffVo> getStaffbyid(String staffName) throws SQLException;
	    
	    public StaffVo getStaffoneid(int id) throws SQLException;

	    public int getTotalPage() throws SQLException;
	    
	    public List<StaffVo> getPageStaff(int page, int number) throws SQLException;
        
	    public List<StaffVo> getAllStaffVo() throws SQLException;
}
