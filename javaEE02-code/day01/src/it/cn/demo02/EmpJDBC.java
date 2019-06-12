package it.cn.demo02;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpJDBC {
    public static void main(String[] args) {
        List<Emp> li = new EmpJDBC().show();
        for (Emp emp : li) {
            System.out.println(emp);
        }
    }

    public List<Emp> show() {
        List<Emp> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db2", "root", "984683");
            stmt = conn.createStatement();
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            Emp emp = null;
            Class empClass = Emp.class;
            Field[] fields = empClass.getDeclaredFields();
            while (rs.next()) {
                emp = (Emp) empClass.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    String type = field.getType().getSimpleName();
                    if ("int".equals(type)) {
                        field.set(emp, rs.getInt(name));
                    } else if ("String".equals(type)) {
                        field.set(emp, rs.getString(name));
                    } else if ("Date".equals(type)) {
                        field.set(emp, rs.getDate(name));
                    } else if ("double".equals(type)) {
                        field.set(emp, rs.getDouble(name));
                    }
                }
                list.add(emp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
