package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Apartment;

public interface ApartmentService {
	/**
	 * ��ȡ����
	 * @return
	 * @throws SQLException
	 */
	public List<Apartment> getAllApartment() throws SQLException;
	
	/**
	 * ����
	 * @param apartment
	 * @return
	 * @throws SQLException
	 */
	public int addApartment(Apartment apartment) throws SQLException;
	
	/**
	 * �޸�
	 * @param apartment
	 * @return
	 * @throws SQLException
	 */
	public int editApartment(Apartment apartment)throws SQLException;
	
	/**
	 * ��ȡ��ǰ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Apartment getOneApartment(int id) throws SQLException;
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int dropApartment(int id)throws SQLException;
}
