package cn.it.servlet;

import cn.it.dao.userDao;
import cn.it.domain.user;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       /* String username = request.getParameter("username");
        String password = request.getParameter("password");
        user loginuser = new user();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
        user loginuser = new user();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userDao dao = new userDao();
        user login = dao.login(loginuser);

        if(login==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            request.setAttribute("user",login);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
