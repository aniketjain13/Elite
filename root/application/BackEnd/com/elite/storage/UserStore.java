package com.elite.storage;

import java.util.List;

import com.elite.beans.User;
import com.elite.exceptions.UserAlreadyExist;
import com.elite.exceptions.UserInActive;

// UserStore interface and its various methods

public interface UserStore {
    public List<User> getUserRegistrations();
    public User getUserById(String userId); 
    public User getUserByUserName(String userName); 
    public void activateUser(String userId);
    public void editUser(String userId, User userNewData);
    public void changePassword(String userId, String newPassword);
    public void registerUser(User userData) throws UserAlreadyExist;
    public void checkUserStatus(String userId) throws UserInActive;
}
