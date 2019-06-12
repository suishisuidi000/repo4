package Dao.Impl;

import Dao.findUser;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.List;

public class findUserImpl implements findUser {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return list;
    }
}
