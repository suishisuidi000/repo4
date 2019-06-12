package cn.it.Untils;

import com.alibaba.druid.support.ibatis.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class untilJdbc {
    private static DataSource ds;

    static{
        try {
            Properties p = new Properties();
            p.load(untilJdbc.class.getClassLoader().getResourceAsStream("druid.properties"));
           ds = com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDateSouse(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();

    }

}
