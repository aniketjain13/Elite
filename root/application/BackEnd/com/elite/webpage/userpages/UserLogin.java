package com.elite.webpage.userpages;

import com.elite.beans.User;

// UserLogin class and its various methods

public class UserLogin {
    public User requestUserLogin(){
        return new User("johndoe123", "passwordpassword");
    }
    
    public void responseUserLogin(String msg){
        System.out.println(msg);
    }
}
