package cn.it.servlet;

import cn.it.service.Impl.UserServiceImpl;
import cn.it.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleAllServlet")
public class DeleAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");

        UserService service = new UserServiceImpl();

        service.deleAll(uids);

        response.sendRedirect(request.getContextPath()+"/totalServlet?currentPage="+request.getSession().getAttribute("page")+"&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
