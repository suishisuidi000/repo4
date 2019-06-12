package cn.it.Dao;

import cn.it.Object01.User;
import cn.it.Untils.untilJdbc;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class daoTest {
    private static JdbcTemplate template = new JdbcTemplate(untilJdbc.getDateSouse());
    public static User loginMethod(User user){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User users = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class)
                    , user.getUsername(), user.getPassword());
            return users;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
