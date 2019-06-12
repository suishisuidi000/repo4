package cn.it.Dao;

import cn.it.Object.User;
import cn.it.Until.untilJdbc;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoTest {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(untilJdbc.getDs());

    public  static User TestLogin(User user){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }

}
