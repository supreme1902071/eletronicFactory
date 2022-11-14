package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pctc.dao.VisitDao;
import com.pctc.dao.VisitDaoImpl;
import com.pctc.model.Visit;
import com.pctc.service.VisitService;
import com.pctc.service.VisitServiceImpl;

/**
 * Servlet implementation class VisitServlet
 */
public class VisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		
		VisitDao visitDao=new VisitDaoImpl();
		VisitService visitService=new VisitServiceImpl(visitDao);
		
		if("1".equals(flag)){
			List<Visit> list=new ArrayList<Visit>();
			try {
				list=visitService.getAllvisit();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("VisitList.jsp").forward(request, response);
				
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
