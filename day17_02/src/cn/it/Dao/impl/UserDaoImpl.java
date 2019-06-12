package cn.it.Dao.impl;

import cn.it.Dao.UserDao;
import cn.it.Util.JDBCUtils;
import cn.it.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ? ";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, password);
            return user;
        } catch (DataAccessException e) {
            return null;
        }



    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delU(String id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User selectU(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateU(User user) {
        String sql = "update user set name = ?, gender = ?,age = ? , address = ?, qq = ?, email = ? where id = ?" ;
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int getCount(Map<String, String[]> queryMap) {
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> strings = queryMap.keySet();
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            if("currentPage".equals(string)||"rows".equals(string)){
                continue;
            }
            String value = queryMap.get(string)[0];
            if(value!=null&&!"".equals(value)) {
                sb.append(" and " + string + " like ? ");
                list.add("%"+value+"%");
            }
        }
        Integer integer = template.queryForObject(sb.toString(), Integer.class,list.toArray());
        return integer;

    }

    @Override
    public List<User> getUserList(int start, int rows, Map<String, String[]> queryMap) {
        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> strings = queryMap.keySet();
        List<Object> list1 = new ArrayList<>();
        for (String string : strings) {
            if("currentPage".equals(string)||"rows".equals(string)){
                continue;
            }
            String value = queryMap.get(string)[0];
            if(value!=null&&!"".equals(value)) {
                sb.append(" and " + string + " like ? ");
                list1.add("%"+value+"%");
            }
        }
        sb.append(" limit ? , ? ");
        list1.add(start);
        list1.add(rows);
        List<User> list = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),list1.toArray());
        return list;

    }
}
