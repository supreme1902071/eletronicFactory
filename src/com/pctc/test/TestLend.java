package com.pctc.test;

import com.pctc.dao.LendDao;
import com.pctc.dao.LendDaoImpl;
import com.pctc.model.Lend;
import com.pctc.service.LendService;
import com.pctc.service.LendServiceImpl;
import com.pctc.util.DateUtil;
import com.pctc.vo.LendVo;

import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestLend {
    LendDao lendDao=new LendDaoImpl();
    LendService lendService=new LendServiceImpl(lendDao);
    String dateString= DateUtil.date2String(new Date());
    Date date=DateUtil.string2Date(dateString);
    @Test
    public void testgetAllLendVo(){
        try {
            System.out.println(lendService.getAllLendVo());
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testaddLendVo(){

        LendVo lend = new LendVo(null,"1902072",2019,"绩效档案",date, new Date(122,9,2),false,"财务部","张馨予");
        try {
            int count=lendService.addLendVo(lend);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testdropLendVo(){

        try {
            int count=lendService.dropLendVo(7);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testeditLendVo(){
        LendVo lend = new LendVo(6,"1902072",2019,"请假档案",date, new Date(122,8,20),false,"财务部","张馨予");
        try {
            int count=lendService.editLendVo(lend);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testgetAllLendIdYearVo(){

//        try {
//            List <LendVo> lists=lendService.getAllLendIdYearVo("总部",2018);
//            System.out.println(lists);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    	
    	 String str ="2022-08-15 11:30:00";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         Date date=new Date();
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println(date);
    }
    @Test
    public void testgetAllPageLendVo(){

        try {
            List <LendVo> lists=lendService.getAllPageLendVo(2,4);
            System.out.println(lists);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
