package com.pctc.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pctc.dao.VisitDao;
import com.pctc.dao.VisitDaoImpl;
import com.pctc.model.User;
import com.pctc.model.Visit;
import com.pctc.service.VisitService;
import com.pctc.service.VisitServiceImpl;
import com.pctc.util.DateUtil;

/**
 * Servlet Filter implementation class VisitFilter
 */
public class VisitFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VisitFilter() {
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
		
		HttpSession session=req.getSession();
			
		VisitDao visitDao=new VisitDaoImpl();
		VisitService visitService=new VisitServiceImpl(visitDao);
		
		
		String ip=req.getRemoteAddr();
		/*System.out.println(req.getLocalAddr());
		System.out.println(req.getLocalName());
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());*/
		
		String dateString=DateUtil.date2String(new Date());
		Date visitTime=DateUtil.string2Date(dateString);
		//System.out.println(visitTime);
		
		User user=(User)session.getAttribute("user");
		String userName=user.getUserName();
		System.out.println(userName);
		
		String visitServlet=req.getServletPath().substring(9);
		System.out.println(visitServlet);
		
		//String param=req.getServletContext().getInitParameter("contextParam");
		String parameter=null;
		parameter=req.getQueryString();
		
			
		System.out.println(parameter);
		
		Visit visit=new Visit(0,ip,userName,visitTime,visitServlet,parameter);
		
		try {
			visitService.addVisit(visit);
			//request.getRequestDispatcher("VisitServlet?flag=1").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
