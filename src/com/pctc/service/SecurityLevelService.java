package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.SecurityLevel;

public interface SecurityLevelService {
	public List<SecurityLevel> getAllSecurityLevel() throws SQLException;
}
