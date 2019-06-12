package it.cn.demo03;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from user";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("PASSWORD");
            System.out.println(id+"---"+username+"---"+password);
        }
        if(rs!=null){
            rs.close();
        }if(stmt!=null){
            stmt.close();
        }if(conn!=null){
            conn.close();
        }
    }
}
