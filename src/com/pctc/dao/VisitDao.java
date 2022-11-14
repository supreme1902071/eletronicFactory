package com.pctc.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pctc.model.Visit;

public interface VisitDao {
	/**
	 * 获取所有
	 * @return
	 * @throws SQLException
	 */
	public List<Visit> getAllvisit() throws SQLException;
	
	
	/**
	 * 增加
	 * @param visit
	 * @return
	 * @throws SQLException
	 */
	public int addVisit(Visit visit) throws SQLException;
	
	/**
	 * 修改
	 * @param visit
	 * @return
	 * @throws SQLException
	 */
	public int editVisit(Visit visit) throws SQLException;
}
