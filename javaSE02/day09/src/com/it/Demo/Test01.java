package com.it.Demo;


import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Test01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new Driver());


        String url = "jdbc:mysql://localhost:3306/day05";
        String username = "root";
        String password = "8573";
        Connection connection = DriverManager.getConnection(url, username, password);

        String str = "select * from user where id!=?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setInt(1, 1);


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            System.out.print(resultSet.getInt("id") + " ");
            System.out.print(resultSet.getString("username") + " ");
            System.out.print(resultSet.getString("password") + " ");
            System.out.println(resultSet.getString("nickname") + " ");
            System.out.println("------------------------------------------------");

        }

        if (resultSet != null) {

            resultSet.close();

        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }


    }

    @Test
    public void select1() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得连接
        String url = "jdbc:mysql://localhost:3306/day05";
        String user = "root";
        String password = "8573";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3.创建执行sql语句对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句,处理结果
        String sql = "select * from user where username = 'ls' and password = '123456'";
        ResultSet resultSet = statement.executeQuery(sql);

        User use = null;

        while (resultSet.next()) {
            // 创建一个User对象,用来封装记录的列数据
            use = new User();

            // 封装数据
            use.setId(resultSet.getInt("id"));
            use.setUsername(resultSet.getString("username"));
            use.setPassword(resultSet.getString("password"));
            use.setNickname(resultSet.getString("nickname"));
        }
        // 5.释放资源
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
        // ...
        if (use == null) {
            System.out.println("失败");
        } else {
            System.out.println("成功");
        }

    }

    public void test() {
        System.out.println("123");
    }

    public void test() {
        System.out.println("456");
    }public void test() {
        System.out.println("789");
    }public void test() {
        System.out.println("234");
    }public void test() {
        System.out.println("666");
    }
}
