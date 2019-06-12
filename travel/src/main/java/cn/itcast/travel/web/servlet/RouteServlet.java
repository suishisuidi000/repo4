package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String current = request.getParameter("current");
        String rows = request.getParameter("rows");
        String cid = request.getParameter("cid");
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        int cur = 0;
        int row = 0;
        int ccid = 0;
        if ("null".equals(rname)) {
            rname = "";
        }
        if (cid != null && cid.length() != 0 && !"null".equals(cid)) {
            ccid = Integer.parseInt(cid);
        }
        if (current != null && current.length() != 0) {
            cur = Integer.parseInt(current);
        } else {
            cur = 1;
        }
        if (rows != null && rows.length() != 0) {
            row = Integer.parseInt(rows);
        } else {
            row = 5;
        }
        PageBean page = service.findPage(cur, row, ccid, rname);

        writeValue(page, response);

    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");

        Route route = service.queryOne(Integer.parseInt(rid));

        writeValue(route,response);
    }


    public void favorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User uu = (User) request.getSession().getAttribute("uu");
        int uid ;
        if(uu==null){
            uid = 0;
        }else {
            uid = uu.getUid();
        }
        boolean flag = service.query(Integer.parseInt(rid),uid);
        writeValue(flag,response);

    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("uu");
        if(user==null){
            return;
        }
        service.add(rid,user.getUid());
    }
    public void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uid = request.getParameter("uid");
        String current = request.getParameter("current");
        String rows = request.getParameter("rows");
        int currentPage;
        if(current!=null&&current.length()>0){
            currentPage = Integer.parseInt(current);
        }else {
            currentPage = 1 ;
        }
        int rowsCount;
        if(rows!=null&&rows.length()>0){
            rowsCount = Integer.parseInt(rows);
        }else {
            rowsCount = 12;
        }
        PageBean<Route> pb = service.queryUserMyfavorite(Integer.parseInt(uid),currentPage,rowsCount);

        writeValue(pb,response);

    }

}