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
import com.pctc.dao.LendDao;
import com.pctc.dao.LendDaoImpl;
import com.pctc.dao.UserDao;
import com.pctc.dao.UserDaoImpl;
import com.pctc.model.Apartment;
import com.pctc.model.Lend;
import com.pctc.model.User;
import com.pctc.service.ApartmentService;
import com.pctc.service.ApartmentServiceImpl;
import com.pctc.service.LendService;
import com.pctc.service.LendServiceImpl;
import com.pctc.service.UserService;
import com.pctc.service.UserServiceImpl;
import com.pctc.util.DateUtil;
import com.pctc.vo.LendVo;

/**
 * Servlet implementation class LendServlet
 */
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LendServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//使用了过滤器
		String flag = request.getParameter("flag");
		LendDao lendDao=new LendDaoImpl();
	    LendService lendService=new LendServiceImpl(lendDao);
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		
		ApartmentDao apartmentDao=new ApartmentDaoImpl();
		ApartmentService apartmentService=new ApartmentServiceImpl(apartmentDao);
		
		//1-查询所有借阅人，2-添加，3-修改，4-删除，5-显示当前借阅对象，6-条件查询，7-分页	
		if ("1".equals(flag)) {
			List<LendVo> lendVos=null;
			
			try{
				lendVos=lendService.getAllLendVo();
				// 把控制器中的数据，传输到jsp页面
				request.setAttribute("lendVos", lendVos);
				

				request.getRequestDispatcher("listLend.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("2".equals(flag)) {
			
			 //从前端取得数据转化model中的数据类型
			 String number=request.getParameter("number");
		     Integer year=Integer.parseInt(request.getParameter("year"));
		     String fileName=request.getParameter("fileName");
		     
		     String dateString=DateUtil.date2String(new Date());
		     Date lendTime=DateUtil.string2Date(dateString);
		     String flagString=request.getParameter("flag");
		     Boolean flags=false;
		     if ("是".equals(flagString)){
		    	 flags=true;
		     }else {
		    	 flags=false;
			}
		     String apartmentName=request.getParameter("apartmentName");
		     String lender=request.getParameter("lender");
		     //其实这个下面的代码就测试test中的代码
		     //构建学生对象;
		    LendVo lendVo=new LendVo(null, number, year, fileName, lendTime,null,flags,apartmentName,lender);
		     try {
		            int count=lendService.addLendVo(lendVo);
		            response.sendRedirect("LendServlet?flag=7&page=1");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		}else if ("3".equals(flag)) {
			Integer id  = Integer.parseInt(request.getParameter("id"));
			 //从前端取得数据转化model中的数据类型
			 String number=request.getParameter("number");
		     Integer year=Integer.parseInt(request.getParameter("year"));
		     String fileName=request.getParameter("fileName");
		    // Date lendTime = DateUtil.string2Date(request.getParameter("lendTime"));
		     String dateString=DateUtil.date2String(new Date());
			 Date returnTime=DateUtil.string2Date(dateString);
			      
		     String flagString=request.getParameter("flag1");
		     Boolean flags=false;
		     if ("是".equals(flagString)){
		    	 flags=true;
		         
			     
		     }else {
		    	 flags=false;
		    	 returnTime=null;
			}
		     String apartmentName=request.getParameter("apartmentName");
		     String lender=request.getParameter("lender");

		     //其实这个下面的代码就测试test中的代码
		     //构建学生对象;
		    LendVo lendVo=new LendVo(id, number, year, fileName,null, returnTime,flags,apartmentName,lender);
		    try {
		    	lendService.editLendVo(lendVo);
				
				response.sendRedirect("LendServlet?flag=7&page=1");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		else if ("4".equals(flag)) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			 
		    try {
		    	lendService.dropLendVo(id);
				
				response.sendRedirect("LendServlet?flag=7&page=1");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		else if ("5".equals(flag)) {
			Integer id=Integer.parseInt(request.getParameter("id"));
			List<Apartment> apartments=new ArrayList<Apartment>();
		    try {
		    	apartments=apartmentService.getAllApartment();
				request.setAttribute("apartments", apartments);
		    	LendVo lendVo=lendService.getLendVo(id);
		    	request.setAttribute("lendVo", lendVo);
				request.getRequestDispatcher("lendEdit.jsp").forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		else if ("6".equals(flag)) {
			Integer year=Integer.parseInt(request.getParameter("year"));
			 String apartmentName=request.getParameter("apartmentName");
		    try {
		    	List<LendVo> lendVos=lendService.getAllLendIdYearVo(apartmentName, year);
				request.setAttribute("lendVos", lendVos);
				request.getRequestDispatcher("listLend.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		else if ("7".equals(flag)) {
			List<Apartment> apartments=null;
	    	      
	    	   int page=Integer.parseInt(request.getParameter("page"));
	    	      	   
	    	   try {
	    		   
	    		   int totalPage=lendService.getTotalPage();
	    		   
	    		   if (page>=totalPage)
	    			   page=totalPage;
	    		   
	    		   if (page<=0)
	    			   page=1;
	    		   apartments=apartmentService.getAllApartment();
					request.setAttribute("apartments", apartments);
	    		   request.setAttribute("totalPage",  totalPage);
	    		   List<LendVo> lendVos=lendService.getAllPageLendVo(page, Constrant.PAGE_NUMBER);
	    		
	    		   // 把控制器中的数据，传输到jsp页面
	   			request.setAttribute("lendVos", lendVos);
	            request.setAttribute("page", page);
	   			request.getRequestDispatcher("listLend.jsp").forward(request, response);
	   		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("8".equals(flag)){
			
			List<Apartment> apartments=new ArrayList<Apartment>();
			try {
				apartments=apartmentService.getAllApartment();
				request.setAttribute("apartments", apartments);
				request.getRequestDispatcher("lendAdd.jsp").forward(request, response);
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
