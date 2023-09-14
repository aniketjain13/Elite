package com.elite.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanRequest {
    
    // PlanRequest data (class members)
    private String requestId;
    private String userId;
    private Date fromDate;
    private Date toDate;
    private List<String> listOfServices;
    private int noOfPerson;
    private List<String> otherServices;

    // class constructors
    public PlanRequest(String requestId, String userId, Date fromDate, Date toDate, List<String> listOfServices, int noOfPerson, List<String> otherServices) {
        this.requestId = requestId;
        this.userId = userId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.listOfServices = listOfServices;
        this.noOfPerson = noOfPerson;
        this.otherServices = otherServices;
    }
    public PlanRequest() {
        this.requestId = "";
        this.userId = "";
        this.fromDate = new Date();
        this.toDate = new Date();
        this.listOfServices = new ArrayList<String>();
        this.noOfPerson = 0;
        this.otherServices = new ArrayList<String>();
    }

    // class getter setters
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<String> getListOfServices() {
        return listOfServices;
    }
    public void setListOfServices(List<String> listOfServices) {
        this.listOfServices = listOfServices;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }
    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public List<String> getOtherServices() {
        return otherServices;
    }
    public void setOtherServices(List<String> otherServices) {
        this.otherServices = otherServices;
    }

    // class to string method
    @Override
    public String toString() {
        return "PlanRequest [requestId=" + requestId + ", userId=" + userId + ", fromDate=" + fromDate + ", toDate=" + toDate
                + ", listOfServices=" + listOfServices + ", noOfPerson=" + noOfPerson + ", otherServices="
                + otherServices + "]";
    }
}
