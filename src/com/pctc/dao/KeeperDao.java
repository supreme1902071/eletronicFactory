package com.pctc.dao;

import java.sql.SQLException;
import java.util.List;

import com.pctc.model.Keeper;


public interface KeeperDao {
	public List<Keeper> getAllKeeper() throws SQLException;
}
