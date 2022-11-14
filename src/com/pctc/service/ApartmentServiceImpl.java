package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.ApartmentDao;
import com.pctc.model.Apartment;

public class ApartmentServiceImpl implements ApartmentService{
	
	private ApartmentDao apartmentDao;
	public ApartmentServiceImpl(ApartmentDao apartmentDao){
		this.apartmentDao=apartmentDao;
	}
	public List<Apartment> getAllApartment() throws SQLException {
		// TODO Auto-generated method stub
		return apartmentDao.getAllApartment();
	}
	public int addApartment(Apartment apartment) throws SQLException {
		// TODO Auto-generated method stub
		return apartmentDao.addApartment(apartment);
	}
	public int editApartment(Apartment apartment) throws SQLException {
		// TODO Auto-generated method stub
		return apartmentDao.editApartment(apartment);
	}
	public Apartment getOneApartment(int id) throws SQLException {
		// TODO Auto-generated method stub
		return apartmentDao.getOneApartment(id);
	}
	public int dropApartment(int id) throws SQLException {
		// TODO Auto-generated method stub
		return apartmentDao.dropApartment(id);
	}
	
	
	
	

}
