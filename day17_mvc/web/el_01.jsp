<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%
     application.setAttribute("money","100");
     request.setAttribute("name","zhangsan");
     pageContext.setAttribute("gender","女");
     session.setAttribute("age","23");
     %>

${name}<br>
${age}<br>
${pageScope.gender}<br>
${applicationScope.money}

</body>
</html>
