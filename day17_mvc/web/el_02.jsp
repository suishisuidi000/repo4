<%@ page import="cn.it.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            User user = new User();
            user.setName("张三");
            user.setAge("15");
            user.setBirthday(new Date());
            request.setAttribute("user",user);
        %>

         ${user.str_Bir()}<br>
         ${user}<br>
         ${user.name}

</body>
</html>
