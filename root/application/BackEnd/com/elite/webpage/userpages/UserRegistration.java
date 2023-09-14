package com.elite.webpage.userpages;

import java.util.Date;

import com.elite.beans.User;

// UserRegistration class and its various methods

public class UserRegistration {

    public User requestUserData() {
        return new User("user1234486", "John Doe", "johndoe12853", "password123", new Date(), new Date(), "IT Department", "123-456-7890", "john@example.com", "New York");
    }

    public void responseUserData(String response) {
        System.out.println(response);
    }
    
}
