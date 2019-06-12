package it.cn.demo03;

import JDBCUtils.JTool;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test07 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JTool.getDataScore());
        String sql = "update user set password=? where id=?";
        int update = template.update(sql, 888, 1);
        System.out.println(update);
    }
}
