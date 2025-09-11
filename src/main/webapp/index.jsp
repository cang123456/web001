<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--    <head>--%>
<%--        <title>JSP - Hello World</title>--%>
<%--    </head>--%>
<%--    <body>--%>
<%--    <a href="http://localhost:8080/web001_war_exploded/Register.jsp">注册</a>--%>
<%--        <form method="post" action="http://localhost:8080/web001_war_exploded/Login">--%>
<%--            账号：<input type="text" name="id"><br>--%>
<%--            密码：<input type="password" name="password"><br>--%>
<%--            <input type="submit" value="登录"><input type="reset" value="重置">--%>
<%--        </form>--%>
<%--    </body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <style>
        /* 简单样式优化，提升页面美观度 */
        .form-container {
            width: 350px;
            margin: 80px auto;
            padding: 25px;
            border: 1px solid #eee;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.05);
        }
        .form-item {
            margin-bottom: 20px;
        }
        label {
            display: inline-block;
            width: 60px;
            text-align: right;
            margin-right: 10px;
        }
        input[type="text"],
        input[type="password"] {
            width: 220px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn-group {
            margin-left: 75px; /* 与输入框对齐 */
        }
        input[type="submit"],
        input[type="reset"] {
            padding: 8px 20px;
            margin-right: 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
        }
        input[type="reset"] {
            background-color: #f44336;
            color: white;
        }
        .error-tip {
            color: #f44336;
            font-size: 12px;
            margin-left: 75px;
            margin-top: 5px;
            display: none; /* 初始隐藏错误提示 */
        }
        .register-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
        }
        .register-link a {
            color: #2196F3;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="form-container">
    <!-- 登录表单：提交地址建议用相对路径，避免硬编码端口/项目名 -->
    <form method="post" action="${pageContext.request.contextPath}/Login" onsubmit="return checkLoginForm()">
        <div class="form-item">
            <label for="id">账号：</label>
            <input type="text" id="id" name="id" placeholder="请输入3-15位字母/数字">
            <div id="idError" class="error-tip">账号为必填项，且需3-15位字母或数字</div>
        </div>

        <div class="form-item">
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" placeholder="请输入6-15位密码">
            <div id="pwdError" class="error-tip">密码为必填项，且长度需6-15位</div>
        </div>

        <div class="btn-group">
            <input type="submit" value="登录">
            <input type="reset" value="重置" onclick="hideErrorTips()"> <!-- 重置时隐藏错误提示 -->
        </div>

        <div class="register-link">
            还没有账号？<a href="${pageContext.request.contextPath}/Register.jsp">立即注册</a>
        </div>
    </form>
</div>

<script>
    // 1. 校验登录表单（表单提交前触发）
    function checkLoginForm() {
        // 获取输入值（去除前后空格）
        const userId = document.getElementById("id").value.trim();
        const userPwd = document.getElementById("password").value.trim();
        let isLegal = true; // 标记表单是否合法

        // 校验账号：必填 + 3-15位 + 仅字母/数字
        const idReg = /^[A-Za-z0-9]{3,15}$/; // 正则表达式：匹配字母/数字，长度3-15
        if (userId === "") { // 空值校验
            showError("idError");
            isLegal = false;
        } else if (!idReg.test(userId)) { // 格式校验
            showError("idError");
            isLegal = false;
        } else {
            hideError("idError");
        }

        // 校验密码：必填 + 6-15位
        if (userPwd === "") { // 空值校验
            showError("pwdError");
            isLegal = false;
        } else if (userPwd.length < 6 || userPwd.length > 15) { // 长度校验
            showError("pwdError");
            isLegal = false;
        } else {
            hideError("pwdError");
        }

        return isLegal; // 合法则提交表单，否则不提交
    }

    // 2. 显示错误提示
    function showError(errorId) {
        document.getElementById(errorId).style.display = "block";
    }

    // 3. 隐藏错误提示
    function hideError(errorId) {
        document.getElementById(errorId).style.display = "none";
    }

    // 4. 重置按钮点击时隐藏所有错误提示
    function hideErrorTips() {
        hideError("idError");
        hideError("pwdError");
    }
</script>
</body>
</html>