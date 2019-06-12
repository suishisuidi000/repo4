package cn.it.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        System.out.println(uri);
        if(uri.contains("login")||uri.contains("/js/")||uri.contains("/css/")||
                uri.contains("/fonts")||uri.contains("checkCodeServlet")){

            chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(req, resp);

            }else {
                request.setAttribute("check_error","您尚未登陆,请登录");
                request.getRequestDispatcher("login.jsp").forward(request,resp);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
