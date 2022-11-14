package com.pctc.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pctc.model.Visit;

public interface VisitDao {
	/**
	 * ��ȡ����
	 * @return
	 * @throws SQLException
	 */
	public List<Visit> getAllvisit() throws SQLException;
	
	
	/**
	 * ����
	 * @param visit
	 * @return
	 * @throws SQLException
	 */
	public int addVisit(Visit visit) throws SQLException;
	
	/**
	 * �޸�
	 * @param visit
	 * @return
	 * @throws SQLException
	 */
	public int editVisit(Visit visit) throws SQLException;
}
