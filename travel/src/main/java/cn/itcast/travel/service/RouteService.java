package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;

import java.util.List;

public interface RouteService {
    PageBean findPage(int current, int rows, int cid, String rname);

    Route queryOne(int i);

    void add(String rid, int uid);

    boolean query(int i, int uid);

    PageBean<Route> queryUserMyfavorite(int uid, int currentPage, int rowsCount);
}
