package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pctc.dao.ApartmentDao;
import com.pctc.dao.ApartmentDaoImpl;
import com.pctc.model.Apartment;
import com.pctc.service.ApartmentService;
import com.pctc.service.ApartmentServiceImpl;

/**
 * Servlet implementation class ApartmentServlet
 */
public class ApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		ApartmentDao apartmentDao=new ApartmentDaoImpl();
		ApartmentService apartmentService=new ApartmentServiceImpl(apartmentDao);
		
		if("1".equals(flag)){  //查询所有
			List<Apartment> list=new ArrayList<Apartment>();
			try {
				list=apartmentService.getAllApartment();
				request.setAttribute("list", list);
				request.getRequestDispatcher("ApartmentList.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("2".equals(flag)){   //增加
			
			String apartmentName=request.getParameter("apartmentName");
			Apartment apartment=new Apartment(0,apartmentName);
			try {
				apartmentService.addApartment(apartment);
				request.getRequestDispatcher("ApartmentServlet?flag=1").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if("3".equals(flag)){  //修改
			Integer id= new Integer(request.getParameter("id"));
			
		    String apartmentName=request.getParameter("apartmentName");
		    
		    
		    Apartment apartment=new Apartment(id,apartmentName);
		    
		    try {
		       int count=apartmentService.editApartment(apartment);
		       System.out.println(count);
		       request.getRequestDispatcher("ApartmentServlet?flag=1").forward(request, response);
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}else if("4".equals(flag)){   //显示当前
		
			int id=Integer.parseInt(request.getParameter("id"));
			Apartment apartment=null;
			try {
				apartment = apartmentService.getOneApartment(id);
				request.setAttribute("apartment", apartment);
				request.getRequestDispatcher("ApartmentEdit.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if("5".equals(flag)){
			
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				int count=apartmentService.dropApartment(id);
				request.getRequestDispatcher("ApartmentServlet?flag=1").forward(request, response);
				
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
