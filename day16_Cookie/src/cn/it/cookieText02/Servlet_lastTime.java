package cn.it.cookieText02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Servlet_lastTime")
public class Servlet_lastTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Boolean flag = false;
        if(cookies!=null && cookies.length>0){
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("last".equals(name)) {
                    flag = true;
                    String value = c.getValue();
                    value = URLDecoder.decode(value,"utf-8");//URL解码 String value = c.getValue();
                    response.getWriter().write("<h1>欢迎回来,你上次访问时间为"+value+"</h1>");
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String time = sdf.format(date);
                    time = URLEncoder.encode(time,"utf-8");
                    c.setValue(time);
                    c.setMaxAge(60*60*24*30);
                    response.addCookie(c);
                    break;
                }
            }
        }
             if(cookies==null || cookies.length==0||flag==false){

                 Date data = new Date();
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                 String time = sdf.format(data);

                 time = URLEncoder.encode(time,"utf-8");//URL编码

                 Cookie c = new Cookie("last",time);
                 c.setMaxAge(60*60*24*30);
                 response.addCookie(c);

                 response.getWriter().write("<h1>欢迎您首次访问</h1>");
             }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
