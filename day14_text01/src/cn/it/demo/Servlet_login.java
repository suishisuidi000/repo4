package cn.it.demo;

import cn.it.Dao.DaoTest;
import cn.it.Object.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/servlet_login")
public class Servlet_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
         User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User user1 = DaoTest.TestLogin(user);
        if(user1!=null){
            request.setAttribute("userlogin",user1);
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

     }
}
