package com.elite.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.elite.beans.PlanRequest;
import com.elite.exceptions.PlanAlreadyRequested;

// PlanRequestStore Implementation class to define and initialize its various methods

public class PlanRequestStoreImpl implements PlanRequestStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public PlanRequestStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public List<PlanRequest> getAllUserRequests() {
        List<PlanRequest> userRequestsList = new ArrayList<PlanRequest>();
        String getAllUserRequests = "SELECT * FROM PLANREQUESTDATA";
        Statement stmt = JDBCConfiguration.createStatement(con);
        try{
            ResultSet rs = stmt.executeQuery(getAllUserRequests);
            while(rs.next()){
                String requestId = rs.getString(1);
                String userId = rs.getString(2);
                Date fromDate = rs.getDate(3);
                Date toDate = rs.getDate(4);
                List<String> listOfServices = Arrays.asList(rs.getString(5).split(","));
                int noOfPerson = rs.getInt(6);
                List<String> otherServices = Arrays.asList(rs.getString(7).split(","));
                userRequestsList.add(new PlanRequest(requestId, userId, fromDate, toDate, listOfServices, noOfPerson, otherServices));
            }
            return userRequestsList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addPlanRequest(PlanRequest planRequest) throws PlanAlreadyRequested {
        String insertPlanRequest = "INSERT INTO planrequestdata VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, insertPlanRequest);
        try{
            stmt.setString(1, planRequest.getRequestId());
            stmt.setString(2, planRequest.getUserId());
            stmt.setDate(3, new java.sql.Date(planRequest.getFromDate().getTime()));
            stmt.setDate(4, new java.sql.Date(planRequest.getToDate().getTime()));
            stmt.setString(5, planRequest.getListOfServices().toString());
            stmt.setInt(6, planRequest.getNoOfPerson());
            stmt.setString(7, planRequest.getOtherServices().toString());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new PlanAlreadyRequested("This plan has already been requested. Try changing request id.");
        }
    }
    
}
