/*
package cn.it.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        String uri = request.getRequestURI();
        if(request.getRequestURI().contains("/login")||request.getRequestURI().contains("/css/")||request.getRequestURI().contains("/fonts/")
                ||request.getRequestURI().contains("/js/")||request.getRequestURI().contains("/checkCodeServlet")){
                 chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("user");

            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("check_error", "您尚未登陆,请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);

            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
*/
