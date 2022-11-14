package com.pctc.service;

import com.pctc.dao.LendDao;
import com.pctc.model.Lend;
import com.pctc.vo.LendVo;

import java.sql.SQLException;
import java.util.List;

public class LendServiceImpl implements LendService {

    private LendDao lendDao;

    public LendServiceImpl(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    public List<Lend> getAllLend() throws SQLException {
        return lendDao.getAllLend();
    }

    public int addLend(Lend lend) throws SQLException {
        if(lend==null)
            throw new SQLException("����������󣡣�����");
        return lendDao.addLend(lend);
    }

    public int editLend(Lend lend) throws SQLException {
        if(lend==null)
            throw new SQLException("����������󣡣�����");
        return lendDao.editLend(lend);
    }

    public int dropLend(Integer id) throws SQLException {
        if(id<=0)
            throw new SQLException("����������󣡣�����");
        return lendDao.dropLend(id);
    }

    public List<Lend> getAllLendIdYear(Integer apartmentId, Integer year) throws SQLException {
        if (apartmentId<0)
            throw new SQLException("���ݲ��ԣ�������");
        if (year<=0)
            throw new SQLException("���ݲ��ԣ�������");
        return lendDao.getAllPageLend(apartmentId,year);
    }

    public List<Lend> getAllPageLend(int page, int num) throws SQLException {
        if (page<0)
            throw new SQLException("���ݲ��ԣ�������");
        if (num<=0)
            throw new SQLException("���ݲ��ԣ�������");
        return lendDao.getAllPageLend(page,num);
    }

    public int getTotalPage() throws SQLException {
        return lendDao.getTotalPage();
    }

    public List<LendVo> getAllLendVo() throws SQLException {
        return lendDao.getAllLendVo();
    }

    public int addLendVo(LendVo lend) throws SQLException {
        return lendDao.addLendVo(lend);
    }

    public int editLendVo(LendVo lend) throws SQLException {
        return lendDao.editLendVo(lend);
    }

    public int dropLendVo(Integer id) throws SQLException {
        return lendDao.dropLendVo(id);
    }

    public List<LendVo> getAllLendIdYearVo(String apartmentName, Integer year) throws SQLException {
        return lendDao.getAllLendIdYearVo(apartmentName,year);
    }

    public List<LendVo> getAllPageLendVo(int page, int num) throws SQLException {
        return lendDao.getAllPageLendVo(page,num);
    }

    public List<LendVo> getTotalPageVo() throws SQLException {
        return lendDao.getAllLendVo();
    }

	public LendVo getLendVo(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return lendDao.getLendVo(id);
	}

    

}
