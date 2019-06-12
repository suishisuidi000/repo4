package cn.it.Dao;

import cn.it.Untils.UntilsJdbc;
import cn.it.Untils.UntilsJdbc;
import cn.it.demo01.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class userDao {
    private static JdbcTemplate template = new JdbcTemplate(UntilsJdbc.getDataSouse());

    public static User login(User loginUser){
        try {
            String sql = "select * from user where username= ? and password = ? ";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            /*e.printStackTrace();*/
            return null;
        }
    }

}
