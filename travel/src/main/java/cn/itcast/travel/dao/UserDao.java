package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    User findAll(String username);
    void save(User user);

    void updateStatus(User user);

    User findCode(String code);

    User findLogin(String username, String password);
}
