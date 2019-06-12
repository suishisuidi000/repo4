package cn.it.demo01;

import cn.it.Dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Servlet_login")
public class Servlet_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String check_session = (String)session.getAttribute("check_num");
        session.removeAttribute("check_num");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User login = userDao.login(user);
        System.out.println(login);
        if (check_session!=null&&check_session.equalsIgnoreCase(checkCode)) {
            if (/*login!=null&&*/login.getUsername().equals(username) && login.getPassword().equals(password) ) {
                //登陆成功,重定向
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                request.setAttribute("login_error", "用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("yzm_error", "验证码不正确!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
