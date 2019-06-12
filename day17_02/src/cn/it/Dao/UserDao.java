package cn.it.Dao;

import cn.it.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();

    public User findUsernameAndPassword(String username,String password);

    void add(User user);

    void delU(String id);

    User selectU(int id);

    void updateU(User user);

    int getCount(Map<String, String[]> queryMap);

    List<User> getUserList(int start, int rows, Map<String, String[]> queryMap);
}
