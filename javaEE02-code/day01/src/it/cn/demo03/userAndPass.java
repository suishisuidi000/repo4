package it.cn.demo03;

import JDBCUtils.JDBCTool;

import java.sql.*;
import java.util.Scanner;

public class userAndPass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        boolean boo = new userAndPass().isMethod(username, password);
        if(boo){
            System.out.println("登陆成功!");
        }else {
            System.out.println("用户名或密码不正确!");
        }

    }
    public boolean isMethod(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where username ='"+username+"' and password = '"+password+"'";
             rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTool.close(rs,stmt,conn);
        }

        return false;
    }
}
