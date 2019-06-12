package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.imageDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.dao.impl.imageDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao dao = new RouteDaoImpl();
    private imageDao imgDao = new imageDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    @Override
    public PageBean<Route> findPage(int current, int rows, int cid, String rname) {
        PageBean p = new PageBean();
        p.setCurrent(current);
        p.setRows(rows);
        int start = (current - 1) * rows;
        int totalCount = dao.findCount(cid,rname);
        p.setTotalCount(totalCount);
        int pageCount = totalCount % rows == 0 ? totalCount/rows :  totalCount/rows + 1 ;
        p.setTotalPage(pageCount);
        List<Route> list = dao.pageFind(start, rows, cid,rname);
        p.setList(list);
        return p;
    }

    @Override
    public Route queryOne(int rid) {
        //根据rid 查询route表,返回Route对象.
        Route r = dao.findone(rid);
        //根据rid 查询 image表.返回list集合
        List<RouteImg> img = imgDao.findImg(rid);
        r.setRouteImgList(img);
        //根据 sid 查询 tab_seller商家信息
        Seller seller = sellerDao.querySeller(r.getSid());
        r.setSeller(seller);
        int count = dao.findCount(rid);
        r.setCount(count);
        return r;
    }

    @Override
    public void add(String rid, int uid) {
        dao.add(Integer.parseInt(rid),uid);
    }

    @Override
    public boolean query(int rid, int uid) {
        Favorite favorite = dao.query(rid,uid);
        if(favorite!=null){
            return true;
        }
        return false;
    }

    @Override
    public PageBean<Route> queryUserMyfavorite(int uid,int currentPage,int rowsCount) {

        PageBean<Route> pb = new PageBean<>();
        pb.setRows(rowsCount);
        pb.setCurrent(currentPage);
        int totalCount = dao.queryCount(uid);
        pb.setTotalCount(totalCount);
        int totalPage = totalCount % rowsCount == 0 ? totalCount/rowsCount :totalCount / rowsCount +1;
        pb.setTotalPage(totalPage);
        int start = (currentPage-1)*rowsCount;
        List<Route> list = dao.queryMyfavorite(uid,start,rowsCount);
        pb.setList(list);
        return pb;
    }
}
