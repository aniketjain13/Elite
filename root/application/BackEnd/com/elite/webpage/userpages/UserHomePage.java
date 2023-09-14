package com.elite.webpage.userpages;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.elite.beans.PlanRequest;
import com.elite.beans.Quotation;
import com.elite.beans.User;
import com.elite.webpage.HomePage;

// UserHomePage and its various methods

public class UserHomePage {
    
    // class data member
    User user;

    // class constructor
    public UserHomePage(User user){
        this.user = user;
    }
    public UserHomePage(){
        this.user = null;
    }

    // class getter method
    public User getUser(){
        return user;
    }

    // class methods
    public void showProfile(){
        System.out.println(user.toStringNoPassword());
    }
    public User editToggeled(){
        return this.user;
    }
    public User requestEditedDetails(){
        return new User("1234567890", "asdfadsf123@gmail.com", "XYZ Street, Pune");
    }
    public void responseEditedDetails(String response){
        System.out.println(response);
    }

    public String requestChangePasswordCurrent(){
        return "password123";
    }
    public String requestChangePasswordNew(){
        return "passwordpassword";
    }
    public void responseChangePassword(String response){
        System.out.println(response);
    }

    public PlanRequest requestPlanRequestData(){
        return new PlanRequest("req145", user.getUserId(), new Date(), new Date(), Arrays.asList("Service A, Service B, Service C".split(",")), 500, Arrays.asList("Service X, Service Y".split(",")));
    }
    public void responsePlanRequestData(String response){
        System.out.println(response);
    }

    public void viewQuotation(List<Quotation> quotationList){
        for(Quotation quotation : quotationList)
            System.out.println(quotation.toString());
    }
    public String quotationStatus(){
        return "q1";
    }
    public String requestQuotationStatus(){
        return "Accept";
    }
    public void responseQuotationStatus(String response){
        System.out.println(response);
    }

    public HomePage logout(){
        user = null;
        return new HomePage();
    }
}
