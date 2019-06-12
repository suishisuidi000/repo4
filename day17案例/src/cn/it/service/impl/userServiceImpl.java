package cn.it.service.impl;

import cn.it.dao.Impl.UserDaoImpl;
import cn.it.dao.UserDao;
import cn.it.domain.PageUser;
import cn.it.domain.User;
import cn.it.service.UserService;

import java.util.List;

public class userServiceImpl implements UserService{
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {

        return dao.fingAll();
    }

    @Override
    public PageUser pageFind(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        PageUser pb = new PageUser<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int start = (currentPage - 1)*rows;
        int count = dao.getPage();
        pb.setTotalCount(count);

        int pageCount = count % rows == 0 ? count/rows : count / rows +1;
        pb.setTotalPage(pageCount);

        List<User> list = dao.allCount(start,rows);

        pb.setList(list);

        return pb;


    }

    @Override
    public void delcount(String[] uids) {
        for (String uid : uids) {
            if(uid!=null&&!"".equals(uid)){
                dao.del(uid);
            }
        }
    }
}
