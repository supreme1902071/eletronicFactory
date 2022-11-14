package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Keeper;

public interface KeeperService {
	public List<Keeper> getAllKeeper() throws SQLException;
}
