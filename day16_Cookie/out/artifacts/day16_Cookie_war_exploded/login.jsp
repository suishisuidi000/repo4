<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            var yzm = document.getElementById("yzm_img");
            yzm.onclick = function () {
                yzm.src = "/day16/Servlet_yzm?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        .aa{
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/day16/Servlet_login" method="post">
    <table align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
            <td class="aa"><%=request.getAttribute("yzm_error")==null?" ":request.getAttribute("yzm_error")%></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
            <td class="aa"><%=request.getAttribute("login_error")==null ? " ":request.getAttribute("login_error")%></td>
        </tr>
        <tr>
            <td colspan="2"><img id="yzm_img" src="/day16/Servlet_yzm"></td>

        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>

</form>


<%--request.getAttribute("yzm_error")==null?" ":request.getAttribute("yzm_error")--%>


</body>
</html>
