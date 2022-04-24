package com.example.backenddesign.service;

import com.example.backenddesign.models.employee;
import com.example.backenddesign.utility.DatabaseConnector;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserIntegration {

    static String sqlString;
    static Statement stmt;
    private static Connection conn;
    private ResultSet rs;


    public List<employee> returnUser(String userInput) {
        ArrayList<employee> returnChosenUser = new ArrayList<employee>();
        try {
            Connection conn = DatabaseConnector.getConnection();


            sqlString = "SELECT * FROM employees " + "WHERE id= " + userInput;

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlString);

            while (rs.next()) {

                String EmName = rs.getString(2);
                String job = rs.getString(3);
                int manager = rs.getInt(4);
                String hiredate = rs.getString(5);
                int salary = rs.getInt(6);
                int comission = rs.getInt(7);
                int DpNumb = rs.getInt(8);
                returnChosenUser.add(new employee(userInput, EmName, job, manager, hiredate, salary, comission, DpNumb));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return returnChosenUser;
    }


    public boolean addUserDB(String ID, String name, String job, String manager, String hire, String salary, String commission, String DP) {
        Connection conn = DatabaseConnector.getConnection();

        sqlString = "INSERT INTO " + "employees " + "(id,employee_name,job,manager,hiredate,salary,commission,department_number)" +
                " values (" + "'" + ID + "','" + name + "','" + job + "','" + manager + "','" + hire + "','" + salary + "','" + commission + "','" + DP + "');";


        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    }

