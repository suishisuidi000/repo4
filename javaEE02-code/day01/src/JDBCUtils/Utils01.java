package JDBCUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class Utils01 {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static{
        try {
            Properties p = new Properties();
            ClassLoader classLoader = Utils01.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            p.load(new FileReader(path));
             url = p.getProperty("url");
             user = p.getProperty("user");
             password = p.getProperty("password");
             driver = p.getProperty("driver");
             Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection() throws SQLException {

         return DriverManager.getConnection(url,user,password);
        }

        public static void close(Statement stmt,Connection conn){
                if(stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
        public static void close(ResultSet rs,Statement stmt,Connection conn){
               if(rs!=null){
                   try {
                       rs.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
               if(stmt!=null){
                   try {
                       stmt.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
               if(conn!=null){
                   try {
                       conn.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
        }
}
