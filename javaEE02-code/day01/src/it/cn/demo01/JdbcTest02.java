package it.cn.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "984683");
        String s ="update account set balance =300 ";
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(s);
        System.out.println(i);
        stmt.close();
        conn.close();

    }
}
