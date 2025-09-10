<%--
  Created by IntelliJ IDEA.
  User: ZhengLiangCang
  Date: 2025/9/10
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="http://localhost:8080/web001_war_exploded/Login">
    用户号：<input type="text" name="id"><br>
    密码：<input type="password" name="password"><br>
    确认密码：<input type="password" name="password"><br>
    <input type="submit" value="注册"><input type="reset" value="重置">
</form>
</body>
</html>
