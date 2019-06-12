package cn.it.loadText;

import cn.it.Untils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servlet_loading")
public class Servlet_loading extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //获取文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //获取user-agent请求头浏览器版本信息
        String header = request.getHeader("user-agent");
        //设置响应头打开方式
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        //使用工具类编码文件
        filename = DownLoadUtils.getFileName(header,filename);
        System.out.println(filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
        //读取文件并响应到页面
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream os = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024*8];
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
