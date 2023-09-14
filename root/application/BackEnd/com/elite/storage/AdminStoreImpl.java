package com.elite.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elite.beans.Admin;

// AdminStore Implementation class to define and initialize its various methods

public class AdminStoreImpl implements AdminStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public AdminStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public List<Admin> getAdminList() {
        List<Admin> adminList = new ArrayList<Admin>();
        String getAdmin = "SELECT * FROM ADMINDATA";
        Statement stmt = JDBCConfiguration.createStatement(con);
        try{
            ResultSet rs = stmt.executeQuery(getAdmin);
            while(rs.next()){
                String userName = rs.getString(1);
                String fullName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String mobile = rs.getString(5);

                Admin admin = new Admin(userName, fullName, password, email, mobile);
                adminList.add(admin);
            }
            return adminList;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin getAdmin(String userName) {
        Admin admin = new Admin();
        String getSpecificAdmin = "SELECT * FROM ADMINDATA WHERE username=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getSpecificAdmin);
        try{
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String user = rs.getString(1);
                String fullName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String mobile = rs.getString(5);
                admin = new Admin(user, fullName, password, email, mobile);
            }
            return admin;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
