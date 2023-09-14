package com.elite.webpage.vendorpages;

import com.elite.beans.Vendor;

// VendorLogin and its various methods

public class VendorLogin {
    
    public Vendor requestVendorLogin(){
        return new Vendor("V1", "passwordpassword");
    }
    
    public void responseVendorLogin(String msg){
        System.out.println(msg);
    }

}
