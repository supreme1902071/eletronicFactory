package com.pctc.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.pctc.service.StaffService;
import com.pctc.service.StaffServiceImp;
import com.pctc.dao.StaffDao;
import com.pctc.dao.StaffDaoImp;
import com.pctc.model.Staff;
import com.pctc.util.DateUtil;
import com.pctc.vo.StaffVo;

public class Test1 {
	
	private StaffDao staffDao=new StaffDaoImp();
	private StaffService staffService=new StaffServiceImp(staffDao);
	/*@Test
	public void testGetAll(){
		List<StaffVo> lists;
		try {
			lists = staffService.getAllStaffVo();
			System.out.println(lists);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
///@Test
//  public void testaddStaff(){
//	  String dateString=Dateutil.date2String(new Date());
//		Date date=Dateutil.string2Date(dateString);
//		
//		StaffVo staff=new StaffVo(null,"ff",false,date,"ww","ff","a","kl","dd");
//		
//		try {
//			staffService.addStaff(staff);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	  
//  }
//	@Test
//	  public void testdelectStaff(){
//		  String dateString=Dateutil.date2String(new Date());
//			Date date=Dateutil.string2Date(dateString);
//			
//			
//			
//			try {
//			
//				
//				StaffVo staffVo=new StaffVo(2,"ff",false,date,"ww","ff","a","kl","dd");
//				staffService.editStaff(staffVo);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		  
//	  }
//	
//	@Test
//	 public void testdelectStaff(){
//		try {
//			staffService.dropStaff(2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void testcheckbyid(){
//		List<Staff> lists;
//		try {
//			lists = staffService.getStaffbyid("ee");
//			System.out.println(lists);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		
//	}
//	
/*	@Test
	public void testgetPage(){
		List<StaffVo> lists;
		try {
			lists=staffService.getPageStaff(1, 1);
			System.out.println(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void total(){
		int lists;
		try {
			lists=staffService.getTotalPage();
			System.out.println(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	@Test
//	public void testcheckbyid(){
//
//		try {
//			StaffVo staffVo=new StaffVo();
//			staffVo= staffService.getStaffoneid(1);
//			System.out.println(staffVo);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		
//	}
	
}
