package com.example.web001;

import com.db.Database;
import com.model.Numdata;
import com.model.Usedata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static java.lang.System.out;
import static java.lang.Thread.sleep;


@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决网页乱码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("输入的账号为："+id+"密码"+password);
//        response.reset();

        try {
            Database database = new Database();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Usedata usedata = null;

        try {
            usedata = Database.login(id,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(usedata);
        if(usedata == null) {
            out.println("登录失败");
        } else {
            Numdata numdata = null;
            try {
                numdata = Database.getNum(1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

//            out.println("登录成功"+usedata.getName());
            // 方式1：请求转发到second.jsp
            request.setAttribute("message", "登录成功，欢迎您！");
            String name = usedata.getName();
            int num = numdata.getNum();
            request.setAttribute("name", name);
            request.setAttribute("num",num);
            request.getRequestDispatcher("/FileDownload.jsp").forward(request, response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

//@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
//public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置响应内容类型及字符集
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//
//        String idParam = request.getParameter("id");
//        if (idParam == null || idParam.isEmpty()) {
//            out.println("账号参数为空或未提供");
//            return;
//        }
//
//        int id;
//        try {
//            id = Integer.parseInt(idParam);
//        } catch (NumberFormatException e) {
//            out.println("账号参数格式不正确");
//            return;
//        }
//
//        String password = request.getParameter("password");
//        if (password == null || password.isEmpty()) {
//            out.println("密码参数为空或未提供");
//            return;
//        }
//
//        out.println("输入的账号为：" + id);
//        out.println("输入的密码为：" + password);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 处理GET请求的代码
//    }
//}

