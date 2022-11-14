package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.SecurityLevelDao;
import com.pctc.model.SecurityLevel;

public class SecurityLevelServiceImpl implements SecurityLevelService {
	private SecurityLevelDao securityLevelDao;
	public SecurityLevelServiceImpl(SecurityLevelDao securityLevelDao){
		this.securityLevelDao =securityLevelDao;
	}
	public List<SecurityLevel> getAllSecurityLevel() throws SQLException {
		// TODO Auto-generated method stub
		return securityLevelDao.getAllSecurityLevel();
	}

}
