package com.pctc.test;


import com.pctc.util.DButil;

/**
 * �������ݿ�������
 */
public class TestDButil {

    public static void main(String[] args) {
        DButil.getConnection();
        DButil.closeConnection();
    }

}