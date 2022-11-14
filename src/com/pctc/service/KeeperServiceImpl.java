package com.pctc.service;

import java.sql.SQLException;
import java.util.List;

import com.pctc.dao.KeeperDao;
import com.pctc.model.Keeper;

public class KeeperServiceImpl implements KeeperService {
	private KeeperDao keeperDao;
	public KeeperServiceImpl(KeeperDao keeperDao){
		this.keeperDao = keeperDao;
	}
	public List<Keeper> getAllKeeper() throws SQLException {
		// TODO Auto-generated method stub
		return keeperDao.getAllKeeper();
	}

}
