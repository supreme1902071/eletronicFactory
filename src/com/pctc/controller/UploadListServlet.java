package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pctc.dao.UploadDao;
import com.pctc.dao.UploadDaoImpl;
import com.pctc.model.Upload;
import com.pctc.service.UploadService;
import com.pctc.service.UploadServiceImpl;

/**
 * Servlet implementation class UploadListServlet
 */
public class UploadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		UploadDao uploadDao=new UploadDaoImpl();
		UploadService uploadService=new UploadServiceImpl(uploadDao);
			
		if("1".equals(flag)){
			try {
				List<Upload> list = uploadService.GetAllUpload();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("FileuploadList.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("2".equals(flag)){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				int count=uploadService.dropUpload(id);
				request.getRequestDispatcher("UploadListServlet?flag=1").forward(request, response);
				
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
