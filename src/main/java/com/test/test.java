package com.test;

import com.db.Database;
import com.model.Usedata;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        Database.showConnect();
//        Database.insert(2,"小胡","123456");

//        Usedata usedata = Database.getUser(1);
//        System.out.println(usedata.getName());
//        Database.close();


        Usedata usedata = Database.login(2,"123456");
        System.out.println(usedata);
        if(usedata == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功"+usedata.getName());
        }























    }
}
