package cn.it.web.servlet;

import cn.it.domain.Province;
import cn.it.service.ProvinceService;
import cn.it.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
	1. 提供index.html页面，页面中有一个省份 下拉列表
	2. 当 页面加载完成后 发送ajax请求，加载所有省份
 */
@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        ProvinceService service = new ProvinceServiceImpl();

       //List<Province> list = service.findAll();
        String s = service.proRedis();

        /*ObjectMapper mapper = new ObjectMapper();*/

        /*mapper.writeValue(response.getWriter(),s);*/
       response.getWriter().write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
