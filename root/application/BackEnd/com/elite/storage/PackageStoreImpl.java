package com.elite.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elite.exceptions.PackageAlreadyExist;
import com.elite.beans.Package;

// PackageStore Implementation class to define and initialize its various methods

public class PackageStoreImpl implements PackageStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public PackageStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public void addPackage(Package pckage) throws PackageAlreadyExist{
        String insertPackage = "INSERT INTO PACKAGEDATA VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, insertPackage);
        try{
            stmt.setString(1, pckage.getPackageId());
            stmt.setString(2, pckage.getPackageType());
            stmt.setString(3, pckage.getListOfServices().toString());
            stmt.setInt(4, pckage.getAmount());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new PackageAlreadyExist("This package id already exist, please change the credentials.");
        }
    }

}
