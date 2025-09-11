package com.db;

import com.model.Usedata;
import com.model.Numdata;

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
//关闭数据库连接
    public static void close() throws SQLException {
        conn.close();
    }

    //zj:在数据库中插入数据
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
        prep.setInt(1,id);//给 SQL 语句中的第一个参数设置一个整数类型的值id
        prep.execute();//执行 SQL 语句
        ResultSet rs = prep.getResultSet();//获取结果集
        if(rs.next()) {
            int myid = rs.getInt("id");
            String myname = rs.getString("name");
            String mypassword = rs.getString("password");
            return new Usedata(myid,myname,mypassword);
        }
        return null;
    }

 //查询访问 次数
 // 查询并更新访问次数
 public static Numdata getNum(int id) throws SQLException {
     // 使用try-with-resources自动关闭资源，避免泄漏
     try (PreparedStatement prep1 = conn.prepareStatement(
             "select * from web001.login_num where id=?")) {

         prep1.setInt(1, id);
         try (ResultSet rs = prep1.executeQuery()) { // 推荐用executeQuery()执行查询
             if (rs.next()) {
                 int myid = rs.getInt("id");
                 int mynum = rs.getInt("num");
                 int newNum = mynum + 1; // 计算新次数

                 // 更新语句：第一个?是num，第二个?是id
                 String sql = "UPDATE web001.login_num SET num = ? WHERE id = ?";
                 try (PreparedStatement prep = conn.prepareStatement(sql)) {
                     prep.setInt(1, newNum); // 第一个参数：新的num值
                     prep.setInt(2, myid);   // 第二个参数：id条件
                     prep.executeUpdate();   // 执行更新（推荐用executeUpdate()执行DML）
                 }

                 return new Numdata(myid, newNum);
             }
         }
     }
     return null;
 }

//    public static Numdata getNum(int id) throws SQLException {
//
//        PreparedStatement prep1 = conn.prepareStatement("select * from web001.login_num where id=?");
//        prep1.setInt(1,id);
//        prep1.execute();
//        ResultSet rs = prep1.getResultSet();
//        if(rs.next()) {
//            int myid = rs.getInt("id");
//            int mynum = rs.getInt("num");
//            String sql = "UPDATE web001.login_num SET num = ? WHERE id = ?";
//            PreparedStatement prep = conn.prepareStatement(sql);
//            prep.setInt(1,mynum+1);
//            prep.setInt(2,id);
//            prep.execute();
//            return new Numdata(myid,mynum+1);
//        }
//        return null;
//    }

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
