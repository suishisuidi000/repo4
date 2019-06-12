package it.cn.demo03;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test02 {
    public static void main(String[] args) throws Exception {
        InputStream is = Test02.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties p = new Properties();
        p.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(p);
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String aql = "select * from user";
        ResultSet rs = stmt.executeQuery(aql);
        while (rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(id+"--"+username+"--"+password);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
