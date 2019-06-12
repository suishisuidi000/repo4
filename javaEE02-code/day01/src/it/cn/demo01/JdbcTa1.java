package it.cn.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTa1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "984683");
             stmt = conn.createStatement();
            String sql = "insert into account value(null,'zhaoliu',220)";
            int i = stmt.executeUpdate(sql);
            System.out.println(i);
            if(i>0){
                System.out.println("执行成功!");
            }else{
                System.out.println("执行失败!");
            }
        }catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
