package com.pctc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pctc.dao.UserDao;
import com.pctc.dao.UserDaoImpl;
import com.pctc.model.User;
import com.pctc.service.UserService;
import com.pctc.service.UserServiceImpl;
import com.pctc.util.MD5Util;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");*/   //使用了过滤器
		
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		User user=null;
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String rand=request.getParameter("rand");

		System.out.println(username + password + rand);
		
		String MaxAge=request.getParameter("maxage");
		int loginage=0;
		if("一星期".equals(MaxAge)){
			loginage=604800;
		}else if("一个月".equals(MaxAge)){
			loginage=18144000;
		}
		
		try {
			  //String passwordMD5=MD5Util.encryptMD5(password);   //加密
			 user=userService.login(username, password);
			  HttpSession session=request.getSession();
			 String authCode=(String)session.getAttribute("authCode");
			  
			 if(user!=null  && authCode.equals(rand)){
				
				 session.setAttribute("user",user);


					Cookie cookieusername=new Cookie("username",username);
					Cookie cookiepassword=new Cookie("password",password);
					cookieusername.setMaxAge(loginage);
					cookiepassword.setMaxAge(loginage);
					response.addCookie(cookieusername);
					response.addCookie(cookiepassword);
					
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			 }else{
				 request.getRequestDispatcher("login.jsp").forward(request, response);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
