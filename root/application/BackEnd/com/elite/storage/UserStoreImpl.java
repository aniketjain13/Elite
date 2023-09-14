package com.elite.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.elite.beans.User;
import com.elite.exceptions.UserAlreadyExist;
import com.elite.exceptions.UserInActive;
import com.mysql.cj.jdbc.JdbcConnection;

// UserStore Implementation class to define and initialize its various methods

public class UserStoreImpl implements UserStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public UserStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public List<User> getUserRegistrations() {
        List<User> userList = new ArrayList<User>();
        String getAllUserResgistrations = "SELECT * FROM USERDATA";
        Statement stmt = JDBCConfiguration.createStatement(con);
        try{
            ResultSet rs = stmt.executeQuery(getAllUserResgistrations);
            while(rs.next()){
                String userId = rs.getString(1);
                String fullName = rs.getString(2);
                String userName = rs.getString(3);
                String password = rs.getString(4);
                Date dateOfJoining = rs.getDate(5);
                Date dateOfBirth = rs.getDate(6);
                String department = rs.getString(7);
                String mobile = rs.getString(8);
                String email = rs.getString(9);
                String location = rs.getString(10);
                String status = rs.getString(11);
                userList.add(new User(userId, fullName, userName, password, dateOfJoining, dateOfBirth, department, mobile, email, location, status));
            }
            return userList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public User getUserById(String userId){
        User user = new User();
        String getUserById = "SELECT * FROM USERDATA WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getUserById);
        try{
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String fullName = rs.getString(2);
                String userName = rs.getString(3);
                String password = rs.getString(4);
                Date dateOfJoining = rs.getDate(5);
                Date dateOfBirth = rs.getDate(6);
                String department = rs.getString(7);
                String mobile = rs.getString(8);
                String email = rs.getString(9);
                String location = rs.getString(10);
                String status = rs.getString(11);
                user = new User(getUserById, fullName, userName, password, dateOfJoining, dateOfBirth, department, mobile, email, location, status);
            }
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        String getUserById = "SELECT * FROM USERDATA WHERE userName=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getUserById);
        try{
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String userId = rs.getString(1);
                String fullName = rs.getString(2);
                String password = rs.getString(4);
                Date dateOfJoining = rs.getDate(5);
                Date dateOfBirth = rs.getDate(6);
                String department = rs.getString(7);
                String mobile = rs.getString(8);
                String email = rs.getString(9);
                String location = rs.getString(10);
                String status = rs.getString(11);
                user = new User(userId, fullName, userName, password, dateOfJoining, dateOfBirth, department, mobile, email, location, status);
            }
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void activateUser(String userId) {

        String currectUserStatus = "SELECT status FROM USERDATA WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, currectUserStatus);
        try{
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                currectUserStatus = rs.getString(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        String activateUserById = "UPDATE USERDATA SET status=? WHERE userId=?";
        stmt = JDBCConfiguration.createPreparedStatement(con, activateUserById);
        try{
            if(currectUserStatus.equalsIgnoreCase("active"))
                stmt.setString(1, "inactive");
            else
                stmt.setString(1, "active");
            stmt.setString(2, userId);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(String userId, User userNewData) {
        String updateUser = "UPDATE USERDATA SET mobile=?, email=?, location=? WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, updateUser);
        try{
            stmt.setString(1, userNewData.getMobile());
            stmt.setString(2, userNewData.getEmail());
            stmt.setString(3, userNewData.getLocation());
            stmt.setString(4, userId);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        String updatePassword = "UPDATE USERDATA SET password=? WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, updatePassword);
        try{
            stmt.setString(1, newPassword);
            stmt.setString(2, userId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerUser(User userData) throws UserAlreadyExist{
        String insertUser = "INSERT INTO userdata VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, insertUser);
        try{
            stmt.setString(1, userData.getUserId());
            stmt.setString(2, userData.getFullName());
            stmt.setString(3, userData.getUserName());
            stmt.setString(4, userData.getPassword());
            stmt.setDate(5, new java.sql.Date(userData.getDateOfJoining().getTime()));
            stmt.setDate(6, new java.sql.Date(userData.getDateOfBirth().getTime()));
            stmt.setString(7, userData.getDepartment());
            stmt.setString(8, userData.getMobile());
            stmt.setString(9, userData.getEmail());
            stmt.setString(10, userData.getLocation());
            stmt.setString(11, userData.getStatus());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new UserAlreadyExist("This UserName is taken please try new username. ");
        }
    }

    @Override
    public void checkUserStatus(String userId) throws UserInActive {
        String getStatus = "Select status from USERDATA WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getStatus);
        try{
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            String status = rs.getString(1);
            if(status.equalsIgnoreCase("inactive")){
                throw new UserInActive("This user is not active please get your account activated to send plan request.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
