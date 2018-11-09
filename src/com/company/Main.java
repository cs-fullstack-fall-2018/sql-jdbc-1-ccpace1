package com.company;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:Classes");
        Statement stmt=connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM Teachers LEFT JOIN Classes ON Teachers.classID = Classes.classID ");

        while(resultSet.next())
        {
            String name = resultSet.getString("FirstName");
            String className = resultSet.getString("ClassName");
            System.out.println(name+", "+ className);
        }

        stmt.close();
        connection.close();
    }
}