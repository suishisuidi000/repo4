package it.cn.demo03;

import JDBCUtils.JDBCTool;

import java.sql.*;

public class CommitAndRoll {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet re = null;
        Statement stmt = null;
        PreparedStatement pr1 = null;
        PreparedStatement pr2 = null;
        try {
            //与数据库获取链接
            conn = JDBCTool.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //定义sql语句
            String sql0 = "SELECT balance from account where id = 1";
             stmt = conn.createStatement();
            re = stmt.executeQuery(sql0);
            if(re.next()){
                double balance = re.getDouble("balance");
                if(balance>=500){
                    String sqll = "update account set balance = balance - ? where id = ?";

                    String sql2 = "update account set balance = balance + ? where id = ?";
                    //获取执行sql对象
                     pr1 = conn.prepareStatement(sqll);
                     pr2 = conn.prepareStatement(sql2);
                    //设置参数
                    pr1.setDouble(1, 500);
                    pr1.setInt(2, 1);

                    pr2.setDouble(1, 500);
                    pr2.setInt(2, 2);
                    //执行sql语句
                    pr1.executeUpdate();
                    pr2.executeUpdate();
                    //提交事务
                    conn.commit();
                    System.out.println("转账成功!");
                }else{
                    System.out.println("账户余额不足!");
                }
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    //回滚事务
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                JDBCTool.close(re,stmt,conn);
                JDBCTool.close(pr1,null);
                JDBCTool.close(pr2,null);
            }
        }
    }
}
