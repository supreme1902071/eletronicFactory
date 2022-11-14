package com.pctc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pctc.model.Apartment;
import com.pctc.util.DButil;

public class ApartmentDaoImpl implements ApartmentDao {
	
	PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

	public List<Apartment> getAllApartment() throws SQLException {
		
		List<Apartment> list=new ArrayList<Apartment>();
		
		Connection con=DButil.getConnection();
		String sql="SELECT * FROM apartment";
		preparedStatement=con.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			Apartment apartment=new Apartment();
			apartment.setId(resultSet.getInt("id"));
			apartment.setApartmentName(resultSet.getString("apartment_name"));
			list.add(apartment);
		}
		return list;
	}

	public int addApartment(Apartment apartment) throws SQLException {
		 Connection con=DButil.getConnection();
	        String sql="insert into apartment(apartment_name) values(?) ";
	        preparedStatement=con.prepareStatement(sql);

	        preparedStatement.setObject(1,apartment.getApartmentName());
	       

	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
	}

	public int editApartment(Apartment apartment) throws SQLException {
		    Connection con=DButil.getConnection();
	        String sql="update apartment set apartment_name=? where id=?";
	        preparedStatement=con.prepareStatement(sql);

	        preparedStatement.setObject(1,apartment.getApartmentName());
	       
	        preparedStatement.setObject(2,apartment.getId());

	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
	}

	public Apartment getOneApartment(int id) throws SQLException {
		Connection con=DButil.getConnection();
		String sql="SELECT * FROM apartment where id=?";
		preparedStatement=con.prepareStatement(sql);
		preparedStatement.setObject(1,id);
		
		resultSet=preparedStatement.executeQuery();
		Apartment apartment=new Apartment();
		while(resultSet.next()){
			
			apartment.setId(resultSet.getInt("id"));
			apartment.setApartmentName(resultSet.getString("apartment_name"));
		}
		return apartment;
	}

	public int dropApartment(int id) throws SQLException {
		 Connection con=DButil.getConnection();
	        String sql="delete from apartment where id=? ";
	        preparedStatement=con.prepareStatement(sql);
	        preparedStatement.setObject(1,id);
	        int count=preparedStatement.executeUpdate();
	        DButil.closeConnection();

	        return count;
	}

}
