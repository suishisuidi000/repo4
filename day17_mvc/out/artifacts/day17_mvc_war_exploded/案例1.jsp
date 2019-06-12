<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.it.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息表格</title>
    <script>
        window.onload = function () {
            var ele = document.getElementById("cc");
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
           list.add(new User("张三","23",new Date()));
           list.add(new User("李四","28",new Date()));
           list.add(new User("王五","33",new Date()));
           request.setAttribute("list",list);
       %>
       <table border="1" cellspacing="0" width="500" align="center">
           <tr id="cc">
               <th>编号</th>
               <th>姓名</th>
               <th>年龄</th>
               <th>日期</th>
           </tr>
           <c:forEach items="${list}" var="user" varStatus="s">
              <c:if test="${s.count%2!=0}">
                  <tr bgcolor="#ff69b4">
                      <td>${s.count}</td>
                      <td>${user.name}</td>
                      <td>${user.age}</td>
                      <td>${user.str_Bir}</td>
                  </tr>
              </c:if>
               <c:if test="${s.count%2==0}">
                   <tr bgcolor="#663399">
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
