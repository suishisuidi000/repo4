<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2019/5/15
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
  out.println("aaa");
  out.write("bbb");
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>
  </body>
</html>
