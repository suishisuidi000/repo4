package cn.it.servlet_demo01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_Test03")
public class Servlet_Test03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                //设置字符集,并告诉浏览器
                //response.setHeader("content-type","text/html;charset=utf-8");
                /*response.setContentType("text/html;charset=utf-8");
*/
        System.out.println("111111111111111........");
              /* response.setStatus(302);
               response.setHeader("location","/Servlet_text02");*/
              response.sendRedirect("/Servlet_text02");

              /* response.getWriter().write("中国好男人!");*/
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
