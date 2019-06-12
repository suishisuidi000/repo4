package cn.it.servlet_demo01;

import javax.servlet.*;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/ccc")
public class Test01 implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("开始运行了!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("qqqqqqqqqqqqqqqqq..................");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("结束吧");
    }
}
