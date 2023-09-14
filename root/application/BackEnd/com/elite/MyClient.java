// The Project title: Online Event Management
/* Team Member: Aniket Jain (Team Lead)
                Bhavesh Awal
                Tanya Ramwani
                Amogh Raman
                Sakshi Tejwani
                Sakshi Shimpi
                Silvia Pereira  */


package com.elite;

import java.util.List;

import com.elite.beans.Admin;
import com.elite.beans.Package;
import com.elite.beans.PlanRequest;
import com.elite.beans.Quotation;
import com.elite.beans.User;
import com.elite.beans.Vendor;

import com.elite.exceptions.AdminNotFoundException;
import com.elite.exceptions.IncorrectPassword;
import com.elite.exceptions.UserNotFoundException;
import com.elite.exceptions.VendorNotFoundException;

import com.elite.service.AdminService;
import com.elite.service.UserService;
import com.elite.service.VendorService;

import com.elite.webpage.HomePage;
import com.elite.webpage.adminpages.AdminHomePage;
import com.elite.webpage.adminpages.AdminLogin;
import com.elite.webpage.userpages.UserHomePage;
import com.elite.webpage.userpages.UserLogin;
import com.elite.webpage.userpages.UserRegistration;
import com.elite.webpage.vendorpages.VendorHomePage;
import com.elite.webpage.vendorpages.VendorLogin;

// Start Project

