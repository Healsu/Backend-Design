package com.example.backenddesign.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.backenddesign.models.department;
import com.example.backenddesign.utility.DatabaseConnector;

public class DepartmentDepository {

    public List<department> getAllEntities() {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departments");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                //Indsætte i en liste
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
        }
        return null;
    }
}
