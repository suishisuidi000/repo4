package cn.it.dao;

import cn.it.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> fingAll();

    int getPage();

    List<User> allCount(int start, int rows);

    void del(String uid);
}
