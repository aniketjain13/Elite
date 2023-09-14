package com.elite.beans;

import java.util.Date;

public class User {

    // User data (class members)
    private String userId;
    private String fullName;
    private String userName;
    private String password;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private String department;
    private String mobile;
    private String email;
    private String location;
    private String status;
    
    // class constructors
    public User(String userId, String fullName, String userName, String password, Date dateOfJoining, Date dateOfBirth, String department, String mobile, String email, String location, String status) {
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.mobile = mobile;
        this.email = email;
        this.location = location;
        this.status = status;
    }
    public User(String userId, String fullName, String userName, String password, Date dateOfJoining, Date dateOfBirth, String department, String mobile, String email, String location) {
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.mobile = mobile;
        this.email = email;
        this.location = location;
        this.status = "inactive";
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public User(String mobile, String email, String location) {
        this.mobile = mobile;
        this.email = email;
        this.location = location;
    }
    public User() {
        this.userId = "";
        this.fullName = "";
        this.userName = "";
        this.password = "";
        this.dateOfJoining = new Date();
        this.dateOfBirth = new Date();
        this.department = "";
        this.mobile = "";
        this.email = "";
        this.location = "";
        this.status = "";
    }

    // class getter setters
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    // class to string method
    @Override
    public String toString() {
        return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
                + ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", department=" + department
                + ", mobile=" + mobile + ", email=" + email + ", location=" + location + ", status=" + status + "]";
    }
    public String toStringNoPassword() {
        return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", department=" + department
                + ", mobile=" + mobile + ", email=" + email + ", location=" + location + ", status=" + status + "]";
    }
    
}
