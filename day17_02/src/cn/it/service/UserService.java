package cn.it.service;

import cn.it.domain.PageBean;
import cn.it.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAll();
    public User login(User user);

    void addAll(User user);

    void deleU(String id);

    User selectUser(String id);

    void updateUser(User user);

    PageBean<User> totalLimit(String currentPage, String rows, Map<String, String[]> queryMap);

    void deleAll(String[] uids);
}
