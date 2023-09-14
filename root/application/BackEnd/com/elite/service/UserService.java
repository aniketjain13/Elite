package com.elite.service;

import java.util.Date;
import java.util.List;

import com.elite.beans.PlanRequest;
import com.elite.beans.Quotation;
import com.elite.beans.User;
import com.elite.exceptions.IncorrectPassword;
import com.elite.exceptions.PlanAlreadyRequested;
import com.elite.exceptions.UserAlreadyExist;
import com.elite.exceptions.UserInActive;
import com.elite.exceptions.UserNotFoundException;
import com.elite.storage.PlanRequestStore;
import com.elite.storage.PlanRequestStoreImpl;
import com.elite.storage.QuotationStore;
import com.elite.storage.QuotationStoreImpl;
import com.elite.storage.UserStore;
import com.elite.storage.UserStoreImpl;
import com.elite.webpage.userpages.UserHomePage;

// UserService class and its various methods

public class UserService {
    
    // methods to check user validity
    public UserHomePage isValidUser(User userSample) throws UserNotFoundException {
        UserStore userStore = new UserStoreImpl();
    
        User user = userStore.getUserByUserName(userSample.getUserName());
        if(user.getPassword().equals(userSample.getPassword())){
            return new UserHomePage(user);
        }
        else{
            throw new UserNotFoundException("Incorrect Login Credentials.");
        }
    }

    // method to edit user
    public String editUser(String userId, User userNewData){
        UserStore userStore = new UserStoreImpl();
        userStore.editUser(userId, userNewData);
        return "Details Updated Success:400";
    }

    // method to change user password after confirming the current password
    public String changePassword(String userId, String currentPasssword, String newPassword) throws IncorrectPassword{

        UserStore userStore = new UserStoreImpl();

        User user = userStore.getUserById(userId);
        if(user.getPassword().equals(currentPasssword)){
            userStore.changePassword(userId, newPassword);
            return "Password Changed Success:400";
        }
        else{
            throw new IncorrectPassword("The entered password doesn't match the current password, please enter the correct password.");
        }
    }

    // methods to sen plan request
    public String sendPlanRequest(PlanRequest planRequest, String userId){
        
        UserStore userStore = new UserStoreImpl();
        
        try{
            userStore.checkUserStatus(userId);
        }
        catch(UserInActive e){
            return e.getMessage();
        }
        
        if(planRequest.getNoOfPerson() <= 30){
            return "No. of persons should be greater than 30.";
        }
        
        Date currentDate = new Date();
        
        if(currentDate.compareTo(planRequest.getFromDate()) <= 0){
            return "The From Date should be greater than current date.";
        }
        
        PlanRequestStore planRequestStore = new PlanRequestStoreImpl();
        
        try {
            planRequestStore.addPlanRequest(planRequest);
            return "Plan Request Sent Success:400";
        } 
        catch (PlanAlreadyRequested e) {
            return e.getMessage();
        }
    }

    // method to view all the quotation on the plan request send by a particular user
    public List<Quotation> viewQuotation(String userId){
        QuotationStore quotationStore = new QuotationStoreImpl();
        return quotationStore.getAll(userId);
    }

    // method to change the quotation status to accepted or rejected
    public String changeQuotationStatus(String quotationId, String newStatus){
        QuotationStore quotationStore = new QuotationStoreImpl();
        quotationStore.changeQuotationStatus(quotationId, newStatus);
        return "Quotation Status Changed Success:400";
    }

    // method to register user
    public String registerUser(User userData) {
        UserStore userStore = new UserStoreImpl();

        try{
            userStore.registerUser(userData);
            return "User Registered Please Login Success:400";
        }
        catch (UserAlreadyExist e){
            return e.getMessage();
        }
    }
}
