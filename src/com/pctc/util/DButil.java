package com.pctc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �������ݿ�Ĺ�����
 *   @author pkd
 *
 */
public class DButil {


    private static Connection con = null;


    /**
     * ��ȡ����
     * @return
     */
    public static Connection getConnection() {

        // 1.��������,�ڼ�������֮ǰҪ����mysql��jar��

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("������ϣ�");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("������������");
        }


        // 2.��ȡ����
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/electronic_factory?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "123");
            System.out.println("mysql���ݿ����ӳɹ���");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("�������ݿ����");
        }


        return con;
    }


    /**
     * �ر�����
     */
    public static void closeConnection(){
        try {
            con.close();
            System.out.println("mysql���ݿ�رգ���");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
