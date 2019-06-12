package cn.it.Test000;

import cn.it.dao.userDao;
import cn.it.domain.user;
import org.junit.Test;

public class Test01 {
 @Test
 public void show(){
  user use = new user();
  use.setUsername("superbaby");
  use.setPassword("1231");
  userDao dao = new userDao();
  user login = dao.login(use);
  System.out.println(login);
 }

}
