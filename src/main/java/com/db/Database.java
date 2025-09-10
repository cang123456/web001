package com.db;

import com.model.Usedata;

import java.sql.*;

public class Database {
    static Connection conn = null;

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web001", "root", "123456");
//        System.out.println(conn);
    }



    public static void showConnect() {
        if(conn == null) {
            System.out.println("Database connection is null");
        } else {
            System.out.println("Database connection is available");
        }
    }

    public static void close() throws SQLException {
        conn.close();
    }

    public static void insert(int id,String name, String password) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("insert into web001.login value (null,?,?)");
//        prep.setString(1, String.valueOf(id));
        prep.setString(1,name);
        prep.setString(2,password);
        prep.execute();
    }


//在表中查询数据
    public static Usedata getUser(int id) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select * from web001.login where id=?");
        prep.setInt(1,id);
        prep.execute();
        ResultSet rs = prep.getResultSet();
        if(rs.next()) {
            int myid = rs.getInt("id");
            String myname = rs.getString("name");
            String mypassword = rs.getString("password");
            return new Usedata(myid,myname,mypassword);
        }
        return null;
    }



    public static Usedata login(int id, String pwd) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select * from web001.login where id=?");
        prep.setInt(1,id);
        prep.execute();
        ResultSet rs = prep.executeQuery();
        if(rs.next()) {
            String mypassword = rs.getString("password");
            if(mypassword.equals(pwd)) {
                return getUser(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }




















}
