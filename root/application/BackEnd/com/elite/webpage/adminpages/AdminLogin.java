package com.elite.webpage.adminpages;

import com.elite.beans.Admin;

// AdminLoginPage and its various methods

public class AdminLogin {

    public Admin requestAdminLogin(){
        return new Admin("aniketadmin", "eliteadmin");
    }
    
    public void responseAdminLogin(String msg){
        System.out.println(msg);
    }
    
}
