package cn.it.dao.Impl;

import cn.it.dao.UserDao;
import cn.it.domain.User;
import cn.it.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> fingAll() {
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public int getPage() {
        String sql = "select count(*) from user ";
        Integer integer = template.queryForObject(sql, Integer.class);

        return integer;
    }

    @Override
    public List<User> allCount(int start, int rows) {
        String sql = "select * from user limit ? , ?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
        return query;
    }

    @Override
    public void del(String uid) {
        String sql = "delete from user where id = ?";
        template.update(sql,uid);
    }
}
