package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Apartment;

public interface ApartmentService {
	/**
	 * 获取所有
	 * @return
	 * @throws SQLException
	 */
	public List<Apartment> getAllApartment() throws SQLException;
	
	/**
	 * 增加
	 * @param apartment
	 * @return
	 * @throws SQLException
	 */
	public int addApartment(Apartment apartment) throws SQLException;
	
	/**
	 * 修改
	 * @param apartment
	 * @return
	 * @throws SQLException
	 */
	public int editApartment(Apartment apartment)throws SQLException;
	
	/**
	 * 获取当前
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Apartment getOneApartment(int id) throws SQLException;
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int dropApartment(int id)throws SQLException;
}
