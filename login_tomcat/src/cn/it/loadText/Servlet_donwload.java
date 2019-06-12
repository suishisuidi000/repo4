package cn.it.loadText;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servlet_donwload")
public class Servlet_donwload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = new byte[1024*8];
        int len = 0;
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
