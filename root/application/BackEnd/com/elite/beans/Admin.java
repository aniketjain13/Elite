package com.elite.beans;

public class Admin {
    
    // Admin data (class members)
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private String mobile;

    // class construcors
    public Admin(String userName, String fullName, String password, String email, String mobile) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }
    public Admin(String userName, String password){
        this.userName = userName;
        this.fullName = "";
        this.password = password;
        this.email = "";
        this.mobile = "";
    }
    public Admin() {
        this.userName = "";
        this.fullName = "";
        this.password = "";
        this.email = "";
        this.mobile = "";
    }

    // class getter setter methods
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // class tostring method 
    @Override
    public String toString() {
        return "Admin [userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", email=" + email
                + ", mobile=" + mobile + "]";
    }
    public String toStringNoPassword() {
        return "Admin [userName=" + userName + ", fullName=" + fullName + ", email=" + email
                + ", mobile=" + mobile + "]";
    }
}