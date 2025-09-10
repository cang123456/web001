package com.example.web001;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="RegisterServlet", urlPatterns={"/Register"})
public class Register {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决网页乱码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        PrintWriter out = response.getWriter();
        out.println("输入的账号为："+id+"密码"+password);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
