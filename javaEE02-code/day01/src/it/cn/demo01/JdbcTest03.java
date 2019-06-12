package it.cn.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest03 {
    public static void main(String[] args) throws Exception {

        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "984683");
        Statement stmt = conn.createStatement();
        String sql = "update account set balance = 666";
        int i = stmt.executeUpdate(sql);
        System.out.println(i);
        stmt.close();
        conn.close();

    }
}
