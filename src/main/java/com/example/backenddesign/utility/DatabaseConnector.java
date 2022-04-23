package com.example.backenddesign.utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnector(){};


    public static Connection getConnection(){

    if(conn != null){
        return conn;
    }

        System.out.println("Connecting to the database");
        try {
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");

            conn = DriverManager.getConnection(url, username, password);


            System.out.println("URL: " + url);
            System.out.println("Connection: " + conn);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");

        }

        return conn;

    }
}





