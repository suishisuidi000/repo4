package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    List<Route> pageFind(int start, int rows, int cid, String rname);

    int findCount(int cid, String rname);

    Route findone(int i);

    void add(int rid, int uid);

    Favorite query(int rid, int uid);

    int findCount(int rid);

    List<Route> queryMyfavorite(int uid,int start,int rowsCount);

    int queryCount(int uid);

}
