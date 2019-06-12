package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private  UserService service = new UserServiceImpl();
    /**
     * 激活方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if(code!=null){

            boolean flag = service.active( code);
            String msg = null;
            if(flag){
                msg = "<a href = \"..\\login.html\">激活成功,请登录</a>";
            }else {
                msg = "激活失败,请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
           response.getWriter().write(msg);

        }

    }
    /**
     * 登录方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute(checkcode_server);

        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            ResultInfo infoq = new ResultInfo();
            infoq.setFlag(false);
            infoq.setErrorMsg("验证码不正确");
            writeValue(infoq,response);
            return;
        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User u = service.login(user);
        ResultInfo info = new ResultInfo();

        if(u==null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        if(u!=null&&!"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您尚未激活,请登录邮箱激活");
        }
        if(u!=null&&"Y".equals(u.getStatus())){
            info.setFlag(true);
            request.getSession().setAttribute("uu",u);
        }
        writeValue(info,response);


    }
    /**
     * 注册方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute(checkcode_server);
        response.setContentType("application/json;charset=utf-8");
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码不正确");
           writeValue(info,response);
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = service.register(user);
        ResultInfo info = new ResultInfo();
        if(flag){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }
       writeValue(info,response);
    }

    /**
     * 退出方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");

    }

    /**
     * 查找单个方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object uu = request.getSession().getAttribute("uu");
        if(uu!=null){
        writeValue(uu,response);
        }
    }
}
