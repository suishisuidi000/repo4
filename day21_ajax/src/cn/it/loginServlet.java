package cn.it;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("application/json;charset=utf-8");
         String username = request.getParameter("username");
        Map<String,Object> map = new HashMap<String, Object>();
         if("tom".equals(username)){
             map.put("state",true);
             map.put("msc","亲,用户名已存在!");
         }else {
             map.put("state",false);
             map.put("msc","注册成功!");
         }
        /*ObjectMapper mapper = new ObjectMapper();*/
        String s = JSONObject.toJSONString(map);
        response.getWriter().write(s);
        //mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
