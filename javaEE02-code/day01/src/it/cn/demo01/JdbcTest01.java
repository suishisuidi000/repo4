package it.cn.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest01 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "984683");
        //定义sql语句
        String sql = "update account set balance = 1000 where id=1";
        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);
        //处理结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();
    }
}
