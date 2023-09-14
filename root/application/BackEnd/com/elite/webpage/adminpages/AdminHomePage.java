package com.elite.webpage.adminpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.elite.beans.Admin;
import com.elite.beans.User;
import com.elite.beans.Vendor;
import com.elite.webpage.HomePage;

// AdminHomPage and its variuos methods

public class AdminHomePage {
    
    // AdminHomePage data (class members)
    Admin admin;

    // class constructors
    public AdminHomePage(Admin admin){
        this.admin = admin;
    }
    public AdminHomePage(){
        this.admin = null;
    }

    // class methods
    public Vendor requestAddVendor(){
        return new Vendor("Kalyan", "V4", "password", "xyz street pune", "kalyan@gmail.com", "1234567890", new ArrayList<String>(Arrays.asList("PCK1", "PCK2", "PCK3")));
    }
    public void responseAddVendor(String msg){
        System.out.println(msg);
    }

    public void viewVendor(List<Vendor> vendorList){
        for(Vendor vendor : vendorList)
            System.out.println(vendor.toString());
    }

    public void viewUserRegistrations(List<User> userList){
        for (User user : userList){
            System.out.println(user.toString());
        }
    } 
    public User statusButtonToggled(){
        return new User("user123", "John Doe", "johndoe123", "password123", new Date(), new Date(),"IT", "1234567890", "john.doe@example.com", "New York", "inactive");
    }
    public void statusChanged(String response){
        System.out.println(response);
    }

    public HomePage logout(){
        admin = null;
        return new HomePage();
    }
}
