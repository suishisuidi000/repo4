package it.cn.demo01;

import JDBCUtils.JDBCTool;

import java.sql.*;

public class JdbcTa2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            conn =JDBCTool.getConnection();
           //获取执行sql的对象
            stmt = conn.createStatement();
            String sql="select * from account ";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double balance = rs.getDouble(3);
                System.out.println(id+"--"+name+"--"+balance);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTool.close(rs,stmt,conn);
        }
    }
}
