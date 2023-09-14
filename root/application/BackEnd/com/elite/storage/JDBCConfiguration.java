package com.elite.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// JDBCConfiguration class and its various methods

public class JDBCConfiguration {

    // method to get the connection object
    public static Connection createConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/elite","root","aniket413");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    // method to get the statement object
    public static Statement createStatement(Connection con){
        try{
            return con.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //method to get the preparedstatement object
    public static PreparedStatement createPreparedStatement(Connection con, String msg){
        try {
            return con.prepareStatement(msg);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
