package cn.it.service.Impl;

import cn.it.Dao.UserDao;
import cn.it.Dao.impl.UserDaoImpl;
import cn.it.domain.PageBean;
import cn.it.domain.User;
import cn.it.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addAll(User user) {
        dao.add(user);
    }

    @Override
    public void deleU(String id) {
        dao.delU(id);
    }

    @Override
    public User selectUser(String id) {
        return dao.selectU(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateU(user);
    }

    @Override
    public PageBean<User> totalLimit(String _currentPage, String _rows, Map<String, String[]> queryMap) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);//当前页面
        pb.setRows(rows);//每页显示的条数
        int count = dao.getCount(queryMap);
        pb.setTotalCount(count);//总查询数据数

        int page = count%rows ==0 ? count/rows : count/rows+1;
        pb.setTotalPage(page);//总页数

        int start = (currentPage-1) * rows;//分页开始索引

        List<User> list = dao.getUserList(start,rows,queryMap);
        pb.setList(list);
        return pb;


    }

    @Override
    public void deleAll(String[] uids) {
        for (String uid : uids) {
            dao.delU(uid);
        }
    }
}
