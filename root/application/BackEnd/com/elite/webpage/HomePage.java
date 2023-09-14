package com.elite.webpage;

import com.elite.webpage.adminpages.AdminLogin;
import com.elite.webpage.userpages.UserLogin;
import com.elite.webpage.userpages.UserRegistration;
import com.elite.webpage.vendorpages.VendorLogin;

// Homepage and its methods

public class HomePage {

    public AdminLogin adminLogin(){
        return new AdminLogin();
    }

    public VendorLogin venderLogin(){
        return new VendorLogin();
    }

    public UserLogin userLogin(){
        return new UserLogin();
    }

    public UserRegistration userRegistration(){
        return new UserRegistration();
    }
    
}
