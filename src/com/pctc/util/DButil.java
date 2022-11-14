package com.pctc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库的工具类
 *   @author pkd
 *
 */
public class DButil {


    private static Connection con = null;


    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {

        // 1.加载驱动,在加载驱动之前要导入mysql的jar包

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载完毕！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动出错！");
        }


        // 2.获取连接
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/electronic_factory?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "123");
            System.out.println("mysql数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接数据库出错！");
        }


        return con;
    }


    /**
     * 关闭连接
     */
    public static void closeConnection(){
        try {
            con.close();
            System.out.println("mysql数据库关闭！！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
