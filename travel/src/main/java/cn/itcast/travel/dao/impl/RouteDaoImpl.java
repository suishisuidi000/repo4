package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findCount(int cid, String rname) {
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();
        if(cid!=0){
            sb.append(" and cid = ? ");
            list.add(cid);
        }
        if(rname!=null && rname.length()>0){
            sb.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }


        Integer i = template.queryForObject(sb.toString(), Integer.class, list.toArray());
        return i;
    }

    @Override
    public Route findone(int i) {
        String sql = "select * from tab_route where rid = ?";
        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), i);
        return route;
    }

    @Override
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        template.update(sql, rid, new Date(), uid);
    }

    @Override
    public Favorite query(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (DataAccessException e) {

        }
        return favorite;
    }

    @Override
    public int findCount(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";
        Integer i = template.queryForObject(sql, Integer.class, rid);
        return i ;
    }

    @Override
    public List<Route> queryMyfavorite(int uid,int start,int rowsCount) {
        String sql = "SELECT * FROM tab_route WHERE rid IN(SELECT rid FROM `tab_favorite` WHERE uid = ? ) limit ?, ? ";
        List<Route> list = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), uid, start, rowsCount);
        return list;
    }

    @Override
    public int queryCount(int uid) {
        String sql = "select count(*) from tab_favorite where uid = ?";
        Integer integer = template.queryForObject(sql, Integer.class, uid);
        return integer;
    }

    @Override
    public List<Route> pageFind(int start, int rows, int cid, String rname) {
       String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List li = new ArrayList();
        if(cid!=0){
            sb.append(" and cid = ? ");
            li.add(cid);
        }
        if(rname!=null && rname.length()>0){
            sb.append(" and rname like ? ");
            li.add("%"+rname+"%");
        }
       sb.append(" limit ? , ? ");
        li.add(start);
        li.add(rows);

        List<Route> list = template.query(sb.toString(), new BeanPropertyRowMapper<Route>(Route.class), li.toArray());
        return list;
    }


}
