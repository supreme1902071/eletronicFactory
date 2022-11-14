package com.pctc.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pctc.dao.UserDao;
import com.pctc.dao.UserDaoImpl;
import com.pctc.model.User;
import com.pctc.service.UserService;
import com.pctc.service.UserServiceImpl;

/**
 * Servlet Filter implementation class GrantFilter
 */
public class GrantFilter implements Filter {

    /**
     * Default constructor. 
     */
    public GrantFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;

		
		
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl(userDao);
		HttpSession session=req.getSession();
		//判断是否有权限：
		User user=(User)session.getAttribute("user");
		
		try {
			List<String> lists=userService.getUrl(user.getId());
			
			System.out.println(req.getRequestURI());
			System.out.println(req.getContextPath());
			
			int pos=req.getRequestURI().indexOf(req.getContextPath()+"/")+req.getContextPath().length();				
			String urlReal=req.getRequestURI().substring(pos+1)+"?"+req.getQueryString();
		    
			String urlRealPage=urlReal.substring(0,urlReal.lastIndexOf("&page=")+6);
			System.out.println(req.getQueryString());
			System.out.println(pos);
			System.out.println(urlReal);
			System.out.println(urlRealPage);
			String urlRealId=urlReal.substring(0,urlReal.lastIndexOf("&id=")+4);
			String urlRealStaffName=urlReal.substring(0,urlReal.lastIndexOf("&staffName=")+11);
			String urlRealPosition=urlReal.substring(0,urlReal.lastIndexOf("&position=")+10);
			String urlRealapartmentName=urlReal.substring(0,urlReal.lastIndexOf("&apartmentName=")+15);
			System.out.println("urlRealId="+urlRealId);
			
			String urlRealName=req.getRequestURI().substring(pos+1);
			System.out.println(urlRealName);
			System.out.println(lists.contains(urlReal));
			
			if (lists.contains(urlReal)||lists.contains(urlRealPage)  || lists.contains(urlRealId)  || lists.contains(urlRealName)||lists.contains(urlRealStaffName)||lists.contains( urlRealPosition)||lists.contains(urlRealapartmentName)){
				chain.doFilter(req, resp);
				
			}else{
				//session.invalidate();   //session失效
				resp.sendRedirect("../login.jsp");		
			}			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
