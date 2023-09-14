package com.elite.beans;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
    
    // Vendor data (class members)
    private String name;
    private String vendorId;
    private String password;
    private String address;
    private String email;
    private String contactNo;
    private List<String> eventPackages;
    
    // class constructors
    public Vendor(String name, String vendorId, String password, String address, String email, String contactNo, List<String> eventPackages) {
        this.name = name;
        this.vendorId = vendorId;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.eventPackages = eventPackages;
    }
    public Vendor(String vendorId, String password) {
        this.vendorId = vendorId;
        this.password = password;
    }
    public Vendor() {
        this.name = "";
        this.vendorId = "";
        this.password = "";
        this.address = "";
        this.email = "";
        this.contactNo = "";
        this.eventPackages = new ArrayList<String>();
    }
    
    // class getter setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getVendorId() {
        return vendorId;
    }
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    public List<String> getEventPackages() {
        return eventPackages;
    }
    public void setEventPackages(List<String> eventPackages) {
        this.eventPackages = eventPackages;
    }
    
    // class to string method
    @Override
    public String toString() {
        return "Vendor [name=" + name + ", vendorId=" + vendorId + ", password=" + password + ", address=" + address
                + ", email=" + email + ", contactNo=" + contactNo + ", eventPackages=" + eventPackages + "]";
    }
    public String toStringNoPassword() {
        return "Vendor [name=" + name + ", vendorId=" + vendorId + ", address=" + address
                + ", email=" + email + ", contactNo=" + contactNo + ", eventPackages=" + eventPackages + "]";
    }
    
}
