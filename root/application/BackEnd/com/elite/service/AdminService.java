package com.elite.service;

import java.util.List;

import com.elite.beans.Admin;
import com.elite.beans.User;
import com.elite.beans.Vendor;
import com.elite.exceptions.AdminNotFoundException;
import com.elite.exceptions.VendorAlreadyExist;
import com.elite.storage.AdminStoreImpl;
import com.elite.storage.UserStoreImpl;
import com.elite.storage.VendorStoreImpl;
import com.elite.webpage.adminpages.AdminHomePage;

// AdminService class and its various methods

public class AdminService {
    
    // method to check admin validity
    public AdminHomePage isValidAdmin(Admin adminSample) throws AdminNotFoundException{
        AdminStoreImpl adminStoreImpl = new AdminStoreImpl();

        Admin admin = adminStoreImpl.getAdmin(adminSample.getUserName());

        if(admin.getPassword().equals(adminSample.getPassword())){
            return new AdminHomePage(admin);
        }
        else{
            throw new AdminNotFoundException("Incorrect Login Credentials.");
        }
    }

    // method to add vendor
    public String addVendor(Vendor vendor){
        VendorStoreImpl vendorStoreImpl = new VendorStoreImpl();
        try {
            vendorStoreImpl.addVendor(vendor);
            return "Add Vendor Success:400";
        } catch (VendorAlreadyExist e) {
            return e.getMessage();
        }
    }

    // method to view vendor
    public List<Vendor> viewVendor(){
        VendorStoreImpl vendorStoreImpl = new VendorStoreImpl();
        return vendorStoreImpl.getAllVendor();
    }

    // method to view user registration
    public List<User> viewUserRegistrations(){
        UserStoreImpl userStoreImpl = new UserStoreImpl();
        return userStoreImpl.getUserRegistrations();
    }

    // method to activate users
    public String activateUser(String userId){
        UserStoreImpl userStoreImpl = new UserStoreImpl();
        userStoreImpl.activateUser(userId);
        return "User status updated Success:400";
    }


}
