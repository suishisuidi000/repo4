package it.cn.demo01;

import JDBCUtils.Utils01;

import java.sql.*;
import java.util.Scanner;

public class JdbcTes2aa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名:");
        String user = sc.nextLine();
        System.out.println("请输入你的密码:");
        String password = sc.nextLine();
        boolean b = new JdbcTes2aa().login(user, password);
        if(b){
            System.out.println("登陆成功!");
        }else {
            System.out.println("用户名或密码错误!");
        }
    }
    public boolean login(String user,String password){
        if(user==null||password==null){
            return false;
        }
        Connection conn = null;
        PreparedStatement statement =null;
        ResultSet  rs = null;
        try {
            conn = Utils01.getConnection();
            String sql = "select * from user where username = ? and password = ?";

            statement = conn.prepareStatement(sql);
            statement.setString(1,user);
            statement.setString(2,password);
            rs = statement.executeQuery();
             return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Utils01.close(rs,statement,conn);
        }
        return false;
    }
}
