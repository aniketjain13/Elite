package com.elite.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.elite.beans.Vendor;
import com.elite.exceptions.VendorAlreadyExist;

// VendorStore Implementation class to define and initialize its various methods

public class VendorStoreImpl implements VendorStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public VendorStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public void addVendor(Vendor vendor) throws VendorAlreadyExist{
        String insertVendor = "INSERT INTO VENDORDATA VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, insertVendor);
        try{
            stmt.setString(1, vendor.getName());
            stmt.setString(2, vendor.getVendorId());
            stmt.setString(3, vendor.getPassword());
            stmt.setString(4, vendor.getAddress());
            stmt.setString(5, vendor.getEmail());
            stmt.setString(6, vendor.getContactNo());
            stmt.setString(7, vendor.getEventPackages().toString());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new VendorAlreadyExist("This vendor id already exist, please change the credentials.");
        }
    }

    @Override
    public List<Vendor> getAllVendor() {
        List<Vendor> vendorList = new ArrayList<Vendor>();
        String getAllVendors = "SELECT * FROM VENDORDATA";
        Statement stmt = JDBCConfiguration.createStatement(con);
        try{
            ResultSet rs = stmt.executeQuery(getAllVendors);
            while(rs.next()){
                String name = rs.getString(1);
                String vendorId = rs.getString(2);
                String password = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String contactNo = rs.getString(6);
                List<String> eventPackages = Arrays.asList(rs.getString(7).split(","));
                vendorList.add(new Vendor(name, vendorId, password, address, email, contactNo, eventPackages));
            }
            return vendorList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Vendor getVendor(String vendorId) {
        Vendor vendor = new Vendor();
        String getSpecificVendor = "SELECT * FROM VENDORDATA WHERE vendorId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getSpecificVendor);
        try{
            stmt.setString(1, vendorId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String name = rs.getString(1);
                String password = rs.getString(3);
                String address = rs.getString(4);
                String email = rs.getString(5);
                String contactNo = rs.getString(6);
                List<String> eventPackages = Arrays.asList(rs.getString(7).split(","));
                vendor = new Vendor(name, vendorId, password, address, email, contactNo, eventPackages);
            }
            return vendor;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changePassword(String vendorId, String newPassword) {
        String updatePassword = "UPDATE VENDORDATA SET password=? WHERE vendorId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, updatePassword);
        try{
            stmt.setString(1, newPassword);
            stmt.setString(2, vendorId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
