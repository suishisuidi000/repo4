package cn.it.Untils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class UntilsJdbc {

        private static DataSource ds;
        static{
            try {
                Properties p = new Properties();
                InputStream is = UntilsJdbc.class.getClassLoader().getResourceAsStream("druid.properties");
                p.load(is);
                ds = DruidDataSourceFactory.createDataSource(p);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //获取连接池对象
        public static DataSource getDataSouse(){
            return ds;
        }
        //获取链接Connection对象
        public static Connection getConnection() throws SQLException {

            return ds.getConnection();
        }
    }

