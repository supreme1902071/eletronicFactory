package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pctc.model.Visit;
import com.pctc.util.DButil;

public class VisitDaoImpl implements VisitDao {
	
	PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

	
	public List<Visit> getAllvisit() throws SQLException {
		
		List<Visit> list=new ArrayList<Visit>();
		
		Connection con=DButil.getConnection();
		String sql="select * from visit";
		preparedStatement=con.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			
			Visit visit=new Visit();
			visit.setId(resultSet.getInt("id"));
			visit.setIp(resultSet.getString("ip"));
			
			visit.setUserName(resultSet.getString("user_name"));
			visit.setVisitTime(resultSet.getTimestamp("visit_time"));
			visit.setVisitServlet(resultSet.getString("visit_servlet"));
			visit.setParameter(resultSet.getString("parameter"));
			
			list.add(visit);
			
		}
		return list;
	}

	
	
	public List<Visit> getVisitByTime(Date visitTime) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*private int id;
	private String ip;
	private String userName;
	private Date visitTime;
	private String visitServlet;
	private String parameter;
	*/
	public int addVisit(Visit visit) throws SQLException {
		 Connection con=DButil.getConnection();
	        String sql="insert into visit(ip,user_name,visit_time,visit_servlet,parameter) values (?,?,?,?,?) ";
	        preparedStatement=con.prepareStatement(sql);

	        preparedStatement.setObject(1,visit.getIp());
	        preparedStatement.setObject(2,visit.getUserName());
	        preparedStatement.setObject(3,visit.getVisitTime());
	       
	        preparedStatement.setObject(4,visit.getVisitServlet());
	        preparedStatement.setObject(5,visit.getParameter());
	       

	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
	}

	public int editVisit(Visit visit) throws SQLException {
		 Connection con=DButil.getConnection();
	        String sql="update visit set ip=?,user_name=?,visit_time=?,visit_servlet=?,parameter=? where id=?";
	        preparedStatement=con.prepareStatement(sql);

	        preparedStatement.setObject(1,visit.getIp());
	       
	        preparedStatement.setObject(2,visit.getUserName());
	        preparedStatement.setObject(3,visit.getVisitTime());
	        preparedStatement.setObject(4,visit.getVisitServlet());
	        preparedStatement.setObject(5,visit.getParameter());
	        preparedStatement.setObject(6,visit.getId());
	       

	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
	}

}
