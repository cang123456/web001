<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
    <a href="http://localhost:8080/web001_war_exploded/Register.jsp">注册</a>
        <form method="post" action="http://localhost:8080/web001_war_exploded/Login">
            账号：<input type="text" name="id"><br>
            密码：<input type="password" name="password"><br>
            <input type="submit" value="登录"><input type="reset" value="重置">
        </form>
    </body>
</html>