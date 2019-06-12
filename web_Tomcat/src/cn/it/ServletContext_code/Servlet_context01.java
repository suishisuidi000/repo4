package cn.it.ServletContext_code;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servlet_context01")
public class Servlet_context01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* ServletContext context = request.getServletContext();
        String mimeType = context.getMimeType("c.jpg");
        System.out.println(mimeType);*/
        ServletContext context = this.getServletContext();
        //web下的文件访问
        String realPath = context.getRealPath("/a.txt");
        System.out.println(realPath);
        File file = new File(realPath);
        //WEB-INF下的文件访问
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);
        //src下的文件访问
        String b = context.getRealPath("/WEB-INF/classes/b.txt");
        System.out.println(b);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
