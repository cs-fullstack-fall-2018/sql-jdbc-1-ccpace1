package com.company;
import java.sql.*;

public class Second {

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:Classes");
        Statement stmt=connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM Classes LEFT JOIN Teachers ON Classes.classID = Teachers.classID ");

        while(resultSet.next())
        {
            String className = resultSet.getString("ClassName");
            String name = resultSet.getString("FirstName");
            System.out.println(className+", "+ name);
        }

        stmt.close();
        connection.close();
    }
}