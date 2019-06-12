package it.cn.demo03;

import JDBCUtils.JTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String username = sc.next();
        System.out.println("请输入您的密码:");
        String password = sc.next();
        boolean boo = createUse(username, password);
        if(boo){
            System.out.println("登陆成功!");
        }else {
            System.out.println("用户名或密码错误!");
        }
    }
    public static boolean createUse(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn =null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        try {
             conn = JTool.getConnection();
            String sql = "select * from user where username=? and password=?";
             pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
             rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JTool.close(rs,pstmt,conn );
        }
        return false;
    }
}
