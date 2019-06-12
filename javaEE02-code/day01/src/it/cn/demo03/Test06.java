package it.cn.demo03;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Test06 {
    public static void main(String[] args) {
        try {
            Properties p = new Properties();
            p.load(Test06.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(p);
            Connection conn = ds.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
