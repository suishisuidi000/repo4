package cn.it.servlet_demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_demo03")
public class Servlet_demo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if(referer!=null){
            if(referer.contains("/")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影...");
                /*System.out.println("播放电影!");*/
            }else {
               /* System.out.println("路径不对,无法播放");*/
               response.setContentType("text/html;charset=utf-8");
               response.getWriter().write("访问地址不正确...");
            }

        }
    }
}
