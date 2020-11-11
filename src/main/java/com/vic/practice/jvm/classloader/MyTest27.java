package com.vic.practice.jvm.classloader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 源程序名称：MyTest27 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/11/10 10:19 下午 <br>
 *
 * @author baojiong20176
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/winoss", "root", "123456");
    }
}
