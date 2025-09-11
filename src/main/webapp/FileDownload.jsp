<%--
  Created by IntelliJ IDEA.
  User: ZhengLiangCang
  Date: 2025/9/15
  Time: 下午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        .download-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 10px;
        }
        .download-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>欢迎您！${name}，欢迎访问哈吉赵下载页面</h1>
<p>点击下方链接下载文件：</p>

<%-- 下载链接示例 --%>
<a href="downloads/c++图书管理系统-开发指导.pdf" class="download-link" download>
    下载PDF文件
</a>

<br><br>

<a href="files/report.xlsx" class="download-link" download>
    下载Excel文件
</a>
<br><br>
<p>目前访问次数：${num}</p>
</body>
</html>















<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ZhengLiangCang--%>
<%--  Date: 2025/9/15--%>
<%--  Time: 下午9:02--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <a> nihao</a>--%>
<%--</body>--%>
<%--</html>--%>
