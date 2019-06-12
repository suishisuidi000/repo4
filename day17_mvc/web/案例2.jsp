<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.it.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>案例2</title>

    <script>
        window.onload = function () {
            var ele = document.getElementById("aa");
            //绑定鼠标移动到事件
            ele.onmouseover = function () {
                this.bgColor="pink";
            }
            //绑定鼠标离开事件
            ele.onmouseleave = function () {
                this.bgColor="green";
            }
        }
    </script>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User("王大大","10",new Date()));
        list.add(new User("张小小","15",new Date()));
        list.add(new User("李花花","9",new Date()));
        request.setAttribute("list",list);
    %>


    <table border="1" align="center" width="500" cellspacing="0">
        <tr id="aa" >
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <c:if test="${s.count%2!=0}">
                <tr align="center">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.str_Bir}</td>
                </tr>
            </c:if>
            <c:if test="${s.count%2==0}">
                <tr align="center">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.str_Bir}</td>
                </tr>
            </c:if>

        </c:forEach>

    </table>


</body>
</html>
