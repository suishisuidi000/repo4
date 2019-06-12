package cn.it.cookieText03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Servlet_lastshow")
public class Servlet_lastshow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Boolean flag = false;
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastT".equals(name)){
                    flag=true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来,您上次访问时间为"+value+"</h1>");

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = sdf.format(date);
                    format = URLEncoder.encode(format,"utf-8");
                    cookie.setValue(format);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(cookies==null||cookies.length==0||flag==false){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String format = sdf.format(date);
            format = URLEncoder.encode(format,"utf-8");
            Cookie cookie = new Cookie("lastT",format);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            response.getWriter().write("<a>欢迎您首次访问!</a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
