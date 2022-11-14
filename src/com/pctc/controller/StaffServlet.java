package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.pctc.service.ApartmentService;
import com.pctc.service.ApartmentServiceImpl;
import com.pctc.service.FileTypeService;
import com.pctc.service.FileTypeServiceImpl;
import com.pctc.service.StaffService;
import com.pctc.service.StaffServiceImp;
import com.pctc.cons.Constrant;
import com.pctc.dao.ApartmentDao;
import com.pctc.dao.ApartmentDaoImpl;
import com.pctc.dao.FileTypeDao;
import com.pctc.dao.FileTypeDaoImpl;
import com.pctc.dao.StaffDao;
import com.pctc.dao.StaffDaoImp;
import com.pctc.model.Apartment;
import com.pctc.model.FileType;
import com.pctc.model.Staff;
import com.pctc.util.DateUtil2;
import com.pctc.util.MD5Util;
import com.pctc.vo.FilesVo;
import com.pctc.vo.StaffVo;

/**
 * Servlet implementation class Staff
 */

public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  StaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
	
		String flag=request.getParameter("flag");
		StaffDao staffDao=new StaffDaoImp();
	StaffService staffService=new StaffServiceImp(staffDao);
		
	ApartmentDao apartmentDao=new ApartmentDaoImpl();
	ApartmentService apartmentService=new ApartmentServiceImpl(apartmentDao);
	FileTypeDao fileTypeDao = new FileTypeDaoImpl();
	FileTypeService fileTypeService = new FileTypeServiceImpl(fileTypeDao);
		
	
		if("1".equals(flag)){
			List<Staff>staffs=null;
			try{
				staffs=staffDao.getAllStaff();
				request.setAttribute("staffs", staffs);
				request.getRequestDispatcher("stafflt.jsp").forward(request, response);
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("2".equals(flag)){
			
			String staffName=request.getParameter("staffName");
			String issexString=request.getParameter("sex");
			Boolean sex=false;
				
					if("ÄÐ".equals(issexString)){
						sex=true;
					
				    }else {
				    	sex=false;
					}
			Date birthday=DateUtil2.string2Date(request.getParameter("birthday"));
			String nation=request.getParameter("nation");
			String idCard=request.getParameter("idCard");
	        String domicile=request.getParameter("domicile");
//	        Integer apartmentId=Integer.parseInt(request.getParameter("apartmentId"));
//	        Integer filetypeId=Integer.parseInt(request.getParameter("filetypeId"));
	        String  apartmentName=request.getParameter("apartmentName");
	        String  fileType=request.getParameter("fileType");
			StaffVo staff=new StaffVo(null,staffName,sex,birthday,nation,idCard,domicile,apartmentName,fileType);
		
			
			
			try {
				idCard=MD5Util.encryptMD5(idCard);
				staff.setIdCard(idCard);
				int count=staffDao.addStaff(staff);
				
				response.sendRedirect("StaffServlet?flag=8");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("3".equals(flag)){
		Integer id=Integer.parseInt(request.getParameter("id"));
		String staffName=request.getParameter("staffName");
		String issexString=request.getParameter("sex");
			Boolean sex=null;
			   if ("ÄÐ".equals(issexString)){
			    	 sex=true;
			     }else {
			    	 sex=false;
				}
			Date birthday=DateUtil2.string2Date(request.getParameter("birthday"));
			
			String nation=request.getParameter("nation");
		String idCard=request.getParameter("idCard");
	        String domicile=request.getParameter("domicile");
	        String  apartmentName=request.getParameter("apartmentName");
	        String  fileType=request.getParameter("fileType");
			StaffVo staff=new StaffVo(id,staffName,sex,birthday,nation,idCard,domicile,apartmentName,fileType);
		try {
			idCard=MD5Util.encryptMD5(idCard);
			staff.setIdCard(idCard);
			staffDao.editStaff(staff);
			
			response.sendRedirect("StaffServlet?flag=8");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if("4".equals(flag)){
		    Integer id=Integer.parseInt(request.getParameter("id"));
		
	    
	        try {
				int count=staffDao.dropStaff(id);
				response.sendRedirect("StaffServlet?flag=8");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("5".equals(flag)){
	          String staffName=request.getParameter("staffName");
			try {
				List<StaffVo>staffs=staffDao.getStaffbyid(staffName);
		
				request.setAttribute("staffs", staffs);
				request.getRequestDispatcher("stafflt.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}else if("6".equals(flag)){
			int page=  Integer.parseInt(request.getParameter("page"));
			try {
				int totalPage=staffService.getTotalPage();
				
				if (page>=totalPage)
	    			  page=totalPage;
	    		   
	    		if (page<=0)
	    			   page=1;
	    		   
	    		request.setAttribute("totalPage", totalPage);
	    		List<StaffVo> staffs=staffService.getPageStaff(page, Constrant.PAGE_NUMBER);
		    		   
		    		   
		    	 request.setAttribute("staffs",staffs);
		    	 request.setAttribute("page", page);
		    		   
		    	 request.getRequestDispatcher("stafflt.jsp").forward(request,response);
				 	   
		    		   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			/*int page=  Integer.parseInt(request.getParameter("page"));
	      	   
	    	   try {
	    		   
	    		   int totalPage=filesDao.getTotalPage();
	    		   
	    		   if (page>=totalPage)
	    			   page=totalPage;
	    		   
	    		   if (page<=0)
	    			   page=1;
	    		   
	    		   request.setAttribute("totalPage",  totalPage);
	    		   List<FilesVo> files=filesDao.getPageFilesVo(page, Constrant.PAGE_NUMBER);
	   			request.setAttribute("filesVos", files);
	            request.setAttribute("page", page);
	   			request.getRequestDispatcher("listFiles.jsp").forward(request, response);
	   		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
		}else if("8".equals(flag)){
			
	       staffService=new StaffServiceImp(staffDao);
		
			try {
				
				
				List<StaffVo>staffs=staffService.getAllStaffVo();
				request.setAttribute("staffs", staffs);
				request.getRequestDispatcher("stafflt.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("7".equals(flag)){
			int id=Integer.parseInt(request.getParameter("id"));
			List<Apartment> apartments=new ArrayList<Apartment>();
			List<FileType> fileTypes=new ArrayList<FileType>();
 		   try {
 			  apartments=apartmentService.getAllApartment();
				fileTypes=fileTypeService.getAllFileType();
				
				
				request.setAttribute("apartments", apartments);
				request.setAttribute("fileTypes", fileTypes);
			StaffVo staff=staffDao.getStaffoneid(id);
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
					
		}else if("9".equals(flag)){
			List<Apartment> apartments=new ArrayList<Apartment>();
			List<FileType> fileTypes=new ArrayList<FileType>();
			
			try {
				apartments=apartmentService.getAllApartment();
				fileTypes=fileTypeService.getAllFileType();
				
				
				request.setAttribute("apartments", apartments);
				request.setAttribute("fileTypes", fileTypes);
				request.getRequestDispatcher("staffAdd.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
