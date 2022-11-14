package com.pctc.test;


import com.pctc.util.DButil;

/**
 * 测试数据库连接类
 */
public class TestDButil {

    public static void main(String[] args) {
        DButil.getConnection();
        DButil.closeConnection();
    }

}