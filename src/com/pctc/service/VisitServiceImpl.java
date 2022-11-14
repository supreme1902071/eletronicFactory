package com.pctc.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pctc.dao.VisitDao;
import com.pctc.model.Visit;

public class VisitServiceImpl implements VisitService{
	private VisitDao visitDao;
	
	public VisitServiceImpl(VisitDao visitDao) {
		this.visitDao=visitDao;
	}
	
	

	public List<Visit> getAllvisit() throws SQLException {
		// TODO Auto-generated method stub
		return visitDao.getAllvisit();
	}

	public List<Visit> getVisitByTime(Date time) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int addVisit(Visit visit) throws SQLException {
		// TODO Auto-generated method stub
		return visitDao.addVisit(visit);
	}

	public int editVisit(Visit visit) throws SQLException {
		// TODO Auto-generated method stub
		return visitDao.editVisit(visit);
	}
}
