package com.elite.webpage.vendorpages;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.elite.beans.Package;
import com.elite.beans.PlanRequest;
import com.elite.beans.Quotation;
import com.elite.beans.Vendor;
import com.elite.webpage.HomePage;

// VendorHomePage class and its various methods

public class VendorHomePage {
    
    // VendorHomePage data (class members)
    Vendor vendor;

    // class constructors
    public VendorHomePage(Vendor vendor){
        this.vendor = vendor;
    }
    public VendorHomePage(){
        this.vendor = null;
    }

    // class getter method
    public Vendor getVendor(){
        return this.vendor;
    }

    // class methods
    public Package requestAddPackage(){
        return new Package("pck1", "basic", Arrays.asList("Service A", "Service B", "Service C"), 500000);
    }
    public void responseAddPackage(String msg){
        System.out.println(msg);
    }

    public void viewUserRequestsList(List<PlanRequest> userRequestsList){
        for(PlanRequest request : userRequestsList){
            System.out.println(request.toString());
        }
    }
    public PlanRequest createQuotationToggled(){
        return new PlanRequest("req123", "user1", new Date(), new Date(), Arrays.asList("Service A, Service B, Service C".split(", ")), 500, Arrays.asList("Service X, Service Y".split(", ")));
    }
    public Quotation requestCreateQuotation(PlanRequest planRequest){
        return new Quotation("q1", "basic", 50000, vendor.getVendorId(), planRequest.getUserId(), planRequest.getRequestId(), "pending", new Date());
    }
    public void responseCreateQuotation(String response){
        System.out.println(response);
    }

    public String requestChangePasswordCurrent(){
        return "pass";
    }
    public String requestChangePasswordNew(){
        return "passwordpassword";
    }
    public void responseChangePassword(String response){
        System.out.println(response);
    }

    public void showProfile(){
        System.out.println(vendor.toStringNoPassword());
    }

    public HomePage logout(){
        vendor = null;
        return new HomePage();
    }
}
