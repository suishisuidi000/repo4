package cn.it.web.servlet;

import cn.it.domain.PageUser;
import cn.it.domain.User;
import cn.it.service.UserService;
import cn.it.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/totalServlet")
public class totalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage==null||"".equals(currentPage)){
            currentPage = "1";
        }
        if(rows==null||"".equals(rows)){
            rows = "5";
        }

        UserService service = new userServiceImpl();
        PageUser pb =  service.pageFind(currentPage,rows);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
