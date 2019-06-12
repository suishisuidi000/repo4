package cn.it.demo03;

import cn.it.Utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/Servlet_load")
public class Servlet_load extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        String header = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(header,filename);
        response.setHeader("Content-disposition","attachment;filename="+filename);
        ServletOutputStream sos = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024*8];
        while ((len=fis.read(bytes))!=-1){
            sos.write(bytes,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
