package cn.it.dao;

import cn.it.Until.UntilJdbc;
import cn.it.domain.user;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class userDao {
   private JdbcTemplate template = new JdbcTemplate(UntilJdbc.getDataSouse());

   public  user  login(user loginUser){
       try {
           String sql = "select * from user where username= ? and password = ? ";
           user user = template.queryForObject(sql, new BeanPropertyRowMapper<user>(user.class),
                   loginUser.getUsername(), loginUser.getPassword());
           return user;
       }catch (Exception e){
           /*e.printStackTrace();*/
           return null;
       }
    }

}
