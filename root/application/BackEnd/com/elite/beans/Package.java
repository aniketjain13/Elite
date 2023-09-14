package com.elite.beans;

import java.util.ArrayList;
import java.util.List;

public class Package {

    // Package data (class members)
    private String packageId;
    private String packageType;
    private List<String> listOfServices;
    private int amount;
    
    // class constructors
    public Package(String packageId, String packageType, List<String> listOfServices, int amount) {
        this.packageId = packageId;
        this.packageType = packageType;
        this.listOfServices = listOfServices;
        this.amount = amount;
    }
    public Package() {
        this.packageId = "";
        this.packageType = "";
        this.listOfServices = new ArrayList<String>();
        this.amount = 0;
    }
    
    // class getter setters
    public String getPackageId() {
        return packageId;
    }
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    
    public String getPackageType() {
        return packageType;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    
    public List<String> getListOfServices() {
        return listOfServices;
    }
    public void setListOfServices(List<String> listOfServices) {
        this.listOfServices = listOfServices;
    }
    
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // class to string method
    @Override
    public String toString() {
        return "Package [packageId=" + packageId + ", packageType=" + packageType + ", listOfServices=" + listOfServices
                + ", amount=" + amount + "]";
    }
    
}