public class MyClient {
    public static void main(String[] args) {

/*********************************************SAMPLE RUN FOR BACKEND-SERVICES*********************************************/

        // we will be starting by creating an object of homepage
        // here by using the webpage objects, we intent to simplify the thing on how would the real website communicate with our backend service
        
        HomePage homePage = new HomePage();

        // now we will be starting with the various services using sample data



/*********************************************ADMIN SERVICES SAMPLE*********************************************/
        
        // we go to the admin login page, here we will get an AdminLoginPage object from the homepage
        AdminLogin adminLoginPage = homePage.adminLogin();

        // now we get (request) the admin creds
        Admin adminCreds = adminLoginPage.requestAdminLogin();

        // now we will create an AdminService object to perform each and every admin service and business logic
        AdminService adminService = new AdminService();

        AdminHomePage adminHomePage; // AdminHomePage object 

        // 1. Valid Admin Login
        try {                               // check for valid admin, if true, get the whole AdminHomePage object and flush the adminCreds object
            adminHomePage = adminService.isValidAdmin(adminCreds);
            adminCreds = null;
            adminLoginPage.responseAdminLogin("Admin Login Success:400");
        }
        catch (AdminNotFoundException e) {  // if admin not valid, send the response message to the webpage and flush the AdminHomePage object
            adminLoginPage.responseAdminLogin(e.getMessage());
            adminHomePage = null;
        }

        // now in admin home page, performing 4 feauters
        // a. Add Vendor
        Vendor vendor = adminHomePage.requestAddVendor();
        String response = adminService.addVendor(vendor);
        adminHomePage.responseAddVendor(response);

        // b. View Vendor
        List<Vendor> vendorList = adminService.viewVendor();
        adminHomePage.viewVendor(vendorList);
        
        // c. View User Resistration
        List<User> userList = adminService.viewUserRegistrations();
        adminHomePage.viewUserRegistrations(userList);
        User user = adminHomePage.statusButtonToggled();
        response = adminService.activateUser(user.getUserId());
        adminHomePage.statusChanged(response);

        // d. Logout
        homePage = adminHomePage.logout(); // here on logout, it will take you to the home page and destroy the admin data from the adminhomepage this part is implemented in the Front-End



/*********************************************VENDOR SERVICES SAMPLE*********************************************/
        
        // we go to the vendor login page, here we will get an VendorLoginPage object from the homepage
        VendorLogin vendorLoginPage = homePage.venderLogin();

        // now we get (request) the vendor creds
        Vendor vendorCreds = vendorLoginPage.requestVendorLogin();

        // now we will create an VendorService object to perform each and every vendor service and business logic
        VendorService vendorService = new VendorService();

        VendorHomePage vendorHomePage; // VendorHomePage object 

        // 2. Valid Vendor Login
        try {                               // check for valid vendor, if true, get the whole VendorHomePage object and flush the vendorCreds object
            vendorHomePage = vendorService.isValidVendor(vendorCreds);
            vendorCreds = null;
            vendorLoginPage.responseVendorLogin("vendor Login Success:400");
        }
        catch (VendorNotFoundException e) {  // if admin not valid, send the response message to the webpage and flush the AdminHomePage object
            vendorLoginPage.responseVendorLogin(e.getMessage());
            vendorHomePage = null;
        }

        // now in vendor home page, performing 4 feauters
        // a. Add Package
        Package pckage = vendorHomePage.requestAddPackage();
        response = vendorService.addPackage(pckage);
        vendorHomePage.responseAddPackage(response);

        // b. View User Request
        List<PlanRequest> userRequestsList = vendorService.viewUserRequestsList();
        vendorHomePage.viewUserRequestsList(userRequestsList);
        // create quotation
        PlanRequest planRequest = vendorHomePage.createQuotationToggled();
        Quotation quotation = vendorHomePage.requestCreateQuotation(planRequest);
        response = vendorService.createQuotation(quotation);
        vendorHomePage.responseCreateQuotation(response);

        // c. Change Password
        vendor = vendorHomePage.getVendor();
        String currentPassword = vendorHomePage.requestChangePasswordCurrent();
        String newPassword = vendorHomePage.requestChangePasswordNew();
        response = "";
        try {
            response = vendorService.changePassword(vendor.getVendorId(), currentPassword, newPassword);
        } catch (IncorrectPassword e) {
            response = e.getMessage();
        }
        vendorHomePage.responseChangePassword(response);

        // d. Profile
        vendorHomePage.showProfile();

        // // e. Logout
        homePage = vendorHomePage.logout(); // here on logout, it will take you to the home page and destroy the vendor data from the adminhomepage this part is implemented in the Front-End


            
/*********************************************USER SERVICES SAMPLE*********************************************/
        
        // we go to the user login page, here we will get an UserLoginPage object from the homepage
        UserLogin userLoginPage = homePage.userLogin();

        // now we get (request) the user creds
        User userCreds = userLoginPage.requestUserLogin();

        // now we will create an UserService object to perform each and every user service and business logic
        UserService userService = new UserService();

        UserHomePage userHomePage; // UserHomePage object 

        // 3. Valid User Login
        try {  // check for valid user, if true, get the whole UserHomePage object and flush the userCreds object
            userHomePage = userService.isValidUser(userCreds);
            userCreds = null;
            userLoginPage.responseUserLogin("User Login Success:400");
        }
        catch (UserNotFoundException e) {  // if user not valid, send the response message to the webpage and flush the UserHomePage object
            userLoginPage.responseUserLogin(e.getMessage());
            userHomePage = null;
        }
        
        // now in user home page, performing 4 feauters
        // a. Profile
        userHomePage.showProfile();
        user = userHomePage.editToggeled();
        User userNewData = userHomePage.requestEditedDetails();
        response = userService.editUser(user.getUserId(), userNewData);
        userHomePage.responseEditedDetails(response);
        
        // b. Change Password
        user = userHomePage.getUser();
        currentPassword = userHomePage.requestChangePasswordCurrent();
        newPassword = userHomePage.requestChangePasswordNew();
        response = "";
        try {
            response = userService.changePassword(user.getUserId(), currentPassword, newPassword);
        } catch (IncorrectPassword e) {
            response = e.getMessage();
        }
        userHomePage.responseChangePassword(response);

        // c. Send Plan Request
        planRequest = userHomePage.requestPlanRequestData();
        user = userHomePage.getUser();
        response = userService.sendPlanRequest(planRequest, user.getUserId());
        userHomePage.responsePlanRequestData(response);

        // d. View Quotation for the plan requested by the particular user.
        user = userHomePage.getUser();
        List<Quotation> quotationList = userService.viewQuotation(user.getUserId());
        userHomePage.viewQuotation(quotationList);
        String quotationId = userHomePage.quotationStatus();
        String newStatus = userHomePage.requestQuotationStatus();
        response = userService.changeQuotationStatus(quotationId, newStatus);
        userHomePage.responseQuotationStatus(response);

        // // e. Logout
        homePage = userHomePage.logout(); // here on logout, it will take you to the home page and destroy the user data from the userhomepage this part is implemented in the Front-End


            
/*********************************************USER REGISTRATION SAMPLE*********************************************/
        
        // we go to the user registration page, here we will get an UserRegistrationPage object from the homepage
        UserRegistration userRegistrationPage = homePage.userRegistration();

        // now we get (request) the user data
        User userData = userRegistrationPage.requestUserData();

        // now we will create an UserService object to perform each and every user service and business logic
        userService = new UserService();

        // 4. Valid User Registration
        response = userService.registerUser(userData);
        userRegistrationPage.responseUserData(response);
        userRegistrationPage = null;
        homePage = new HomePage();
            
    }

}
