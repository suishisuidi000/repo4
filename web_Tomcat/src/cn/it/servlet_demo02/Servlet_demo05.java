package cn.it.servlet_demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet( "/Servlet_demo05")
public class Servlet_demo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String user = request.getParameter("user");
        System.out.println(user);

        String[] users = request.getParameterValues("user");
        for (String s : users) {
            System.out.println(s);
        }*/
        request.setCharacterEncoding("utf-8");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String[] value = request.getParameterValues(name);
            for (String s : value) {
                System.out.println(s);
                System.out.println("---------------");
            }

        }
        System.out.println("----------------");
        Map<String, String[]> map = request.getParameterMap();
        for (String s : map.keySet()) {
            String[] value = map.get(s);
            for (String s1 : value) {
                System.out.println(s1);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   this.doPost(request,response);



    }
}
