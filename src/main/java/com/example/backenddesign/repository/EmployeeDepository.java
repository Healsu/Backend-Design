
package com.example.backenddesign.repository;

import com.example.backenddesign.models.employee;
import com.example.backenddesign.utility.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDepository implements CRUDInterface<employee>{

    public List<employee> getAllEmployees(){
       List <employee> allEmployees = new ArrayList<>();
        try{
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                String id = rs.getString(1);
                String name = rs.getString(2);
                String job = rs.getString(3);
                int manager = rs.getInt(4);
                String hiredate = rs.getString(5);
                int salary = rs.getInt(6);
                int commission = rs.getInt(7);
                int DPnumb = rs.getInt(8);

                employee newEmployee = new employee(id,name,job,manager,hiredate,salary,commission,DPnumb);
                allEmployees.add(newEmployee);
            }

        } catch (SQLException e) {
            System.out.println("Something wrong with the database");
        }

        return allEmployees;
    }


    @Override
    public boolean create(employee entity) {
        return false;
    }

    @Override
    public employee getSingleEntityById() {
        return null;
    }

    @Override
    public List<employee> getAllEntities() {
        return null;
    }

    @Override
    public boolean update(employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
