package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pctc.cons.Constrant;
import com.pctc.dao.ApartmentDao;
import com.pctc.dao.ApartmentDaoImpl;
import com.pctc.dao.FileTypeDao;
import com.pctc.dao.FileTypeDaoImpl;
import com.pctc.dao.FilesDao;
import com.pctc.dao.FilesDaoImpl;
import com.pctc.dao.KeeperDao;
import com.pctc.dao.KeeperDaoImpl;
import com.pctc.dao.SecurityLevelDao;
import com.pctc.dao.SecurityLevelDaoImpl;
import com.pctc.model.Apartment;
import com.pctc.model.FileType;
import com.pctc.model.Files;
import com.pctc.model.Keeper;
import com.pctc.model.SecurityLevel;
import com.pctc.service.ApartmentService;
import com.pctc.service.ApartmentServiceImpl;
import com.pctc.service.FileTypeService;
import com.pctc.service.FileTypeServiceImpl;
import com.pctc.service.FilesService;
import com.pctc.service.FilesServiceImpl;
import com.pctc.service.KeeperService;
import com.pctc.service.KeeperServiceImpl;
import com.pctc.service.SecurityLevelService;
import com.pctc.service.SecurityLevelServiceImpl;
import com.pctc.util.DateUtil;
import com.pctc.vo.FilesVo;

/**
 * Servlet implementation class FilesAllServlet
 */
public class FilesAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilesAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		FilesDao filesDao = new FilesDaoImpl();
		FilesService filesService = new FilesServiceImpl(filesDao);
		ApartmentDao apartmentDao=new ApartmentDaoImpl();
		ApartmentService apartmentService=new ApartmentServiceImpl(apartmentDao);
		SecurityLevelDao securityLevelDao = new SecurityLevelDaoImpl();
		SecurityLevelService securityLevelService = new SecurityLevelServiceImpl(securityLevelDao);
		FileTypeDao fileTypeDao = new FileTypeDaoImpl();
		FileTypeService fileTypeService = new FileTypeServiceImpl(fileTypeDao);
		KeeperDao keeperDao= new KeeperDaoImpl();
		KeeperService keeperService = new KeeperServiceImpl(keeperDao);
		//查询所有档案表
		if("1".equals(flag)){
		List<FilesVo> filesVo = null;
	    try {
			filesVo = filesService.getAllFilesVo();
			request.setAttribute("filesVos",filesVo);
			request.getRequestDispatcher("listFiles.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    
	    //添加档案表
		}
	    else if("2".equals(flag)){
			 //从前端取得数据转化model中的数据类型
			 Integer year=Integer.parseInt(request.getParameter("year"));
		     String number=request.getParameter("number");
		     String fileName=request.getParameter("fileName");
		     String register=request.getParameter("register");
		     String position=request.getParameter("position");
		     String apartmentName=request.getParameter("apartmentName");
		     String filetypeName=request.getParameter("filetypeName");
		     String securitylevelName=request.getParameter("securitylevelName");
		     String keeperName=request.getParameter("keeperName");
		  
		     FilesVo filesVo=new FilesVo(null, year, number, fileName, register,position, apartmentName,filetypeName,securitylevelName,keeperName);
		     try {
		            int count=filesService.addFilesVo(filesVo);
		            System.out.println(count);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		     response.sendRedirect("FilesAllServlet?flag=8&page=1");
		     
			
		}//修改档案表
		else if("3".equals(flag)){
			Integer id=Integer.parseInt(request.getParameter("id"));
			 Integer year=Integer.parseInt(request.getParameter("year"));
		     String number=request.getParameter("number");
		     String fileName=request.getParameter("fileName");
		     String register=request.getParameter("register");
		     String position=request.getParameter("position");
		     String apartmentName=request.getParameter("apartmentName");
		     String filetypeName=request.getParameter("filetypeName");
		     String securitylevelName=request.getParameter("securitylevelName");
		     String keeperName=request.getParameter("keeperName");
		     
		     FilesVo filesVo=new FilesVo(id, year, number, fileName, register,position, apartmentName,filetypeName,securitylevelName,keeperName);
		     
		     try {
		    	 filesDao.editFilesVo(filesVo);
		    	 response.sendRedirect("FilesAllServlet?flag=8&page=1");
			
		     } catch (SQLException e) {
		    	 e.printStackTrace();
		     }
		
		
		}//删除档案表
		else if("4".equals(flag)){
			int id=new Integer(request.getParameter("id"));
			
			try {
				filesDao.dropFiles(id);
				response.sendRedirect("FilesAllServlet?flag=8&page=1");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}//显示档案表信息，用于修改
		else if("5".equals(flag)){
			Integer id=Integer.parseInt(request.getParameter("id"));
			List<Apartment> apartments=new ArrayList<Apartment>();
			List<FileType> fileTypes=new ArrayList<FileType>();
			List<SecurityLevel> securityLevels = new ArrayList<SecurityLevel>();
			List<Keeper> keepers = new ArrayList<Keeper>();
			try {
				apartments=apartmentService.getAllApartment();
				fileTypes=fileTypeService.getAllFileType();
				securityLevels=securityLevelService.getAllSecurityLevel();
				keepers=keeperService.getAllKeeper();
				request.setAttribute("apartments", apartments);
				request.setAttribute("fileTypes", fileTypes);
				request.setAttribute("securityLevels", securityLevels);
				request.setAttribute("keepers", keepers);
				
				FilesVo filesVo = filesService.getFilesVoId(id);
				request.setAttribute("filesVo", filesVo);
				request.getRequestDispatcher("FilesEdit.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
//			//档案表的条件查询,,根据档案类别查询
//			else if("6".equals(flag)){
//				Integer filetypeId=Integer.parseInt(request.getParameter("filetypeId"));
//			     try {
//			    	 List<Files> files = FilesDao.getFilesType(filetypeId);
//					request.setAttribute("files",files);
//					request.getRequestDispatcher("listFiles.jsp").forward(request, response);
//						
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//		
//			     
//			   //档案表的条件查询,,根据档案存放位置查询
//			}
		else if("7".equals(flag)){
				String position=request.getParameter("position");
			     try {
			    	 List<FilesVo> files = filesService.getFilesPositionVo(position);
					request.setAttribute("filesVos",files);
					request.getRequestDispatcher("listFiles.jsp").forward(request, response);
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
		
			     //分页
				}
	        else if("8".equals(flag)){
					 int page=  Integer.parseInt(request.getParameter("page"));
	    	      	   
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
					}
					
					}else if("9".equals(flag)){
				
				List<Apartment> apartments=new ArrayList<Apartment>();
				List<FileType> fileTypes=new ArrayList<FileType>();
				List<SecurityLevel> securityLevels = new ArrayList<SecurityLevel>();
				List<Keeper> keepers = new ArrayList<Keeper>();
				try {
					apartments=apartmentService.getAllApartment();
					fileTypes=fileTypeService.getAllFileType();
					securityLevels=securityLevelService.getAllSecurityLevel();
					keepers=keeperService.getAllKeeper();
					request.setAttribute("apartments", apartments);
					request.setAttribute("fileTypes", fileTypes);
					request.setAttribute("securityLevels", securityLevels);
					request.setAttribute("keepers", keepers);
					request.getRequestDispatcher("FilesAdd.jsp").forward(request, response);
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
