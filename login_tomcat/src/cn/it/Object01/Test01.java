package cn.it.Object01;

import cn.it.Dao.daoTest;
import org.junit.Test;

public class Test01 {
    @Test
    public void show(){
        User user = new User();
        user.setUsername("wangjun");
        user.setPassword("45");
        User user1 = daoTest.loginMethod(user);
        System.out.println(user1);
    }
}
