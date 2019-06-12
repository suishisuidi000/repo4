<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
       <%
           List list = new ArrayList();
           list.add("aaa");
           list.add("bbb");
           list.add("ccc");
           request.setAttribute("list",list);
       %>
   <c:forEach items="${list}" var="str" varStatus="s">
       ${s.index}${str}<br>
   </c:forEach>

</body>
</html>
