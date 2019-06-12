package cn.it.service;

import cn.it.domain.PageUser;
import cn.it.domain.User;

import java.util.List;

public interface UserService {

   public List<User> findAll();

    PageUser pageFind(String currentPage, String rows);

    void delcount(String[] uids);

}
