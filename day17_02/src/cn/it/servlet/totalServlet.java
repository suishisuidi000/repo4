package cn.it.servlet;

import cn.it.domain.PageBean;
import cn.it.domain.User;
import cn.it.service.Impl.UserServiceImpl;
import cn.it.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/totalServlet")
public class totalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage==null||"".equals(currentPage)||currentPage.contains(" ")){
                 currentPage = "1";
        }
        if(rows==null||"".equals(rows)||rows.contains(" ")){
            rows = "5";
        }
        Map<String, String[]> queryMap = request.getParameterMap();


        UserService service = new UserServiceImpl();
        PageBean<User> pb =  service.totalLimit(currentPage,rows,queryMap);
        request.setAttribute("pb",pb);
        request.setAttribute("queryMap",queryMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
