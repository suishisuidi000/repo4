package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
  private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean register(User user) {
        String email = user.getEmail();
        User u = userDao.findAll(user.getUsername());
        boolean flag = false;
        if(u==null){
            flag = true;
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            userDao.save(user);
            String text = "<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活[黑马旅游网]</a>";
            MailUtils.sendMail(user.getEmail(),text,"激活登录");
        }

        return flag;
    }

    @Override
    public boolean active(String code) {
        User user =  userDao.findCode(code);

        if(user==null){
            return false;
        }
        user.setStatus("Y");
         userDao.updateStatus(user);
        return true;
    }

    @Override
    public User login(User user) {
       User u = userDao.findLogin(user.getUsername(),user.getPassword());

       return u;

    }
}
