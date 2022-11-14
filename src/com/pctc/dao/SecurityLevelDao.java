package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.SecurityLevel;


public interface SecurityLevelDao {
	public List<SecurityLevel> getAllSecurityLevel() throws SQLException;
}
