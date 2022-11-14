package com.pctc.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pctc.model.Visit;

public interface VisitService {
	/**
	 * ��ȡ����
	 * @return
	 * @throws SQLException
	 */
	public List<Visit> getAllvisit() throws SQLException;
	
	/**
	 * ��ʱ���ѯ
	 * @param time
	 * @return
	 * @throws SQLException
	 */
	public List<Visit> getVisitByTime(Date time)throws SQLException;

	
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
